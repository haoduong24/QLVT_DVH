package servlet;

import dao.NguoiDungDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DangKy")
public class DangKy extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // Nhận dữ liệu từ form
        String tenDangNhap = request.getParameter("tendangnhap");
        String matKhau = request.getParameter("matkhau");
        String hoTen = request.getParameter("hoten");
        String email = request.getParameter("email");
        String soDienThoai = request.getParameter("sodienthoai");
        String vaiTro = "nhan_vien"; // Mặc định người dùng có vai trò "nguoi_dung"

        // Lưu vào DB
        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
        boolean success = nguoiDungDAO.registerUser(tenDangNhap, matKhau, hoTen, email, soDienThoai, vaiTro);

        if (success) {
            response.sendRedirect("dangnhap.jsp?success=true"); // Chuyển sang trang đăng nhập
        } else {
            response.sendRedirect("dangky.jsp?error=true"); // Báo lỗi
        }
    }
}
