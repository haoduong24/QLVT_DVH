package Control;

import dao.DAO;
import entity.Product;
import entity.NguoiDung;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/home")
public class HomeControl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            DAO productDAO = new DAO();
            List<Product> listP = productDAO.getAllProducts(); // Lấy danh sách sản phẩm

            request.setAttribute("listP", listP);

            HttpSession session = request.getSession(false);
            NguoiDung nguoiDung = (session != null) ? (NguoiDung) session.getAttribute("nguoiDung") : null;

            if (nguoiDung != null) {
                System.out.println("✅ Người dùng từ session: " + nguoiDung.getHoTen());
            } else {
                System.out.println("⚠️ Không tìm thấy người dùng trong session!");
            }

            request.getRequestDispatcher("Home1.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Có lỗi xảy ra! Vui lòng thử lại.");
            request.getRequestDispatcher("Home1.jsp").forward(request, response);
        }
    }
}
