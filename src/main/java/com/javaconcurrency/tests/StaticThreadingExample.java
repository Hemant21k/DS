package com.javaconcurrency.tests;

public class StaticThreadingExample {
	
	private static boolean value = true;
	
	static class Task implements Runnable{
	Thread t1;
		
		Task(Thread t1){
			this.t1 = t1;
		}

		@Override
		public void run(){
			try {
				t1.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			value = false;
		}
		
		
	}

	public static void main(String[] args) throws InterruptedException {
		
		Runnable r = () -> {
			value = true;
		};
		
		Runnable r1 = () -> {
			value = true;
		};
		
		Thread t1 = new Thread(r,"thread1");

		Task task = new Task(t1);
		Thread t2 = new Thread(task);
		t1.start();
		t2.start();
		t2.join();
		
		System.out.println("value of variable is: "+ value);
		
		
}
}
