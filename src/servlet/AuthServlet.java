package servlet;

import java.io.IOException;
import dao.NguoiDungDAO;
import entity.NguoiDung;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.AuthUtil;
import util.ParamUtil;

@WebServlet({ "/dang-nhap", "/logout" })
public class AuthServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    NguoiDungDAO userDAO = new NguoiDungDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("logout")) {
            AuthUtil.clear(request);
            response.sendRedirect(request.getContextPath() + "/dang-nhap");
            return;
        }
        request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = ParamUtil.getString(request, "email");
        String password = ParamUtil.getString(request, "password");
        NguoiDung user = userDAO.findByEmail(email);

        if (user != null && user.getMatKhau().equals(password)) {
            // Lưu trạng thái đăng nhập vào session
            AuthUtil.setUser(request, user);
            String redirectUrl = request.getContextPath() + "/manager/categories";
            if (request.getSession().getAttribute("REDIRECT_URL") != null) {
                redirectUrl = (String) request.getSession().getAttribute("REDIRECT_URL");
                request.getSession().removeAttribute("REDIRECT_URL");
            }
            response.sendRedirect(redirectUrl);
            return;
        }

        request.setAttribute("message", "Tài khoản hoặc mật khẩu không đúng!");
        request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
    }
}
