package ex6.resources.classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class InputFormat {
	private String phoneNumber;
	private String text;
	private LocalDateTime time;
	
	private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	
	public InputFormat(String phoneNumber, String text, String time) {
		this.phoneNumber = phoneNumber;
		this.text = text;
		this.time = LocalDateTime.parse(time, formatter);
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getText() {
		return text;
	}
	
	public LocalDateTime getTime() {
		return time;
	}
	
	public String toString() {
		return new StringBuilder(this.phoneNumber)
				.append("|").append(this.text)
				.append("|").append(this.time).toString();
	}
}
