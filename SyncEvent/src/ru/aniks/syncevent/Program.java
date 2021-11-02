package ru.aniks.syncevent;

import static java.lang.System.out;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object s = new Object();
		
		class Sync
		{
			public int counter;
		}
		
		Sync s1 = new Sync();
		
		Thread t0 = new Thread(
			() -> {
				for(int i = 1; i <= 100; i++) {
					out.printf("%s : %d\n", Thread.currentThread().getName(), i);
					synchronized(s1) 
					{
						s1.counter = i;
						s1.notify();
						//s1.notifyAll();
					}
					//if(i == 50) 
					//{
					//	synchronized(s)
					//	{
					//		s.notify();
					//	}
					//}
				}
			}
		);
		
		Thread t1 = new Thread(
			() -> {
				
				try {
					synchronized(s1)
					{
						while (s1.counter < 50) {
							s1.wait();
						//s.wait();
						}
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int i = 1; i <= 100; i++) {
					out.printf("%s : %d\n", Thread.currentThread().getName(), i);
				}
			}
		);
		
		
		//Thread.currentThread().join(); //deadlock
		t0.start();
		t1.start();
	}

}
