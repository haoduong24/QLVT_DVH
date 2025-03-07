package Control;

import dao.DanhMucDAO;
import dao.DAO;
import entity.DanhMuc;
import entity.Product;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeControl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Khởi tạo DAO
            DAO productDAO = new DAO();
            DanhMucDAO danhMucDAO = new DanhMucDAO();

            // Lấy danh sách sản phẩm và danh mục
            List<Product> listP = productDAO.getAllProducts();
            List<DanhMuc> listC = danhMucDAO.getAllCategories();

            // Đưa dữ liệu vào request
            request.setAttribute("listP", listP);
            request.setAttribute("listCC", listC);

            // Chuyển hướng tới trang Home1.jsp
            request.getRequestDispatcher("Home1.jsp").forward(request, response);
        } catch (Exception e) {
            
        }
    }
}
