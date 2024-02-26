package beans;

public class OrderDetail {
	private Product product;
	private int quantity;
	private double salePrice;

	public OrderDetail() {
		this.product = null;
		this.quantity = 0;
		this.salePrice = 0;
	}

	public OrderDetail(Product product, int quantity, double salePrice) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.salePrice = salePrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public double getSingleP() {
		return this.quantity * this.salePrice;
	}
	@Override
	public String toString() {
		return "OrderDetail [product=" + product + ", quantity=" + quantity + ", salePrice=" + salePrice + "]";
	}

}
