package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CategoryService;
import service.impl.CategoryServicesImpl;
import model.Catalog;

public class CategoryAddController extends HttpServlet {

    CategoryService cateService = new CategoryServicesImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/admin/addcate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String cate_name = request.getParameter("cate-name");
        String cate_parent_id = request.getParameter("parent-id");
        Catalog category = new Catalog();
        category.setName(cate_name);
        category.setParent_id(cate_parent_id);
        cateService.insert(category);
        response.sendRedirect(request.getContextPath() + "/admin/cate/list");
    }

}
