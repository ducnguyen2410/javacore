package reviewDemo.core;

import reviewDemo.model.Area;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.regex.Pattern;

public class ReadAreaTask implements Callable<List<Area>>, IReadOperation {
	private final File file;
	private final static Pattern wordPattern = Pattern.compile("[A-Za-z0-9 ]+");
	private final static Pattern digitPattern = Pattern.compile("\\d+");
	
	public ReadAreaTask(File file) {
		this.file = file;
	}
	
	public List<Area> call() {
		List<Area> areaList = new ArrayList<>();
		try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String s;
			Area area;
			while((s = reader.readLine()) != null) {
				if(isRightString(s)) {
					area = parse(s);
					System.out.println(area.getAreaName());
					areaList.add(area);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return areaList;
	}
	
	public Area parse(String s) {
		String[] arr = s.split("\\|");
		String areaName = arr[0];
		long longLeft = Long.parseLong(arr[1]);
		long longRight = Long.parseLong(arr[2]);
		long latTop = Long.parseLong(arr[3]);
		long latBottom = Long.parseLong(arr[4]);
		Area area = new Area(areaName,latTop,latBottom,longLeft,longRight);
		return area;
	}
	public boolean isRightString(String s) {
		String[] arr = s.split("\\|");
		if(arr.length == 5) {
			if(wordPattern.matcher(arr[0]).matches()) {
				for(int i = 1; i < 5; i++) {
					if(!digitPattern.matcher(arr[i]).matches()) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
}
