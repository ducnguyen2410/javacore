/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex6_2.src.org.common;

/**
 * @author kiempq
 */
public class AppLogger {
	
	private static AppLogger instance = null;
	private int level;
	
	public final static int ALL = 0;
	public final static int DEBUG = 1;
	public final static int WARM = 2;
	public final static int INFO = 3;
	public final static int ERROR = 4;
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public static AppLogger getInstance() {
		if (instance == null) {
			instance = new AppLogger();
		}
		return instance;
	}
	
	public void info(String logs) {
		if (this.level <= AppLogger.INFO) {
			System.out.println("INFO-" + ":" + logs);
		}
	}
	
	public void debug(String logs) {
		if (this.level <= AppLogger.DEBUG) {
			System.out.println("DEBUG-" + ":" + logs);
		}
	}
	
	public void error(String logs) {
		if (this.level <= AppLogger.ERROR) {
			System.out.println("ERROR-" + ":" + logs);
		}
	}
	
	public void warm(String logs) {
		if (this.level <= AppLogger.WARM) {
			System.out.println("WARM-" + ":" + logs);
		}
	}
	
}
