package dao;

import beans.Order;
import beans.Product;

public interface IOrderDAO {
	public void saveOrder(Order order);

	public void deleteProduct(Product product);

}
