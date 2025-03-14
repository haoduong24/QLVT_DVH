<%@ page import="java.util.Map, entity.CartItem" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Giỏ Hàng</title>
    <style>
        /* Tổng thể */
        body {
            font-family: Arial, sans-serif;
            background: #f8f9fa;
            margin: 0;
            padding: 20px;
            display: flex;
            justify-content: center;
        }

        .cart-container {
            width: 80%;
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        h2 {
            color: #333;
            margin-bottom: 20px;
        }

        /* Bảng sản phẩm */
        .cart-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
        }

        .cart-table th, .cart-table td {
            padding: 12px;
            border-bottom: 1px solid #ddd;
            text-align: center;
        }

        .cart-table th {
            background: #007bff;
            color: white;
            font-weight: bold;
        }

        .cart-table td {
            background: #fdfdfd;
        }

        /* Input số lượng */
        .quantity-input {
            width: 50px;
            padding: 5px;
            text-align: center;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        /* Các nút */
        .update-btn, .remove-btn, .clear-btn, .home-btn, .checkout-btn {
            padding: 8px 12px;
            text-decoration: none;
            border-radius: 5px;
            transition: 0.3s;
            display: inline-block;
        }

        .update-btn {
            background: #28a745;
            color: white;
            border: none;
            cursor: pointer;
        }

        .remove-btn {
            background: #dc3545;
            color: white;
        }

        .clear-btn {
            background: #ff9800;
            color: white;
        }

        .home-btn {
            background: #17a2b8;
            color: white;
        }

        .checkout-btn {
            background: #ffc107;
            color: white;
        }

        .update-btn:hover {
            background: #218838;
        }

        .remove-btn:hover {
            background: #c82333;
        }

        .clear-btn:hover {
            background: #e68900;
        }

        .home-btn:hover {
            background: #138496;
        }

        .checkout-btn:hover {
            background: #e0a800;
        }

        /* Tổng tiền */
        .cart-total {
            font-size: 18px;
            font-weight: bold;
            color: #333;
        }

        /* Container cho nút điều hướng */
        .cart-actions {
            margin-top: 20px;
            display: flex;
            justify-content: space-between;
        }
    </style>
</head>
<body>
    <div class="cart-container">
        <h2>Giỏ Hàng</h2>
        <table class="cart-table">
            <tr>
                <th>Tên Sản Phẩm</th>
                <th>Giá</th>
                <th>Số Lượng</th>
                <th>Thành Tiền</th>
                <th>Hành Động</th>
            </tr>
            <% if (cart != null && !cart.isEmpty()) {
                double total = 0;
                for (CartItem item : cart.values()) {
                    total += item.getGiaBan() * item.getSoLuong();
            %>
            <tr>
                <td><%= item.getTenVatTu() %></td>
                <td><%= item.getGiaBan() %> VNĐ</td>
                <td>
                    <form action="CartServlet" method="get">
                        <input type="hidden" name="action" value="update">
                        <input type="hidden" name="id" value="<%= item.getMaVatTu() %>">
                        <input type="number" class="quantity-input" name="soLuong" value="<%= item.getSoLuong() %>" min="1">
                        <button type="submit" class="update-btn">Cập Nhật</button>
                    </form>
                </td>
                <td><%= item.getGiaBan() * item.getSoLuong() %> VNĐ</td>
                <td>
                    <a href="CartServlet?action=remove&id=<%= item.getMaVatTu() %>" class="remove-btn">Xóa</a>
                </td>
            </tr>
            <% } %>
            <tr>
                <td colspan="3"><b>Tổng cộng:</b></td>
                <td><b class="cart-total"><%= total %> VNĐ</b></td>
                <td><a href="CartServlet?action=clear" class="clear-btn">Xóa hết</a></td>
            </tr>
            <% } else { %>
            <tr>
                <td colspan="5">Giỏ hàng trống</td>
            </tr>
            <% } %>
        </table>

        <!-- Nút điều hướng -->
        <div class="cart-actions">
            <a href="Home1.jsp" class="home-btn">Quay lại Trang Chủ</a>
            <% if (cart != null && !cart.isEmpty()) { %>
                <a href="checkout.jsp" class="checkout-btn">Thanh Toán</a>
            <% } %>
        </div>
    </div>
</body>
</html>
