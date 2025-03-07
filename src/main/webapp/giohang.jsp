<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.GioHang, entity.CartItem, entity.Product" %>
<%@page import="java.util.Map" %>
<jsp:useBean id="cart" class="entity.GioHang" scope="session" />

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Giỏ Hàng</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h2>🛒 Giỏ Hàng Của Bạn</h2>
    
    <% 
        Map<Integer, CartItem> items = cart.getItems();
        if (items == null || items.isEmpty()) { 
    %>
        <p>Giỏ hàng của bạn đang trống.</p>
    <% } else { %>
        <table border="1">
            <tr>
                <th>Sản Phẩm</th>
                <th>Giá</th>
                <th>Số Lượng</th>
                <th>Thành Tiền</th>
                <th>Hành Động</th>
            </tr>
            <% for (CartItem item : items.values()) { %>
                <tr>
                    <td><%= item.getProduct().getTenVatTu() %></td>
                    <td><%= item.getProduct().getGiaBan() %> VNĐ</td>
                    <td>
                        <form action="UpdateCartServlet" method="post">
                            <input type="hidden" name="productId" value="<%= item.getProduct().getMaVatTu() %>">
                            <input type="number" name="quantity" value="<%= item.getQuantity() %>" min="1">
                            <button type="submit">Cập Nhật</button>
                        </form>
                    </td>
                    <td><%= item.getProduct().getGiaBan() * item.getQuantity() %> VNĐ</td>
                    <td>
                        <form action="RemoveFromCartServlet" method="post">
                            <input type="hidden" name="productId" value="<%= item.getProduct().getMaVatTu() %>">
                            <button type="submit">🗑 Xóa</button>
                        </form>
                    </td>
                </tr>
            <% } %>
            <tr>
                <td colspan="3"><strong>Tổng cộng:</strong></td>
                <td colspan="2"><strong><%= cart.getTotalPrice() %> VNĐ</strong></td>
            </tr>
        </table>
        <br>
        <a href="home">🛍 Tiếp tục mua hàng</a> | 
        <a href="CheckoutServlet">💳 Thanh toán</a> | 
        <a href="ClearCartServlet">🧹 Xóa toàn bộ giỏ hàng</a>
    <% } %>
</body>
</html>
