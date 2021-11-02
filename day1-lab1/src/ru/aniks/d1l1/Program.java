package ru.aniks.d1l1;

import static java.lang.System.out;

class MySuperThread implements Runnable{
	private int a = 0;
	private int b = 0;
	
	public MySuperThread(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public void run() {
		for(int i = this.a; i < this.b; i++) {
			out.printf("%s : %d\n", Thread.currentThread().getName(), i);
		}
	}
}


public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread t1 = new Thread(new MySuperThread(0, 50));
		Thread t2 = new Thread(new MySuperThread(20, 30));
		final int a = 200;
		final int b = 250;
		
		Thread t3 = new Thread(
				() -> {
					for(int i = a; i <= b; i++) {
						out.printf("%s : %d\n", Thread.currentThread().getName(), i);
					}
				}
				);

		t1.start();
		t2.start();
		t3.start();
	}

}
