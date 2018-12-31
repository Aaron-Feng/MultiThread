package workerTest;

public class Order {
	private String state;
	private int number;

	public Order(int number) {
		this.number = number;
		this.state = "NEW";
	}

	public int getNumber() {
		return this.number;
	}

	public String getState() {
		return this.state;
	}

	public void changeState() {
		this.state = "FULFILLED";
	}
}
