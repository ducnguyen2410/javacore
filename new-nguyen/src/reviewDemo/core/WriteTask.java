package reviewDemo.core;

import reviewDemo.model.Alert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.Buffer;
import java.util.concurrent.BlockingQueue;

public class WriteTask implements Runnable{
	private final BlockingQueue<Alert> alertQueue;
	private final File file;
	private StringBuilder sBuilder = new StringBuilder();
	
	public WriteTask(BlockingQueue<Alert> alertQueue, File file) {
		this.alertQueue = alertQueue;
		this.file = file;
	}
	
	@Override
	public void run() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
			Alert alert;
			while(true) {
				while((alert = alertQueue.poll()) != null) {
					sBuilder.append(alert.toString() + "\n");
				}
				writer.write(sBuilder.toString());
				writer.flush();
				sBuilder = new StringBuilder();
				Thread.sleep(500);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
