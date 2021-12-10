package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;

public class ProductListController extends HttpServlet {

    ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.getAll();
        request.setAttribute("productlist", productList);
        request.getRequestDispatcher("/view/admin/show-product.jsp").forward(request, response);
    }
}
