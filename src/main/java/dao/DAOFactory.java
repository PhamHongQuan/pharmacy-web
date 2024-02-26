package dao;

public class DAOFactory {
	private static DAOFactory instance = new DAOFactory();

	public static DAOFactory getInstance() {
		return instance;
	}

	public ICustomerDAO getCustomerDAO() {
		return new CustomerDAOImpl();
	}

	public IProductDAO getProductDAO() {
		return new ProductDAOImpl();
	}

	public IOrderDAO getOrderDAO() {
		return new OrderDAOImpl();
	}

	public IManufatureDAO getManufatureDAO() {
		return new ManufactureDAOImpl();
	}
}
