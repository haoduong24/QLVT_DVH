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
        
        request.setCharacterEncoding("UTF-8"); // Hỗ trợ tiếng Việt

        String tenDangNhap = request.getParameter("tenDangNhap");
        String matKhau = request.getParameter("matKhau");
        String hoTen = request.getParameter("hoTen");
        String email = request.getParameter("email");
        String soDienThoai = request.getParameter("soDienThoai");

        // Mặc định vai trò là nhân viên
        String vaiTro = "nhan_vien";

        // Kiểm tra dữ liệu đầu vào có rỗng không
        if (tenDangNhap == null || tenDangNhap.trim().isEmpty() ||
            matKhau == null || matKhau.trim().isEmpty() ||
            hoTen == null || hoTen.trim().isEmpty() ||
            email == null || email.trim().isEmpty() ||
            soDienThoai == null || soDienThoai.trim().isEmpty()) {
            
            response.sendRedirect("dangky.jsp?error=missing_fields");
            return;
        }

        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
        boolean isRegistered = nguoiDungDAO.registerUser(tenDangNhap, matKhau, hoTen, email, soDienThoai);

        if (isRegistered) {
            response.sendRedirect("dangnhap.jsp?success=1"); // Đăng ký thành công
        } else {
            response.sendRedirect("dangky.jsp?error=exists"); // Tài khoản đã tồn tại hoặc lỗi khác
        }
    }
}
