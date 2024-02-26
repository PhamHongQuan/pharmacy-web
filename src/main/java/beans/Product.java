package beans;

import java.sql.Date;
import java.text.NumberFormat;
import java.util.Locale;

public class Product {
	private String productID;
	private String productName;
	private Manufacture manufacture;
	private double importPrice;
	private int quantityInStock;
	private String detailUses;
	private Date dateOfmanufacture;
	private Date expiry;
	private String img;

	public Product() {

	}

	public Product(String productID, String productName, Manufacture manufacture, double importPrice,
			int quantityInStock, String detailUses, Date dateOfmanufacture, Date expiry, String img) {
		this.productID = productID;
		this.productName = productName;
		this.manufacture = manufacture;
		this.importPrice = importPrice;
		this.quantityInStock = quantityInStock;
		this.detailUses = detailUses;
		this.dateOfmanufacture = dateOfmanufacture;
		this.expiry = expiry;
		this.img = img;
	}

	public Product(String productName, Manufacture manufacture, double importPrice, int quantityInStock,
			String detailUses, Date dateOfmanufacture, Date expiry, String img) {
		this.productName = productName;
		this.manufacture = manufacture;
		this.importPrice = importPrice;
		this.quantityInStock = quantityInStock;
		this.detailUses = detailUses;
		this.dateOfmanufacture = dateOfmanufacture;
		this.expiry = expiry;
		this.img = img;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Manufacture getManufacture() {
		return manufacture;
	}

	public void setManufacture(Manufacture manufacture) {
		this.manufacture = manufacture;
	}

	public double getImportPrice() {
		return importPrice;
	}

	public void setImportPrice(double importPrice) {
		this.importPrice = importPrice;
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public String getDetailUses() {
		return detailUses;
	}

	public void setDetailUses(String detailUses) {
		this.detailUses = detailUses;
	}

	public Date getDateOfmanufacture() {
		return dateOfmanufacture;
	}

	public void setDateOfmanufacture(Date dateOfmanufacture) {
		this.dateOfmanufacture = dateOfmanufacture;
	}

	public Date getExpiry() {
		return expiry;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public double getPriceSale() {
		return this.importPrice + this.importPrice * 0.2;
	}

	public String formatPrice(double price) {
		Locale vietnamLocale = new Locale("vi", "VN");
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(vietnamLocale);

		return currencyFormat.format(price);
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", manufacture=" + manufacture
				+ ", importPrice=" + importPrice + ", quantityInStock=" + quantityInStock + ", detailUses=" + detailUses
				+ ", dateOfmanufacture=" + dateOfmanufacture + ", expiry=" + expiry + ", img=" + img + "]";
	}

}
