package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Account;

public class CustomerDAOImpl implements ICustomerDAO {
	private Connection conn = null;
	private PreparedStatement ps = null;

	public static void main(String[] args) {
		CustomerDAOImpl dao = new CustomerDAOImpl();
		System.out.println(dao.countCustomers());
		// CustomerDAOImpl().checkCustomerExist("hongquan@gmail.com"));
//		System.out.println(new CustomerDAOImpl().checkCustomerExist("admin@gmail.com"));
//		new CustomerDAOImpl().insert(a);
	}

	@Override
	public List<Account> selectAll() {
		List<Account> customerList = new ArrayList<Account>();
		try {
			conn = DatabaseConnection.getConnection();
			String query = "SELECT * FROM Accounts";
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String customerID = rs.getString("customerID");
				String lastName = rs.getString("lastName");
				String firstName = rs.getString("firstName");
				String sex = rs.getString("sex");
				String address = rs.getString("customerAddress");
				String telephone = rs.getString("telephone");
				String email = rs.getString("email");
				String password = rs.getString("customerPassword");
				String role = rs.getString("accountRole");
				Account account = new Account(customerID, lastName, firstName, sex, email, address, telephone, password,
						role);
				customerList.add(account);
			}
			DatabaseConnection.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerList;
	}

	@Override
	public void insert(Account account) {
		try {
			int count = countCustomers();
			count++;
			String customerID = "customer" + count;

			String query = "INSERT INTO Accounts VALUES (?,?,?,?,?,?,?,?,?)";

			conn = DatabaseConnection.getConnection();

			ps = conn.prepareStatement(query);

			ps.setString(1, customerID);
			ps.setString(2, account.getLastName());
			ps.setString(3, account.getFirstName());
			ps.setString(4, account.getSex());
			ps.setString(5, account.getEmail());
			ps.setString(6, account.getAddress());
			ps.setString(7, account.getTelephone());
			ps.setString(8, account.getPassword());
			ps.setString(9, account.getAccountRole());

			ps.executeUpdate();
			ps.close();
			DatabaseConnection.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private int countCustomers() {
		int count = 0;
		try {
			conn = DatabaseConnection.getConnection();

			String countQuery = "SELECT COUNT(*) FROM Accounts";
			ps = conn.prepareStatement(countQuery);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1); // Lấy giá trị từ cột đầu tiên
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
	public void update(Account account) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Account findCustomerByID(String id) {
		Account account = null;
		try {
			conn = DatabaseConnection.getConnection();
			String query = "select * from Accounts where customerID = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String customerId = rs.getString("customerID");
				String lastName = rs.getString("lastName");
				String firstName = rs.getString("firstName");
				String sex = rs.getString("sex");
				String email = rs.getString("email");
				String address = rs.getString("customerAddress");
				String telephone = rs.getString("telephone");
				String password = rs.getString("customerPassword");
				String role = rs.getString("accountRole");
				account = new Account(customerId, lastName, firstName, sex, email, address, telephone, password, role);
			}
			conn.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}
	
	@Override
	public void changePassword(Account user) {
		int result = 0;
		try {
			conn = DatabaseConnection.getConnection();

			String query = "UPDATE Accounts SET customerPassword=? WHERE email=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getEmail());
			result = ps.executeUpdate();

			ps.close();

			DatabaseConnection.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Account checkCustomerExist(String emailInput) {
		Account account = null;
		try {
			conn = DatabaseConnection.getConnection();
			String query = "SELECT * FROM Accounts WHERE email=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, emailInput);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String customerId = rs.getString("customerID");
				String lastName = rs.getString("lastName");
				String firstName = rs.getString("firstName");
				String sex = rs.getString("sex");
				String email = rs.getString("email");
				String address = rs.getString("customerAddress");
				String telephone = rs.getString("telephone");
				String password = rs.getString("customerPassword");
				String role = rs.getString("accountRole");
				account = new Account(customerId, lastName, firstName, sex, email, address, telephone, password, role);
			}
			DatabaseConnection.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public Account selectByEmailAndPassword(String emailInput, String pass) {
		Account account = null;
		try {
			conn = DatabaseConnection.getConnection();
			String query = "SELECT * FROM Accounts WHERE email=? AND customerPassword=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, emailInput);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String customerID = rs.getString("customerID");
				String lastName = rs.getString("lastName");
				String firstName = rs.getString("firstName");
				String sex = rs.getString("sex");
				String address = rs.getString("customerAddress");
				String telephone = rs.getString("telephone");
				String email = rs.getString("email");
				String password = rs.getString("customerPassword");
				String role = rs.getString("accountRole");
				account = new Account(customerID, lastName, firstName, sex, email, address, telephone, password, role);
			}
			DatabaseConnection.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public Account findCustomerByEmail(String accEmail) {
		Account account = null;
		try {
			conn = DatabaseConnection.getConnection();
			String query = "select * from Accounts where email like ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, accEmail);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String customerId = rs.getString("customerID");
				String lastName = rs.getString("lastName");
				String firstName = rs.getString("firstName");
				String sex = rs.getString("sex");
				String email = rs.getString("email");
				String address = rs.getString("customerAddress");
				String telephone = rs.getString("telephone");
				String password = rs.getString("customerPassword");
				String role = rs.getString("accountRole");
				account = new Account(customerId, lastName, firstName, sex, email, address, telephone, password, role);
			}
			conn.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

}
