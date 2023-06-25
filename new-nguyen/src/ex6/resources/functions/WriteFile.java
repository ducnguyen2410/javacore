package ex6.resources.functions;

import ex6.resources.classes.InputFormat;

import java.io.*;
import java.util.concurrent.BlockingQueue;

public class WriteFile implements Runnable{
	private BlockingQueue<InputFormat> listOutput;
	private String pathOutput;
	private StringBuilder sBuilder = new StringBuilder();
	
	public WriteFile(BlockingQueue<InputFormat> listOutput, String pathCorrect) {
		this.listOutput = listOutput;
		this.pathOutput = pathCorrect;
	}
	
	@Override
	public void run(){
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(pathOutput, true));
			while (true) {
				try {
					InputFormat element = listOutput.take();
					String line = sBuilder.append(element.getPhoneNumber())
							.append("|").append(element.getText())
							.append("|").append(element.getTime()).toString();
					writer.write(line + "\n");
					writer.flush();
					sBuilder = new StringBuilder();
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
