package ex6;

import ex6.resources.classes.InputFormat;
import ex6.resources.functions.FilterFile;
import ex6.resources.functions.ReadFile;
import ex6.resources.functions.WriteFile;
import java.util.List;
import java.util.concurrent.*;

public class Main {
	public static void main(String[] args) throws ExecutionException, InterruptedException{
		String pathInput = "C:\\Users\\Nguyen\\IdeaProjects\\javacore\\new-nguyen\\src\\ex6\\input\\input.txt";
		String pathOutput = "C:\\Users\\Nguyen\\IdeaProjects\\javacore\\new-nguyen\\src\\ex6\\output\\";
		BlockingQueue<InputFormat> listCorrect = new ArrayBlockingQueue<>(1024);
		BlockingQueue<InputFormat> listIncorrect = new ArrayBlockingQueue<>(1024);
		long startTime = System.nanoTime();
		ReadFile readFile = new ReadFile(pathInput);
		ExecutorService executor = Executors.newCachedThreadPool();
		Future<List<InputFormat>> future = executor.submit(readFile);
		List<InputFormat> listInput;
		listInput = future.get();
		
		FilterFile filterFile = new FilterFile(listCorrect, listIncorrect, listInput);
		WriteFile writeFile = new WriteFile(listCorrect,listIncorrect, pathOutput+"dung.txt",pathOutput+"sai.txt");
		executor.execute(filterFile);
		executor.execute(writeFile);
		long endTime = System.nanoTime();
		System.out.println("The program executed in " + TimeUnit.NANOSECONDS.toMillis(endTime-startTime) + " milliseconds");
	}
}
