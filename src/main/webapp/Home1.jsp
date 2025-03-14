<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="entity.NguoiDung, java.util.List, entity.Product, java.util.Map, entity.CartItem" %>

<%
    NguoiDung nguoiDung = (NguoiDung) session.getAttribute("nguoiDung");
    List<Product> listP = (List<Product>) request.getAttribute("listP");
    Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
    int cartSize = (cart != null) ? cart.size() : 0;

    if (listP == null) {
        response.sendRedirect("home"); // Gọi lại HomeControl nếu không có dữ liệu
        return;
    }
%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Trang Chủ</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body { background-color: #f8f9fa; }
        .navbar { background-color: #007bff; }
        .navbar-brand, .nav-link { color: white !important; font-weight: bold; }
        .container { margin-top: 20px; }
        .product-card {
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            transition: transform 0.3s ease-in-out;
        }
        .product-card:hover { transform: scale(1.05); }
        .cart-icon {
            position: relative;
            font-size: 20px;
        }
        .cart-count {
            position: absolute;
            top: -5px;
            right: -10px;
            background-color: red;
            color: white;
            border-radius: 50%;
            padding: 4px 8px;
            font-size: 12px;
        }
    </style>
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container">
            <a class="navbar-brand" href="home">🏠 Trang Chủ</a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav ms-auto">
                    <% if (nguoiDung != null) { %>
                        <li class="nav-item">
                            <span class="nav-link">👤 <%= nguoiDung.getHoTen() %></span>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link btn btn-danger btn-sm" href="DangXuat">Đăng xuất</a>
                        </li>
                    <% } else { %>
                        <li class="nav-item">
                            <a class="nav-link btn btn-primary btn-sm" href="dangnhap.jsp">Đăng nhập</a>
                        </li>
                    <% } %>
                    <li class="nav-item">
                        <a class="nav-link cart-icon" href="giohang.jsp">🛒 Giỏ hàng <span class="cart-count"><%= cartSize %></span></a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Danh sách sản phẩm -->
    <div class="container">
        <h2 class="text-center my-4">🛍️ Danh Sách Sản Phẩm</h2>
        <div class="row">
            <% if (listP != null && !listP.isEmpty()) {
                for (Product p : listP) { %>
                    <div class="col-md-4 mb-4">
                        <div class="card product-card">
                            <img src="<%= p.getAnhSanPham() %>" class="card-img-top" alt="<%= p.getTenVatTu() %>">
                            <div class="card-body text-center">
                                <h5 class="card-title"><%= p.getTenVatTu() %></h5>
                                <p class="card-text text-danger fw-bold"><%= p.getGiaBan() %> VNĐ</p>
                                <a href="CartServlet?action=add&id=<%= p.getMaVatTu() %>" class="btn btn-warning">🛒 Thêm vào giỏ hàng</a>
                            </div>
                        </div>
                    </div>
                <% }
            } else { %>
                <p class="text-center">Không có sản phẩm nào.</p>
            <% } %>
        </div>
    </div>
</body>
</html>
