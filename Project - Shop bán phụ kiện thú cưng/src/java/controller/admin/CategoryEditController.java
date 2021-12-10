package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Catalog;
import service.CategoryService;
import service.impl.CategoryServicesImpl;

public class CategoryEditController extends HttpServlet {

    CategoryService cateService = new CategoryServicesImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Catalog catelist = cateService.get(Integer.parseInt(id));
        request.setAttribute("catelist", catelist);

        request.getRequestDispatcher("/view/admin/editcate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        Catalog category = new Catalog();
        category.setName(request.getParameter("name"));
        category.setParent_id(request.getParameter("parent-id"));
        category.setId(request.getParameter("id"));
        cateService.edit(category);

        response.sendRedirect(request.getContextPath() + "/admin/cate/list");
    }
}
