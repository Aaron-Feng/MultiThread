package workerTest;
import java.util.Queue;
import java.util.LinkedList;


public class Tester {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Order> order=new LinkedList<Order>();
		for (int i=1;i<11;i++) {
			Worker wk=new Worker();
			Thread thr=new Thread(wk,"order"+i);
			thr.start();
		}
	}
}
