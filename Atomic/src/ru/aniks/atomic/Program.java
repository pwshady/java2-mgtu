package ru.aniks.atomic;

import static java.lang.System.out;
import java.util.concurrent.atomic.AtomicInteger;

public class Program {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		AtomicInteger c = new AtomicInteger();
		
		Thread t0 = new Thread(
			() -> {
				for(int i = 1; i <= 10000; i++)
				{
					c.incrementAndGet();
				}
			}
		);
		
		Thread t1 = new Thread(
			() -> {
				for(int i = 1; i <= 10000; i++)
				{
					c.incrementAndGet();
				}
			}
		);
		
		t0.start();
		t1.start();
		
		t0.join();
		t1.join();
		
		out.println(c.get());
		
	}

}
