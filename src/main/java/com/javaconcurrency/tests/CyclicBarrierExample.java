package com.javaconcurrency.tests;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CyclicBarrierExample {
	
	private static class Task implements Runnable{
		
		private CyclicBarrier barrier;
		
		public Task(CyclicBarrier barrier) {
			this.barrier = barrier;
		}

		public void run() {
			// TODO Auto-generated method stub
			try {
				System.out.println(Thread.currentThread().getName()+" is waiting on barrier");
				barrier.await();
				System.out.println(Thread.currentThread().getName()+ " is done waiting");
			} catch (InterruptedException ex) {
                Logger.getLogger(CyclicBarrierExample.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BrokenBarrierException ex) {
                Logger.getLogger(CyclicBarrierExample.class.getName()).log(Level.SEVERE, null, ex);
            }
			
		}
		
	}
	
	public static void main(String args[]) {
		
		CyclicBarrier cyclicBarrierExample = new CyclicBarrier(3, new Runnable() {
			public void run() {
				System.out.print("Cyclic barrier broken");
			}
			
		});
		
		Thread t1 = new Thread(new Task(cyclicBarrierExample),"Thread1");
		Thread t2 = new Thread(new Task(cyclicBarrierExample),"Thread2");
		Thread t3 = new Thread(new Task(cyclicBarrierExample),"Thread3");
		
		t1.start();
		t2.start();
		t3.start();
	}
	

}
