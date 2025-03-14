package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Product;

public class DAO {

    // Lấy danh sách tất cả sản phẩm
    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM vattu";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Product p = new Product(
                    rs.getInt("mavattu"),
                    rs.getString("tenvattu"),
                    rs.getString("anhsanpham"),
                    rs.getDouble("giaban"),
                    rs.getInt("madanhmuc") // Thêm danh mục
                );
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Lấy thông tin sản phẩm theo ID
    public Product getProductById(int maVatTu) {
        String sql = "SELECT * FROM vattu WHERE mavattu = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, maVatTu);
            try (ResultSet rs = stmt.executeQuery()) { // Đóng ResultSet đúng cách
                if (rs.next()) {
                    return new Product(
                        rs.getInt("mavattu"),
                        rs.getString("tenvattu"),
                        rs.getString("anhsanpham"),
                        rs.getDouble("giaban"),
                        rs.getInt("madanhmuc") // Fix lỗi thiếu danh mục
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
