package ru.aniks.d1l3;

import static java.lang.System.out;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		class Sync
		{
			public int counter;
			volatile double x = 1d;
			volatile boolean flag = true;
		}
		
		Sync s = new Sync();
		
		Thread t0 = new Thread(
			() -> {
				for(int i = 1; i <= 100; i++) {
					synchronized(s) 
					{
						while(!s.flag) {
							try {
								s.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}						
						}
						s.x = Math.sin(s.x);
						out.println(s.x);
						s.flag = false;
						s.notify();
					}

				}
			}
			);
		
		Thread t1 = new Thread(
			() -> {
				for(int i = 1; i <= 100; i++) {
					synchronized(s) 
					{
						while(s.flag) {
							try {
								s.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}						
						}
						s.x = Math.asin(s.x);
						out.println(s.x);
						s.flag = true;
						s.notify();
					}

				}
			}
			);
		t0.start();
		t1.start();
		
		
	}

}
