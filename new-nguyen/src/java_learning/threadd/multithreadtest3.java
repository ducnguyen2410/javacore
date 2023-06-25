package java_learning.threadd;

import jdk.jshell.execution.LoaderDelegate;

import java.awt.desktop.PrintFilesHandler;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class LoadDauVao implements Runnable {
	BlockingQueue<Integer> listInteger;
	public LoadDauVao(BlockingQueue<Integer> listInteger) {
		this.listInteger = listInteger;
	}
	
	@Override
	synchronized public void run() {
		for(int i = 0; i < 10; i++) {
			try {
				listInteger.put(i);
				System.out.println("Loaded " + i + " inside the queue");
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class XuLiQueue implements Runnable {
	BlockingQueue<Integer> listInteger;
	
	public XuLiQueue(BlockingQueue<Integer> listInteger) {
		this.listInteger = listInteger;
	}
	
	@Override
	public void run() {
		Integer element;
		for (int i = 0; i < 10; i++) {
			try {
				element = listInteger.take();
				System.out.println("Consumed " + element + " in the queue");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


public class multithreadtest3 {
	public static void main(String[] args) {
		System.out.println("Starting...");
		BlockingQueue<Integer> listInteger = new ArrayBlockingQueue<>(1024);
		LoadDauVao loadDauVao = new LoadDauVao(listInteger);
		XuLiQueue xuLiQueue = new XuLiQueue(listInteger);
		new Thread(loadDauVao).start();
		new Thread(xuLiQueue).start();
		System.out.println("Finished ");
	}
}
