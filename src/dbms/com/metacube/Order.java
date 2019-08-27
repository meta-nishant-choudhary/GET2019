package dbms.com.metacube;

import java.util.Date;

public class Order {

	int id;
	String date_of_order;
	int amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate_of_order() {
		return date_of_order;
	}

	public void setDate_of_order(String date_of_order) {
		this.date_of_order = date_of_order;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
