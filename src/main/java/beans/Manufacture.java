package beans;

import java.sql.Date;

public class Manufacture {
	private String manufactureId;
	private String name;
	private String address;
	private Date establishDate;

	public Manufacture(String name, String address, Date establishDate) {
		this.name = name;
		this.address = address;
		this.establishDate = establishDate;
	}

	public Manufacture(String manufactureId, String name, String address, Date establishDate) {
		this.manufactureId = manufactureId;
		this.name = name;
		this.address = address;
		this.establishDate = establishDate;
	}

	public Manufacture() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getEstablishDate() {
		return establishDate;
	}

	public void setEstablishDate(Date establishDate) {
		this.establishDate = establishDate;
	}

	public String getManufactureId() {
		return manufactureId;
	}

	public void setManufactureId(String manufactureId) {
		this.manufactureId = manufactureId;
	}

	@Override
	public String toString() {
		return "Manufacture [manufactureId=" + manufactureId + ", name=" + name + ", address=" + address
				+ ", establishDate=" + establishDate + "]";
	}

}
