package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.DanhMuc;
import entity.Product;

import java.util.ArrayList;
import java.util.List;

import connect.DbConnection;

public class DAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Product> getAllProduct(){
		List<Product> list = new ArrayList<>();
		String query = "select *from VatTu";
		try {
			conn = new DbConnection().getConnection(); // mo ket noi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getString(4)));
			}
			} catch (Exception e) {
		}
		return list;
	}
	public List<DanhMuc> getAllDanhMuc(){
		List<DanhMuc> list = new ArrayList<>();
		String query = "select*from DanhMuc	";
		try {
			conn = new DbConnection().getConnection(); // mo ket noi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new DanhMuc(rs.getInt(1),
						rs.getString(2),
						rs.getString(3)));
			}
			} catch (Exception e) {
		}
		return list;
	}
	public static void main(String[] args) {
		DAO dao = new DAO();
		List<Product> list = dao.getAllProduct();
		List<DanhMuc> listC = dao.getAllDanhMuc();
		for (DanhMuc o : listC) {
			System.out.println(o);
		}
	}
}
