package com.javaconcurrency.tests;

public class TestMultipleThreads {
	
	static class runnable implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runnable r = () ->{
			try {
				Thread.sleep(1_00);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread Name :"+ Thread.currentThread().getName());		
		};
		
		for(int i=0;i<8;i++) {
			Thread k = new Thread(r,"thread"+i);
			k.start();
		}
	}

}
