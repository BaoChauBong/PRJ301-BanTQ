package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CategoryService;
import service.impl.CategoryServicesImpl;

public class CategoryeDeleteController extends HttpServlet {

    CategoryService cateService = new CategoryServicesImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        cateService.delete(id);

        response.sendRedirect(request.getContextPath() + "/admin/cate/list");
    }
}
