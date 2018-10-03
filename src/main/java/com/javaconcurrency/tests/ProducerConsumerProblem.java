package com.javaconcurrency.tests;

public class ProducerConsumerProblem {

	private static int[] arr;
	private static Object key = new Object();
	private static int count;

	static boolean isEmpty(int[] arr) {
		return count == 0;
	}

	static boolean isFull(int[] arr) {
		return count == arr.length;

	}

	static class Producer {
		void addNumbers() {
			synchronized (key) {
				while (isFull(arr)) {
					try {
						key.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				arr[count++] = 1;
				System.out.println("producer added"+ count);
				key.notify();
			}
		}
	}

	static class Consumer {
		void consumeNumbers() {
			synchronized (key) {
				while (isEmpty(arr)) {
					try {
						key.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				arr[--count] = 0;
				System.out.println("consumer consumed"+ count);
				key.notify();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		arr = new int[10];
		count = 0;

		Producer producer = new Producer();
		Consumer consumer = new Consumer();

		Runnable producerTask = () -> {
			for(int i=0;i<60;i++) {
				producer.addNumbers();
			}
		};
		
		Runnable consumerTask = () -> {
			for(int i=0;i<57;i++) {
				consumer.consumeNumbers();
			}
		};
		

		Thread producerThread = new Thread(producerTask);
		Thread consumerThread = new Thread(consumerTask);

		consumerThread.start();
		producerThread.start();

		consumerThread.join();
		producerThread.join();

		System.out.println("Size of arr after producer-consumer done is:" + count);
		System.out.println(arr);
	}

}
