package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import entity.NguoiDung;
import dao.DbConnection; // Kiểm tra class này có đúng không?

public class NguoiDungDAO {

    // KIỂM TRA ĐĂNG NHẬP
    public NguoiDung checkLogin(String tenDangNhap, String matKhau) {
        String sql = "SELECT manguoidung, tendangnhap, matkhau, hoten, email, sodienthoai, vaitro FROM NguoiDung WHERE tendangnhap = ? AND matkhau = ?";
        
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tenDangNhap);
            stmt.setString(2, matKhau);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new NguoiDung(
                        rs.getInt("manguoidung"),
                        rs.getString("tendangnhap"),
                        rs.getString("matkhau"), // Lưu ý: Không nên trả về mật khẩu!
                        rs.getString("hoten"),
                        rs.getString("email"),
                        rs.getString("sodienthoai"),
                        rs.getString("vaitro") != null ? rs.getString("vaitro") : "nhan_vien" // Mặc định nếu NULL
                    );
                }
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi kiểm tra đăng nhập: " + e.getMessage());
            e.printStackTrace(); 
        }
        return null;
    }

    // ĐĂNG KÝ NGƯỜI DÙNG (CHỈ CHO NHÂN VIÊN)
    public boolean registerUser(String tenDangNhap, String matKhau, String hoTen, String email, String soDienThoai) {
        // KIỂM TRA XEM TÀI KHOẢN ĐÃ TỒN TẠI CHƯA
        if (isUserExists(tenDangNhap)) {
            System.err.println("Tài khoản đã tồn tại: " + tenDangNhap);
            return false;
        }

        String sql = "INSERT INTO NguoiDung (tendangnhap, matkhau, hoten, email, sodienthoai, vaitro) VALUES (?, ?, ?, ?, ?, 'nhan_vien')";
        
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tenDangNhap);
            stmt.setString(2, matKhau); // Nếu muốn mã hóa, hãy dùng hashPassword(matKhau)
            stmt.setString(3, hoTen);
            stmt.setString(4, email);
            stmt.setString(5, soDienThoai);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (Exception e) {
            System.err.println("Lỗi khi đăng ký người dùng: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // HÀM KIỂM TRA TÀI KHOẢN TỒN TẠI
    private boolean isUserExists(String tenDangNhap) {
        String sql = "SELECT COUNT(*) FROM NguoiDung WHERE tendangnhap = ?";
        
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tenDangNhap);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next() && rs.getInt(1) > 0) {
                return true; // Tài khoản đã tồn tại
            }
        } catch (Exception e) {
            System.err.println("Lỗi kiểm tra tài khoản: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}
