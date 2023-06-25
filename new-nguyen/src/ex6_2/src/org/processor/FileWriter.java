/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex6_2.src.org.processor;

import ex6_2.src.org.common.AppLogger;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

/**
 * @author 404NotFound
 */
public class FileWriter implements Runnable {
	
	private final String filePath;
	private final BlockingQueue<String> data;
	
	public FileWriter(String filePath, BlockingQueue<String> data) {
		this.filePath = filePath;
		this.data = data;
	}
	
	@Override
	public void run() {
		while (true) {
			String s = "";
			try {
				s = data.take();
			} catch (InterruptedException ex) {
				AppLogger.getInstance().error(ex.getMessage());
			}
			try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(filePath, true))) {
				AppLogger.getInstance().debug("Writing data: " + s + " to file: " + filePath);
				writer.write(s + "\n");
			} catch (IOException ex) {
				AppLogger.getInstance().error(ex.getMessage());
			}
		}
	}
	
}
