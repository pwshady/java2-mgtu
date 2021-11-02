package ru.aniks.d1l2;

import static java.lang.System.out;

class MySuperThread implements Runnable{
	private int a = 0;
	private int b = 0;

	public MySuperThread(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public MySuperThread(int a, int b, Thread t) throws InterruptedException {
		this.a = a;
		this.b = b;
		t.start();
		t.join();
	}
	
	@Override
	public void run() {
		for(int i = this.a; i < this.b; i++) {
			out.printf("%s : %d\n", Thread.currentThread().getName(), i);
		}
	}
}



public class Program {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new MySuperThread(0, 50));
		Thread t2 = new Thread(new MySuperThread(20, 30, t1));
		t2.start();

	}

}
