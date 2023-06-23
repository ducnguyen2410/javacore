package ex6.resources.functions;

import ex6.resources.classes.InputFormat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.regex.Pattern;

public class ReadFile implements Callable<List<InputFormat>> {
	private final String pathInput;
	private final static Pattern phoneNumberRegex = Pattern.compile("\\d+");
	private final static Pattern textRegex = Pattern.compile("[A-Za-z0-9/:. ]+");
	
	public ReadFile(String pathInput) {
		this.pathInput = pathInput;
	}
	public boolean isValidMessage(String line) {
		String[] listElements = line.split("\\|");
		if(listElements.length == 3) {
			if(phoneNumberRegex.matcher(listElements[0]).matches()) {
				for(int i = 1; i < 3; i++) {
					if(!textRegex.matcher(listElements[i]).matches()) return false;
				}
				return true;
			}
		}
		return false;
	}
	
	@Override
	public List<InputFormat> call() throws Exception {
		List<InputFormat> listInput = new ArrayList<>();
		try(BufferedReader reader = new BufferedReader(new FileReader(pathInput))) {
			String line;
			while((line = reader.readLine()) != null) {
				if (isValidMessage(line)) {
					String[] listElements = line.split("\\|");
					listInput.add(new InputFormat(listElements[0],listElements[1],listElements[2]));
				}
				Thread.sleep(10);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listInput;
	}
}
