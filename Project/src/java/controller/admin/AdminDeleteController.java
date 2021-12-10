package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminService;
import service.impl.AdminServicesImpl;

public class AdminDeleteController extends HttpServlet {

    AdminService adminService = new AdminServicesImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String admin_id = request.getParameter("admin-id");
        adminService.delete(admin_id);
        request.setAttribute("adminlist", adminService.getAll());
        request.getRequestDispatcher("/view/admin/admin.jsp").forward(request, response);
    }
}
