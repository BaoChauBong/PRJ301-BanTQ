package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Catalog;
import model.Product;
import service.CategoryService;
import service.ProductService;
import service.impl.CategoryServicesImpl;
import service.impl.ProductServiceImpl;

public class ProductEditController extends HttpServlet {

    ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryService cateService = new CategoryServicesImpl();
        List<Catalog> cateList = cateService.getAll();
        request.setAttribute("catelist", cateList);

        String id = request.getParameter("id");
        Product product = productService.get(Integer.parseInt(id));
        request.setAttribute("product", product);

        request.getRequestDispatcher("/view/admin/editproduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        Product product = new Product();
        product.setId(request.getParameter("product-sku"));
        product.setCatalog_id(request.getParameter("product-cate"));
        product.setName(request.getParameter("product-name"));
        product.setPrice(request.getParameter("product-price"));
        product.setStatus(request.getParameter("product-status"));
        product.setDescription(request.getParameter("product-desc"));
        product.setContent(request.getParameter("product-content"));
        product.setDiscount(request.getParameter("product-discount"));
        product.setImage_link(request.getParameter("product-image"));
        product.setCreated(request.getParameter("product-day"));
        productService.edit(product);

        response.sendRedirect(request.getContextPath() + "/admin/product/list");

    }
}
