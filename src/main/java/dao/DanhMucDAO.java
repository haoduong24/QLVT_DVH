package dao;

import entity.DanhMuc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DanhMucDAO {
    private Connection conn;

    public DanhMucDAO() throws SQLException {
        conn = DbConnection.getConnection();
    }

    // Lấy tất cả danh mục
    public List<DanhMuc> getAllCategories() {
        List<DanhMuc> list = new ArrayList<>();
        String sql = "SELECT * FROM danhmuc";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new DanhMuc(rs.getInt("maDanhMuc"), rs.getString("tenDanhMuc")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
