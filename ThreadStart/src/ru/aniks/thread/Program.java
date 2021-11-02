package ru.aniks.thread;

import static java.lang.System.out;

class MyThread extends Thread{
	@Override
	public void run() {
		for(int i = 1; i < 10; i++) {
			out.printf("%s : %d\n", getName(), i);
		}
	}
}

class MySuperThread implements Runnable{
	@Override
	public void run() {
		for(int i = 1; i < 10; i++) {
			out.printf("%s : %d\n", Thread.currentThread().getName(), i);
		}
	}
}

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyThread t0 = new MyThread();
		MyThread t1 = new MyThread();
		
		Thread t2 = new Thread(new MySuperThread());
		
		Thread t3 = new Thread(
				new Runnable() {
					@Override
					public void run() {
						for(int i = 1; i < 10; i++) {
							out.printf("%s : %d\n", Thread.currentThread().getName(), i);
						}
					}
				});
		
		Thread t4 = new Thread(
				() ->{
						for(int i = 1; i < 10; i++) {
							out.printf("%s : %d\n", Thread.currentThread().getName(), i);
						}
					}
				);
		
		t0.start();
		t1.start();
		
		t2.start();
		
		t3.start();
		
		out.println(Thread.currentThread().getState());
		
		t4.start();
		
		out.println(Thread.currentThread().getName());
	}

}
