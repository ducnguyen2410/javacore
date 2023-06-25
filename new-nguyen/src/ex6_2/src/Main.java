package ex6_2.src;

import ex6_2.src.org.processor.DataFilter;
import ex6_2.src.org.processor.FileReader;
import ex6_2.src.org.processor.FileWriter;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author 404NotFound
 */
public class Main {
	static final String inputFilePath = "C:\\Users\\Nguyen\\IdeaProjects\\javacore\\new-nguyen\\src\\ex6\\input\\input.txt";
	static final String successOutputFile = "C:\\Users\\Nguyen\\IdeaProjects\\javacore\\new-nguyen\\src\\ex6\\input\\dung.txt";
	static final String failedOutputFile = "C:\\Users\\Nguyen\\IdeaProjects\\javacore\\new-nguyen\\src\\ex6\\input\\sai.txt";
	
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		BlockingQueue<String> dataQueue = new ArrayBlockingQueue<>(1000000, true);
		
		FileReader reader = new FileReader(inputFilePath, dataQueue);
		DataFilter checker = new DataFilter(dataQueue);
		
		BlockingQueue<String> successOutputQueue = checker.getSuccessData();
		BlockingQueue<String> failedOutputQueue = checker.getFailedData();
		
		FileWriter writeSuccessData = new FileWriter(successOutputFile, successOutputQueue);
		FileWriter writeFailedData = new FileWriter(failedOutputFile, failedOutputQueue);
		
		new Thread(reader).start();
		new Thread(checker).start();
		new Thread(writeSuccessData).start();
		new Thread(writeFailedData).start();
		long endTime = System.nanoTime();
		System.out.println("The program executed in " + TimeUnit.NANOSECONDS.toMillis(endTime-startTime) + " milliseconds");
	}
}
