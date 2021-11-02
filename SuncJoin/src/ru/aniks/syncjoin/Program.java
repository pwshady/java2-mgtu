package ru.aniks.syncjoin;

import static java.lang.System.out;

public class Program {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread t0 = new Thread(
				() ->{
						for(int i = 1; i < 100; i++) {
							out.printf("%s : %d\n", Thread.currentThread().getName(), i);
						}
					}
				);
		t0.start();
		
		//Thread.sleep(1000);
		t0.join();
		
		out.println(Thread.currentThread().getName());
	}

}
