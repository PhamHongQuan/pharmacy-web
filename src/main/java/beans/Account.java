package beans;

public class Account {
	private String customerID;
	private String lastName;
	private String firstName;
	private String sex;
	private String email;
	private String address;
	private String telephone;
	private String password;
	private String accountRole;

	public Account() {
	}

	public Account(String customerID, String lastName, String firstName, String sex, String email, String address,
			String telephone, String password, String accountRole) {
		this.customerID = customerID;
		this.lastName = lastName;
		this.firstName = firstName;
		this.sex = sex;
		this.email = email;
		this.address = address;
		this.telephone = telephone;
		this.password = password;
		this.accountRole = accountRole;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountRole() {
		return accountRole;
	}

	public void setAccountRole(String accountRole) {
		this.accountRole = accountRole;
	}

	@Override
	public String toString() {
		return "Account [customerID=" + customerID + ", lastName=" + lastName + ", firstName=" + firstName + ", sex="
				+ sex + ", email=" + email + ", address=" + address + ", telephone=" + telephone + ", password="
				+ password + ", accountRole=" + accountRole + "]";
	}

}