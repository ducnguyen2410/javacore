package ex6.resources.functions;

import ex6.resources.classes.InputFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
public class FilterFile implements Runnable{
	final static String[] listBlockedWords = {"fuck", "shit", "DCM"};
	
	private BlockingQueue<InputFormat> listCorrect;
	private BlockingQueue<InputFormat> listIncorrect;
	private List<InputFormat> mainList;
	
	public FilterFile(BlockingQueue<InputFormat> listCorrect, BlockingQueue<InputFormat> listIncorrect, List<InputFormat> mainList) {
		this.listCorrect = listCorrect;
		this.listIncorrect = listIncorrect;
		this.mainList = mainList;
	}
	
	@Override
	public void run() {
		try {
			for (InputFormat i : mainList) {
				if (isCorrectMessage(i)) {
					listCorrect.put(i);
				} else {
					listIncorrect.put(i);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isCorrectMessage(InputFormat inputFormat) {
		String text = inputFormat.getText();
		LocalDateTime rightNow = LocalDateTime.now();
		if(inputFormat.getTime().compareTo(rightNow) > 0) return false;
		for(String i: listBlockedWords) {
			if(text.contains(i)) return false;
		}
		return true;
	}
}
