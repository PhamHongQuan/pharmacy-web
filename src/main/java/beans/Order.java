package beans;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private String orderID;
	private Account account;
	private String addressShipping;
	private List<OrderDetail> orderDetails;

	public Order() {
		this.orderID = "";
		this.account = null;
		this.addressShipping = "";
		this.orderDetails = new ArrayList<OrderDetail>();
	}

	public Order(String orderID, Account account, String addressShipping, List<OrderDetail> orderDetails) {
		this.orderID = orderID;
		this.account = account;
		this.addressShipping = addressShipping;
		this.orderDetails = orderDetails;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public Account getCustomer() {
		return account;
	}

	public void setCustomer(Account account) {
		this.account = account;
	}

	public String getAddressShipping() {
		return addressShipping;
	}

	public void setAddressShipping(String addressShipping) {
		this.addressShipping = addressShipping;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", customer=" + account + ", addressShipping=" + addressShipping
				+ ", orderDetails=" + orderDetails + "]";
	}

	public void addItem(OrderDetail orderDetail) {
		String id = orderDetail.getProduct().getProductID();
		int quantity = orderDetail.getQuantity();
		for (int i = 0; i < orderDetails.size(); i++) {
			OrderDetail lineItem = orderDetails.get(i);
			if (lineItem.getProduct().getProductID().equals(id)) {
				lineItem.setQuantity(quantity);
				return;
			}
		}
		orderDetails.add(orderDetail);
	}

	public void removeItem(OrderDetail orderDetail) {
		String id = orderDetail.getProduct().getProductID();
		for (int i = 0; i < orderDetails.size(); i++) {
			OrderDetail lineItem = orderDetails.get(i);
			if (lineItem.getProduct().getProductID().equals(id)) {
				orderDetails.remove(i);
				return;
			}
		}
	}

}
