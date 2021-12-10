package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Admin;
import service.AdminService;
import service.impl.AdminServicesImpl;

public class AdminEditController extends HttpServlet {

    AdminService adminService = new AdminServicesImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int admin_id = Integer.parseInt(request.getParameter("id"));
        Admin admin = adminService.get(admin_id);
        request.setAttribute("admin", admin);
        request.getRequestDispatcher("/view/admin/editadmin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        int admin_id = Integer.parseInt(request.getParameter("id"));
        String admin_username = request.getParameter("username");
        String admin_password = request.getParameter("password");
        String admin_name = request.getParameter("name");

        Admin admin = new Admin();
        admin.setId(admin_id);
        admin.setUsername(admin_username);
        admin.setPassword(admin_password);
        admin.setName(admin_name);
        adminService.edit(admin);
        response.sendRedirect(request.getContextPath() + "/admin/admin/list");

    }
}
