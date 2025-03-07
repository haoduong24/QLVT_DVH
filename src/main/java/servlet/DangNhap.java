package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NguoiDungDAO;
import entity.NguoiDung;

@WebServlet("/DangNhap")
public class DangNhap extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tenDangNhap = request.getParameter("tendangnhap");
        String matKhau = request.getParameter("matkhau");

        System.out.println("Tên đăng nhập: " + tenDangNhap);
        System.out.println("Mật khẩu: " + matKhau);

        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
        NguoiDung nguoiDung = nguoiDungDAO.loginUser(tenDangNhap, matKhau);

        if (nguoiDung != null) {
            HttpSession session = request.getSession();
            session.setAttribute("nguoiDung", nguoiDung);
            response.sendRedirect("Home1.jsp"); // Chuyển hướng đến trang chủ
        } else {
            response.sendRedirect("dangnhap.jsp?error=1"); // Sai thông tin đăng nhập
        }
    }
}
