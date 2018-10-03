package com.javaconcurrency.tests;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InterruptExample {
	/**
	 * https://dzone.com/articles/understanding-thread-interruption-in-java
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread taskThread = new Thread(taskThatFinishesEarlyOnInterruption());
		taskThread.start(); // requirement 3
		Thread.sleep(3_000); // requirement 4
		taskThread.interrupt(); // requirement 5
		taskThread.join(1_000); // requirement 6
	}

	private static Runnable taskThatFinishesEarlyOnInterruption() {
		return () -> {
			for (int i = 0; i < 10; i++) {
				System.out.print(i); // requirement 1
				try {
					Thread.sleep(4_000); // requirement 2
				} catch (InterruptedException e) {
					break; // requirement 7
				}
			}
		};
	}

	public static void executorServiceExample() throws InterruptedException {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<?> futureObject = executor.submit(taskThatFinishesEarlyOnInterruption());
		Thread.sleep(3_000);
		futureObject.cancel(true);

	}

}
