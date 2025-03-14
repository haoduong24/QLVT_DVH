<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="entity.Product, entity.NguoiDung" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<%
    HttpSession sessionAdmin = request.getSession(false);
    NguoiDung admin = (NguoiDung) sessionAdmin.getAttribute("nguoiDung");

    if (admin == null || !"admin".equals(admin.getVaiTro().trim())) {
        response.sendRedirect("home.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>

<header>
    <h1>⚙️ Quản Lý Hệ Thống</h1>
    <nav>
        <a href="home">🏠 Trang Chủ</a>
        <a href="admin-dashboard.jsp">📦 Quản Lý Sản Phẩm</a>
        <a href="DangXuat">🚪 Đăng xuất</a>
    </nav>
</header>

<section class="admin-products">
    <h2>📋 Quản Lý Sản Phẩm</h2>
    <a href="addProduct.jsp" class="btn">➕ Thêm Sản Phẩm</a>
    <table>
        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Giá</th>
            <th>Hành động</th>
        </tr>
        <% 
            List<Product> listP = (List<Product>) request.getAttribute("listP");
            if (listP != null) {
                for (Product p : listP) { 
        %>
        <tr>
            <td><%= p.getMaVatTu() %></td>
            <td><%= p.getTenVatTu() %></td>
            <td><%= p.getGiaBan() %> VNĐ</td>
            <td>
                <a href="editProduct.jsp?id=<%= p.getMaVatTu() %>" class="btn">✏️ Sửa</a>
                <a href="DeleteProduct?id=<%= p.getMaVatTu() %>" class="btn">🗑️ Xóa</a>
            </td>
        </tr>
        <% 
                } 
            } else { 
        %>
        <tr><td colspan="4">Không có sản phẩm nào!</td></tr>
        <% } %>
    </table>
</section>

</body>
</html>
