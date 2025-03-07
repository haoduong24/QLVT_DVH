<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng ký</title>
    <link rel="stylesheet" href="dangky.css">
</head>
<body>
    <div class="container">
        <h2>Đăng ký</h2>
        
        <%-- Hiển thị thông báo lỗi nếu có --%>
        <% if (request.getParameter("error") != null) { %>
            <p class="error">Lỗi: Tên đăng nhập hoặc email đã tồn tại!</p>
        <% } %>

        <form action="DangKy" method="post">
            <label>Tên đăng nhập:</label>
            <input type="text" name="tendangnhap" required> <br>

            <label>Mật khẩu:</label>
            <input type="password" name="matkhau" required> <br>

            <label>Họ tên:</label>
            <input type="text" name="hoten" required> <br>

            <label>Email:</label>
            <input type="email" name="email" required> <br>

            <label>Số điện thoại:</label>
            <input type="text" name="sodienthoai" required> <br>

            <button type="submit">Đăng ký</button>
        </form>
    </div>
</body>
</html>
