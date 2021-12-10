package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import model.Catalog;
import service.CategoryService;
import service.impl.CategoryServicesImpl;

public class CategoryListController extends HttpServlet {

    CategoryService cateService = new CategoryServicesImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Catalog> cateList = cateService.getAll();
        request.setAttribute("catelist", cateList);
        request.getRequestDispatcher("/view/admin/show-cate.jsp").forward(request, response);
    }

}
