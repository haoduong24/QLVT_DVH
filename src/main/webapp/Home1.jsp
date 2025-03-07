<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="entity.DanhMuc, entity.Product" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Chủ | Quản Lý Vật Tư</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>

<!-- Header -->
<header>
    <h1>🛒 HD - Quản Lý Vật Tư</h1>
    <nav>
        <a href="home">🏠 Trang Chủ</a>
        <a href="dangnhap.jsp" class="right">🔑 Đăng Nhập</a>
        <a href="dangky.jsp" class="right">📝 Đăng Ký</a>
        <a href="giohang.jsp" class="cart-icon">
            <img src="cart-icon.png" alt="Giỏ hàng">
            <span id="cart-count">0</span>
        </a>
    </nav>
</header>

<!-- Danh Mục -->
<section class="categories">
    <h2>📂 Danh Mục</h2>
    <ul>
        <% 
            List<DanhMuc> listC = (List<DanhMuc>) request.getAttribute("listCC");
            if (listC != null) {
                for (DanhMuc dm : listC) { 
        %>
            <li><a href="category?cid=<%= dm.getMaDanhMuc() %>"><%= dm.getTenDanhMuc() %></a></li>
        <% 
                } 
            } else { 
        %>
            <li>Không có danh mục nào!</li>
        <% } %>
    </ul>
</section>

<!-- Sản Phẩm -->
<section class="products">
    <h2>🆕 Sản Phẩm Mới Nhất</h2>
    <div class="product-list">
        <% 
            List<Product> listP = (List<Product>) request.getAttribute("listP");
            if (listP != null) {
                for (Product p : listP) { 
        %>
        <div class="product">
            <img src="<%= p.getAnhSanPham() %>" alt="<%= p.getTenVatTu() %>">
            <h3><%= p.getTenVatTu() %></h3>
            <p>💰 Giá: <%= p.getGiaBan() %> VNĐ</p>
            <button onclick="addToCart(<%= p.getMaVatTu() %>)">🛒 Thêm vào giỏ</button>
        </div>
        <% 
                } 
            } else { 
        %>
        <p>Không có sản phẩm nào!</p>
        <% } %>
    </div>
</section>

<!-- Footer -->
<footer>
    <p>&copy; 2025 Quản Lý Bán Vật Tư.</p>
</footer>

</body>
</html>
