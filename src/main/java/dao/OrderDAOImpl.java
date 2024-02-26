package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Order;
import beans.OrderDetail;
import beans.Product;

public class OrderDAOImpl implements IOrderDAO {
	private Connection conn = null;
	private PreparedStatement ps = null;

	public static void main(String[] args) {
		System.out.println(new OrderDAOImpl().countOrder());
	}
	

	private int countOrder() {
		int count = 0;
		try {
			conn = DatabaseConnection.getConnection();

			String countQuery = "SELECT COUNT(*) FROM Orders";
			ps = conn.prepareStatement(countQuery);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
			ps.close();

			DatabaseConnection.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public void saveOrder(Order order) {
		try (Connection conn = DatabaseConnection.getConnection()) {
			int count = countOrder();
			count++;
			String orderId = "order" + count;

			// Chèn vào OrderTables
			String insertOrderQuery = "INSERT INTO Orders (orderID, customerID, addressShipping) VALUES (?, ?, ?)";
			try (PreparedStatement ps = conn.prepareStatement(insertOrderQuery)) {
				ps.setString(1, orderId);
				ps.setString(2, order.getCustomer().getCustomerID());
				ps.setString(3, order.getCustomer().getAddress());
				ps.executeUpdate();
			}

			// Chèn vào OrderDetailTables
			String insertOrderDetailQuery = "INSERT INTO OrderDetails (productID, quantity, salePrice, orderID) VALUES (?, ?, ?, ?)";
			try (PreparedStatement ps = conn.prepareStatement(insertOrderDetailQuery)) {
				for (OrderDetail orderDetail : order.getOrderDetails()) {
					ps.setString(1, orderDetail.getProduct().getProductID());
					ps.setInt(2, orderDetail.getQuantity());
					ps.setDouble(3, orderDetail.getSalePrice());
					ps.setString(4, orderId);
					ps.addBatch();
				}
				ps.executeBatch();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProduct(Product product) {
		try {
			String latestOrderId = getLatestOrderId();

			conn = DatabaseConnection.getConnection();

			String sql = "DELETE FROM OrderDetails WHERE productID = ? AND orderID = ?";
			ps = conn.prepareStatement(sql);

			ps.setString(1, product.getProductID());
			ps.setString(2, latestOrderId);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private String getLatestOrderId() {
		ResultSet rs = null;
		String latestOrderId = null;

		try {
			conn = DatabaseConnection.getConnection();

			String sql = "SELECT orderID FROM Orders ORDER BY orderID DESC";
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				latestOrderId = rs.getString("orderID");
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return latestOrderId;
	}

}
