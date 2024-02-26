package dao;

import beans.Manufacture;

public interface IManufatureDAO {
	public Manufacture findByName(String name);

	public void addNewManufacture(Manufacture m);
}
