package ru.aniks.interrupt;

import static java.lang.System.out;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t0 = new Thread(
			() ->{
				for(int i = 1; i < 100; i++) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (Thread.interrupted()) {
						out.printf("%s : interrupted\n", Thread.currentThread().getName(), i);
						return;
					}
					out.printf("%s : %d\n", Thread.currentThread().getName(), i);
				}
			}
		);
		
		t0.start();
		t0.interrupt();
		
		System.out.println("main");
	}

}
