package dao;

import java.util.List;

import beans.Product;

public interface IProductDAO {
	public List<Product> selectAllProduct();

	public Product findProductById(String productID);
	public List<Product > findProductByName(String productNameInput);

	public void addNewProduct(Product newProduct);

	public void deleteProduct(Product product);

	public void updateProduct(Product product);
	
	public List<Product> ascPrice();
	public List<Product> descPrice();
}
