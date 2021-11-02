package ru.aniks.syncdata;

import static java.lang.System.out;

class Sync2
{
	private int counter = 0;
	
	public synchronized void increment() 
	{
		counter++;
	}
	
	public int getCounter()
	{
		return counter;
	}
}



public class Program {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		class Sync
		{
			public volatile int counter = 0;
		}
		
		//final Sync s = new Sync();
		Sync2 s = new Sync2();

		Thread t0 = new Thread(
			() -> {
				for(int i = 1; i <= 10000; i++) {
					//out.printf("%s : %d\n", Thread.currentThread().getName(), i);
					//synchronized(s) 
					{
						//s.counter++;
						s.increment();
					}
				}
			}
		);
		Thread t1 = new Thread(
			() -> {
				for(int i = 1; i <= 10000; i++) {
					//out.printf("%s : %d\n", Thread.currentThread().getName(), i);
					//synchronized(s) 
					{
						//s.counter++;
						s.increment();
					}
				}
			}
		);
		
		t0.start();
		t1.start();
		
		t0.join();
		t1.join();
		
		//out.println(s.counter);
		out.println(s.getCounter());
	}

}
