package java_learning.threadd;

class MultithreadingDemo extends Thread {
	public void run() {
		try {
			System.out.println("Thread " + Thread.currentThread().getId() +" is running.");
		}catch (Exception e) {
			System.out.println("Exception is caught");
		}
	}
}
public class multith2 {
	public static void main(String[] args) {
		int n = 8;
		for(int i = 0; i < n; i++) {
			MultithreadingDemo object = new MultithreadingDemo();
			object.start();
		}
	}
}
