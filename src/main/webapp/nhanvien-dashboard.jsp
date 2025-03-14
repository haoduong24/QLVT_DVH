<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.NguoiDung" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<%
    HttpSession sessionUser = request.getSession(false);
    NguoiDung nguoiDung = (NguoiDung) sessionUser.getAttribute("nguoiDung");

    if (nguoiDung == null || !"nhan_vien".equals(nguoiDung.getVaiTro())) {
        response.sendRedirect("dangnhap.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Nhân Viên Dashboard</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>Chào mừng Nhân Viên: <%= nguoiDung.getHoTen() %></h1>
    <a href="giohang.jsp">🛒 Giỏ Hàng</a>
    <a href="thanhtoan.jsp">💳 Thanh Toán</a>
    <a href="DangXuat">🚪 Đăng xuất</a>
</body>
</html>
