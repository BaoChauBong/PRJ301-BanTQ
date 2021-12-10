package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Admin;
import service.AdminService;
import service.impl.AdminServicesImpl;

public class AdminAddController extends HttpServlet {

    AdminService adminService = new AdminServicesImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/admin/addadmin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String admin_username = request.getParameter("admin-username");
        String admin_password = request.getParameter("admin-password");
        String admin_name = request.getParameter("admin-name");
        Admin admin = new Admin();
        admin.setUsername(admin_username);
        admin.setPassword(admin_password);
        admin.setName(admin_name);
        adminService.insert(admin);
        response.sendRedirect(request.getContextPath() + "/admin/admin/list");
    }
}
