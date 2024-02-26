package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

import beans.Manufacture;

public class ManufactureDAOImpl implements IManufatureDAO {
	private Connection conn = null;
	private PreparedStatement ps = null;

	@Override
	public Manufacture findByName(String name) {
		Manufacture manufacture = null;
		try {
			conn = DatabaseConnection.getConnection();
			String querry = "select * from Manufactures where manufactureName like ?";
			ps = conn.prepareStatement(querry);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String namefactureId = rs.getString("manufactureID");
				String manufactureName = rs.getString("manufactureName");
				String address = rs.getString("manufactureAddress");
				Date establishDate = Date.valueOf(rs.getString("dateEstablish"));
				manufacture = new Manufacture(namefactureId, manufactureName, address, establishDate);
			}
			ps.close();
			DatabaseConnection.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return manufacture;
	}

	@Override
	public void addNewManufacture(Manufacture m) {
		String sql = "insert into Manufactures values (?,?,?,?)";
		try {
			conn = DatabaseConnection.getConnection();
			ps = conn.prepareStatement(sql);
			String id = UUID.randomUUID().toString();
			ps.setString(1, id);
//			ps.setString(1, m.getManufactureId());
			ps.setString(2, m.getName());
			ps.setString(3, m.getAddress());
			ps.setDate(4, m.getEstablishDate());
			ps.executeUpdate();
			ps.close();
			DatabaseConnection.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ManufactureDAOImpl m = new ManufactureDAOImpl();
//		System.out.println(m.findByName("Kutieskin"));
//		Manufacture f = new Manufacture("Vesta", "Uy Ninh Tất Tiết, Quý Châu, Trung Quốc", new Date(2000, 1, 1));
//		m.addNewManufacture(f);
	}

}
