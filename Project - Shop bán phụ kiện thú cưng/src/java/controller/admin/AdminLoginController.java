package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminLoginDao;
import model.Admin;

@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {

    public AdminLoginController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/view/admin/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String username = request.getParameter("admin-username");
        String password = request.getParameter("admin-password");
        Admin admin = new Admin();
        admin.setName(request.getParameter("name"));

        if (AdminLoginDao.checkAdminLogin(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("admin-username", username);
            session.setAttribute("admin-password", password);
            response.sendRedirect(request.getContextPath() + "/admin/homepage");
        } else {
            request.setAttribute("errorMessage", "Tài khoản đăng nhập hoặc mật khẩu sai !!!");
            request.getRequestDispatcher("/view/admin/login.jsp").forward(request, response);
        }
    }
}
