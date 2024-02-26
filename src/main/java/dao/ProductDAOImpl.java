package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import beans.Manufacture;
import beans.Product;

public class ProductDAOImpl implements IProductDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public List<Product> selectAllProduct() {
		List<Product> list = new ArrayList<Product>();
		String query = "SELECT * FROM Products INNER JOIN Manufactures "
				+ "ON Products.manufactureID = Manufactures.manufactureID";
		try {
			conn = DatabaseConnection.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Manufacture manufacture = new Manufacture(rs.getString("manufactureName"),
						rs.getString("manufactureAddress"), rs.getDate("dateEstablish"));

				list.add(new Product(rs.getString("productID"), rs.getString("productName"), manufacture,
						rs.getFloat("importPrice"), rs.getInt("quantityInStock"), rs.getString("detailUses"),
						rs.getDate("dateOfManufacture"), rs.getDate("expiry"), rs.getString("img")));
			}
			DatabaseConnection.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	@Override
	public List<Product>  findProductByName(String productNameInput) {
	List<Product>  list = new ArrayList<Product>();
			String productInput= "%"+productNameInput +"%";
		String query = "SELECT * " + "FROM Products p inner join Manufactures m "
				+ "on p.manufactureID = m.manufactureID " + "WHERE productName like ?" ;
		if(productNameInput==null) return null;
		else		try {
			conn = DatabaseConnection.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, productInput);
			rs = ps.executeQuery();
			while (rs.next()) {
				Manufacture manufacture = new Manufacture(rs.getString("manufactureName"),
						rs.getString("manufactureAddress"), rs.getDate("dateEstablish"));

				list.add(new Product(rs.getString("productID"), rs.getString("productName"), manufacture,
						rs.getFloat("importPrice"), rs.getInt("quantityInStock"), rs.getString("detailUses"),
						rs.getDate("dateOfManufacture"), rs.getDate("expiry"), rs.getString("img")));
			}
			DatabaseConnection.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	

	@Override
	public Product findProductById(String productIdInput) {
		Product product = null;
		String query = "SELECT * " + "FROM Products p inner join Manufactures m "
				+ "on p.manufactureID = m.manufactureID " + "WHERE productID = ?";
		try {
			conn = DatabaseConnection.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, productIdInput);
			rs = ps.executeQuery();
			while (rs.next()) {
				Manufacture m = new Manufacture(rs.getString("manufactureName"), rs.getString("manufactureAddress"),
						rs.getDate("dateEstablish"));

				String productID = rs.getString("productID");
				String productName = rs.getString("productName");
				Manufacture manufacture = m;
				double importPrice = rs.getDouble("importPrice");
				int quantityInStock = rs.getInt("quantityInStock");
				String detailUses = rs.getString("detailUses");
				Date dateOfmanufacture = rs.getDate("dateOfManufacture");
				Date expiry = rs.getDate("expiry");
				String img = rs.getString("img");

				product = new Product(productID, productName, manufacture, importPrice, quantityInStock, detailUses,
						dateOfmanufacture, expiry, img);
			}
			DatabaseConnection.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	
	
	
	@Override
	public void addNewProduct(Product newProduct) {
		String insertSql = "INSERT INTO Products (productID, productName, importPrice, quantityInStock, detailUses, dateOfManufacture, expiry, img) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = DatabaseConnection.getConnection();
			conn.setAutoCommit(false);

			// Thêm sản phẩm mới vào Products
			ps = conn.prepareStatement(insertSql);
			String productID = UUID.randomUUID().toString();
			ps.setString(1, productID);
			ps.setString(2, newProduct.getProductName());
			ps.setDouble(3, newProduct.getImportPrice());
			ps.setInt(4, newProduct.getQuantityInStock());
			ps.setString(5, newProduct.getDetailUses());
			ps.setDate(6, newProduct.getDateOfmanufacture());
			ps.setDate(7, newProduct.getExpiry());
			ps.setString(8, newProduct.getImg());
			ps.executeUpdate();
			ps.close();
			// Cập nhật ManufactureID sau khi thêm sản phẩm
			String updateSql = "UPDATE Products SET manufactureID = ? WHERE productID = ?";
			ps = conn.prepareStatement(updateSql);
			ps.setString(1, newProduct.getManufacture().getManufactureId());
			ps.setString(2, productID);
			ps.executeUpdate();
			ps.close();
			// Commit thay đổi vào cơ sở dữ liệu
			conn.commit();

		} catch (Exception e) {
			try {
				// Rollback nếu có lỗi
				if (conn != null) {
					conn.rollback();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.setAutoCommit(true); // Đặt lại AutoCommit thành true
					DatabaseConnection.closeConnection(conn);
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	@Override
	public void deleteProduct(Product product) {
		String deleteOrderDetailsSql = "delete from OrderDetails where productID = ?";
		String deleteProductSql = "delete from Products where productID = ?";

		try {
			conn = DatabaseConnection.getConnection();
			conn.setAutoCommit(false); // Bắt đầu giao dịch

			// Xóa các chi tiết đơn đặt hàng liên quan đến sản phẩm
			try (PreparedStatement deleteOrderDetailsPs = conn.prepareStatement(deleteOrderDetailsSql)) {
				deleteOrderDetailsPs.setString(1, product.getProductID());
				deleteOrderDetailsPs.executeUpdate();
			}

			// Xóa sản phẩm
			try (PreparedStatement deleteProductPs = conn.prepareStatement(deleteProductSql)) {
				deleteProductPs.setString(1, product.getProductID());
				deleteProductPs.executeUpdate();
			}

			// Commit giao dịch
			conn.commit();
		} catch (SQLException e) {
			try {
				// Rollback nếu có lỗi
				if (conn != null) {
					conn.rollback();
				}
			} catch (SQLException rollbackException) {
				rollbackException.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				// Đặt lại chế độ tự động commit
				if (conn != null) {
					conn.setAutoCommit(true);
				}
				DatabaseConnection.closeConnection(conn);
			} catch (SQLException closeException) {
				closeException.printStackTrace();
			}
		}
	}

	@Override
	public void updateProduct(Product product) {
		String updateProductSql = "update Products set productName=?,"
				+ "importPrice=?, quantityInStock=?, detailUses=?, dateOfManufacture=?, "
				+ "expiry=?, img=? where productID =?";

		try {
			conn = DatabaseConnection.getConnection();
			conn.setAutoCommit(false); // Bắt đầu giao dịch

			try (PreparedStatement updateProductPs = conn.prepareStatement(updateProductSql)) {
				// Thiết lập các tham số cho câu lệnh SQL
				updateProductPs.setString(1, product.getProductName());
				updateProductPs.setDouble(2, product.getImportPrice());
				updateProductPs.setInt(3, product.getQuantityInStock());
				updateProductPs.setString(4, product.getDetailUses());
				updateProductPs.setDate(5, product.getDateOfmanufacture());
				updateProductPs.setDate(6, product.getExpiry());
				updateProductPs.setString(7, product.getImg());
				updateProductPs.setString(8, product.getProductID());

				// Thực hiện câu lệnh SQL
				updateProductPs.executeUpdate();
			}

			// Commit giao dịch
			conn.commit();
		} catch (SQLException e) {
			try {
				// Rollback nếu có lỗi
				if (conn != null) {
					conn.rollback();
				}
			} catch (SQLException rollbackException) {
				rollbackException.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				// Đặt lại chế độ tự động commit
				if (conn != null) {
					conn.setAutoCommit(true);
				}
				DatabaseConnection.closeConnection(conn);
			} catch (SQLException closeException) {
				closeException.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ProductDAOImpl dao = new ProductDAOImpl();
//		Product p = dao.findProductById("bd4e2064-4033-4e03-b932-3f4633953484");
//		dao.deleteProduct(p);
		Product p = dao.findProductById("product1");
		System.out.println(dao.descPrice());
//		p.setImportPrice(222222);
//		dao.updateProduce(p);
	}


	@Override
	public List<Product> ascPrice() {
		List<Product> list = new ArrayList<Product>();
		String query = "SELECT * FROM Products P INNER JOIN Manufactures M ON P.manufactureID = M.manufactureID ORDER BY importPrice ASC";
		try {
			conn = DatabaseConnection.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Manufacture manufacture = new Manufacture(rs.getString("manufactureName"),
						rs.getString("manufactureAddress"), rs.getDate("dateEstablish"));

				list.add(new Product(rs.getString("productID"), rs.getString("productName"), manufacture,
						rs.getFloat("importPrice"), rs.getInt("quantityInStock"), rs.getString("detailUses"),
						rs.getDate("dateOfManufacture"), rs.getDate("expiry"), rs.getString("img")));
			}
			DatabaseConnection.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public List<Product> descPrice() {
		List<Product> list = new ArrayList<Product>();
		String query = "SELECT * FROM Products P INNER JOIN Manufactures M ON P.manufactureID = M.manufactureID ORDER BY importPrice DESC";
		try {
			conn = DatabaseConnection.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Manufacture manufacture = new Manufacture(rs.getString("manufactureName"),
						rs.getString("manufactureAddress"), rs.getDate("dateEstablish"));

				list.add(new Product(rs.getString("productID"), rs.getString("productName"), manufacture,
						rs.getFloat("importPrice"), rs.getInt("quantityInStock"), rs.getString("detailUses"),
						rs.getDate("dateOfManufacture"), rs.getDate("expiry"), rs.getString("img")));
			}
			DatabaseConnection.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}



}
