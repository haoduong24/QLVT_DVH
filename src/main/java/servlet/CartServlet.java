package servlet;

import dao.DAO;
import entity.CartItem;
import entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DAO productDAO;

    @Override
    public void init() {
        productDAO = new DAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        
        // Lấy giỏ hàng từ session (nếu null thì tạo mới)
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }

        try {
            if ("add".equals(action)) {
                int maVatTu = Integer.parseInt(request.getParameter("id"));
                Product product = productDAO.getProductById(maVatTu);

                if (product != null) {
                    cart.compute(maVatTu, (key, item) -> {
                        if (item == null) {
                            return new CartItem(maVatTu, product.getTenVatTu(), product.getAnhSanPham(), product.getGiaBan(), 1);
                        } else {
                            item.setSoLuong(item.getSoLuong() + 1);
                            return item;
                        }
                    });
                }
            } else if ("remove".equals(action)) {
                int maVatTu = Integer.parseInt(request.getParameter("id"));
                cart.remove(maVatTu);
            } else if ("update".equals(action)) {
                int maVatTu = Integer.parseInt(request.getParameter("id"));
                int soLuong = Integer.parseInt(request.getParameter("soLuong"));
                if (cart.containsKey(maVatTu)) {
                    if (soLuong > 0) {
                        cart.get(maVatTu).setSoLuong(soLuong);
                    } else {
                        cart.remove(maVatTu);
                    }
                }
            } else if ("clear".equals(action)) {
                cart.clear();
            }

            session.setAttribute("cart", cart);
            response.sendRedirect("giohang.jsp");
        } catch (NumberFormatException e) {
            response.sendRedirect("giohang.jsp?error=invalid_input");
        }
    }
}
