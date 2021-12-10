package controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ordered;
import model.Product;
import service.OrderedService;
import service.ProductService;
import service.impl.OrderedServiceImpl;
import service.impl.ProductServiceImpl;

public class OrderdetailListController extends HttpServlet {

    OrderedService orderedServcie = new OrderedServiceImpl();
    ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Ordered> orderedList = orderedServcie.getAll();
        request.setAttribute("orderedlist", orderedList);
        List<Product> products = new ArrayList<Product>();
        for (Ordered ordered : orderedList) {
            Product product = new Product();
            product = productService.get(Integer.parseInt(ordered.getProduct_id()));
            products.add(product);
        }
        request.setAttribute("products", products);
        request.getRequestDispatcher("/view/admin/show-orderdetail.jsp").forward(request, response);
    }
}
