package ex6.resources.functions;

import ex6.resources.classes.InputFormat;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.concurrent.BlockingQueue;

public class WriteFile implements Runnable{
	private BlockingQueue<InputFormat> listCorrect;
	private BlockingQueue<InputFormat> listIncorrect;
	private String pathCorrect;
	private String pathIncorrect;
	private StringBuilder sBuilder = new StringBuilder();
	
	public WriteFile(BlockingQueue<InputFormat> listCorrect, BlockingQueue<InputFormat> listIncorrect, String pathCorrect, String pathIncorrect) {
		this.listCorrect = listCorrect;
		this.listIncorrect = listIncorrect;
		this.pathCorrect = pathCorrect;
		this.pathIncorrect = pathIncorrect;
	}
	
	@Override
	public void run() {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(pathCorrect))) {
			for(InputFormat i: listCorrect) {
				sBuilder.append(i.toString()+"\n");
			}
			writer.write(sBuilder.toString());
			writer.flush();
			sBuilder = new StringBuilder();
			Thread.sleep(500);
		}catch (Exception e) {
			e.printStackTrace();
		}
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(pathIncorrect))) {
			for(InputFormat i: listIncorrect) {
				sBuilder.append(i.toString()+"\n");
			}
			writer.write(sBuilder.toString());
			writer.flush();
			sBuilder = new StringBuilder();
			Thread.sleep(500);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
