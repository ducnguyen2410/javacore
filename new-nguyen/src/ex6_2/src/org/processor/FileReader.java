/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex6_2.src.org.processor;

import ex6_2.src.org.common.AppLogger;

import java.io.BufferedReader;
import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * @author 404NotFound
 */
public class FileReader implements Runnable {
	private String filePath;
	private BlockingQueue<String> outputData;
	
	public FileReader(String filePath, BlockingQueue<String> outputData) {
		this.filePath = filePath;
		this.outputData = outputData;
	}
	
	@Override
	public void run() {
		File file = new File(filePath);
		if (file.exists()) {
			AppLogger.getInstance().debug("Reading file" + filePath);
			try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
				String s = "";
				while ((s = reader.readLine()) != null) {
					outputData.offer(s);
				}
			} catch (Exception e) {
				AppLogger.getInstance().error(e.getMessage());
			}
			AppLogger.getInstance().debug("File" + filePath + "readed");
		} else {
			AppLogger.getInstance().debug("File doesn't exist");
		}
	}
}
