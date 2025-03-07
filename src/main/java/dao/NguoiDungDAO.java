package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entity.NguoiDung;
import dao.DbConnection;  // Đảm bảo bạn có class DBConnection để quản lý kết nối

@SuppressWarnings("unused")
public class NguoiDungDAO {
    
    // Đăng ký tài khoản
    public boolean registerUser(String tenDangNhap, String matKhau, String hoTen, String email, String soDienThoai, String vaiTro) {
        String query = "INSERT INTO nguoidung (tendangnhap, matkhau, hoten, email, sodienthoai, vaitro) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DbConnection.getConnection();  
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, tenDangNhap);
            stmt.setString(2, matKhau);  // Cần mã hóa mật khẩu nếu bảo mật
            stmt.setString(3, hoTen);
            stmt.setString(4, email);
            stmt.setString(5, soDienThoai);
            stmt.setString(6, vaiTro);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;  // Trả về true nếu thêm thành công
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Đăng nhập
    public NguoiDung loginUser(String email, String matKhau) {
        String sql = "SELECT * FROM nguoidung WHERE email = ? AND matkhau = ?";
        
        try (Connection conn = DbConnection.getConnection();  
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, email);
            stmt.setString(2, matKhau);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                NguoiDung nguoiDung = new NguoiDung();
                nguoiDung.setMaNguoiDung(rs.getInt("manguoidung"));
                nguoiDung.setTenDangNhap(rs.getString("tendangnhap"));
                nguoiDung.setMatKhau(rs.getString("matkhau"));
                nguoiDung.setHoTen(rs.getString("hoten"));
                nguoiDung.setEmail(rs.getString("email"));
                nguoiDung.setSoDienThoai(rs.getString("sodienthoai"));
                nguoiDung.setVaiTro(rs.getString("vaitro"));
                nguoiDung.setNgayTao(rs.getTimestamp("ngaytao"));
                return nguoiDung;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  // Trả về null nếu không tìm thấy tài khoản
    }

	public NguoiDung kiemTraDangNhap(String email, String matKhau) {
		// TODO Auto-generated method stub
		return null;
	}
}
