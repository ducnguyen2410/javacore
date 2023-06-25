/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex6_2.src.org.processor;

import ex6_2.src.org.common.AppLogger;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.regex.Pattern;

/**
 * @author 404NotFound
 */
public class DataFilter implements Runnable {
	
	private static final Pattern pattern = Pattern.compile("84\\d+\\|[a-zA-Z0-9., ]+\\|[\\d//]+ [\\d:]+");
	private final BlockingQueue<String> inputData;
	private final BlockingQueue<String> successData = new ArrayBlockingQueue<>(1024, true);
	private final BlockingQueue<String> failedData = new ArrayBlockingQueue<>(1024, true);
	private static final String[] EXCEPT_WORD = {"fuck", "DCM", "shit"};
	
	public DataFilter(BlockingQueue<String> inputData) {
		this.inputData = inputData;
	}
	
	@Override
	public void run() {
		String s = "";
		while (true) {
			try {
				s = inputData.take();
			} catch (InterruptedException ex) {
				AppLogger.getInstance().error(ex.getMessage());
			}
			AppLogger.getInstance().debug("Checking String: " + s);
			if (pattern.matcher(s).matches() && !stringContainsItemFromList(s, EXCEPT_WORD)) {
				AppLogger.getInstance().debug("Sucess String: " + s);
				successData.offer(s);
			} else {
				failedData.offer(s);
				AppLogger.getInstance().debug("Failed String: " + s);
			}
		}
	}
	
	private boolean stringContainsItemFromList(String inputString, String[] items) {
		for (String item : items) {
			if (inputString.contains(item)) {
				return true;
			}
		}
		return false;
	}
	
	public BlockingQueue<String> getSuccessData() {
		return successData;
	}
	
	public BlockingQueue<String> getFailedData() {
		return failedData;
	}
}
