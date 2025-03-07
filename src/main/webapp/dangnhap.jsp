<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="dangnhap.css">
</head>
<body>
    <div class="container">
        <h2>Đăng nhập</h2>

        <%-- Hiển thị thông báo lỗi nếu có --%>
        <% if (request.getParameter("error") != null) { %>
            <p class="error">Sai tên đăng nhập hoặc mật khẩu!</p>
        <% } %>

        <form action="DangNhap" method="post">
            <label>Tên đăng nhập:</label>
            <input type="text" name="tendangnhap" required> <br>

            <label>Mật khẩu:</label>
            <input type="password" name="matkhau" required> <br>

            <button type="submit">Đăng nhập</button>
        </form>
    </div>
</body>
</html>
