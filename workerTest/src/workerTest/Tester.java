package workerTest;
import java.util.Queue;
import java.util.LinkedList;


public class Tester {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Order> orderQueue=new LinkedList<Order>();
		for (int i=1;i<11;i++) {
			Order ord=new Order(i);
			Worker wk=new Worker(orderQueue,ord);
			Thread thr=new Thread(wk);
			System.out.println("The New order "+ord.getNumber()+" has been generated!");
			thr.start();
		}
	}
}
