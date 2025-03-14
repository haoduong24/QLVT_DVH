package servlet;

import dao.NguoiDungDAO;
import entity.NguoiDung;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DangNhap")
public class DangNhap extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8"); // Hỗ trợ tiếng Việt

        String tenDangNhap = request.getParameter("tenDangNhap");
        String matKhau = request.getParameter("matKhau");

        // Kiểm tra dữ liệu nhập vào có trống không
        if (tenDangNhap == null || tenDangNhap.trim().isEmpty() || 
            matKhau == null || matKhau.trim().isEmpty()) {
            response.sendRedirect("dangnhap.jsp?error=missing_fields");
            return;
        }

        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
        NguoiDung nguoiDung = nguoiDungDAO.checkLogin(tenDangNhap, matKhau);

        if (nguoiDung != null) {
            HttpSession session = request.getSession();
            session.setAttribute("nguoiDung", nguoiDung);
            
            // Kiểm tra quyền hạn
            if ("quan_tri".equals(nguoiDung.getVaiTro())) {
                response.sendRedirect("admin-dashboard.jsp"); // Admin chuyển đến trang quản trị
            } else {
                response.sendRedirect("Home1.jsp"); // Nhân viên chuyển đến trang chính
            }
        } else {
            response.sendRedirect("dangnhap.jsp?error=invalid"); // Sai tài khoản hoặc mật khẩu
        }
    }
}
