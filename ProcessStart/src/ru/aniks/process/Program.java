package ru.aniks.process;

import java.io.IOException;

public class Program {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Sterting external app..");
		
		Runtime.getRuntime().exec("explorer.exe");
	}

}
