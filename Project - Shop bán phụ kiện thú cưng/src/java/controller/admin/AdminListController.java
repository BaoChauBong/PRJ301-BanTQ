package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import model.Admin;
import service.AdminService;
import service.impl.AdminServicesImpl;

public class AdminListController extends HttpServlet {

    AdminService adminService = new AdminServicesImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Admin> adminList = adminService.getAll();
        request.setAttribute("adminlist", adminList);
        request.getRequestDispatcher("/view/admin/admin.jsp").forward(request, response);
    }
}
