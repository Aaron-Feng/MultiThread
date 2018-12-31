package workerTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Worker implements Runnable {
	Queue<Order> orderQueue;
	Order order;

	public Worker(Queue<Order> queue, Order order) {
		this.orderQueue = queue;
		this.order = order;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (orderQueue) {
			while (orderQueue.size() == 5) {
				try {
					orderQueue.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			orderQueue.add(order);
			System.out.println("The order " + order.getNumber() + " is adding to the Queue.");
		}
		try {
			Random r = new Random();
			int workingTime = r.nextInt(2000);
			System.out.println("The order " + order.getNumber() + " is working!");
			Thread.sleep(workingTime + 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (orderQueue) {
			System.out.println("The order " + order.getNumber() + " is done!");
			order.changeState();
			orderQueue.remove(order);
			orderQueue.notifyAll();
		}

	}
}
