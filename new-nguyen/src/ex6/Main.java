package ex6;

import ex6.resources.classes.InputFormat;
import ex6.resources.functions.FilterFile;
import ex6.resources.functions.ReadFile;
import ex6.resources.functions.WriteFile;
import java.util.concurrent.*;

public class Main {
	public static void main(String[] args) throws ExecutionException, InterruptedException{
		String pathInput = "C:\\Users\\Nguyen\\IdeaProjects\\javacore\\new-nguyen\\src\\ex6\\input\\input.txt";
		String pathOutput = "C:\\Users\\Nguyen\\IdeaProjects\\javacore\\new-nguyen\\src\\ex6\\output\\";
		
		BlockingQueue<InputFormat> listCorrect = new ArrayBlockingQueue<>(1024, true);
		BlockingQueue<InputFormat> listIncorrect = new ArrayBlockingQueue<>(1024, true);
		BlockingQueue<InputFormat> listInput = new ArrayBlockingQueue<>(1000000, true);
		
		long startTime = System.nanoTime();
		
		ReadFile readFile = new ReadFile(pathInput, listInput);
		FilterFile filterFile = new FilterFile(listCorrect, listIncorrect, listInput);
		
		WriteFile writeFileCorrect = new WriteFile(listCorrect, pathOutput+"dung.txt");
		WriteFile writeFileIncorrect = new WriteFile(listIncorrect, pathOutput+"sai.txt");
		
		new Thread(readFile).start();
		new Thread(filterFile).start();
		new Thread(writeFileCorrect).start();
		new Thread(writeFileIncorrect).start();
		
		long endTime = System.nanoTime();
		
		System.out.println("The program executed in " + TimeUnit.NANOSECONDS.toMillis(endTime-startTime) + " milliseconds");
	}
}
