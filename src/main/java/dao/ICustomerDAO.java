package dao;

import java.util.List;

import beans.Account;

public interface ICustomerDAO {
	public List<Account> selectAll();

	public void insert(Account account);

	public void update(Account account);

	public void delete(String id);

	public Account findCustomerByID(String id);
	
	public Account findCustomerByEmail(String accEmail);

	public void changePassword(Account account);

	public Account checkCustomerExist(String email);

	public Account selectByEmailAndPassword(String email, String password);
}
