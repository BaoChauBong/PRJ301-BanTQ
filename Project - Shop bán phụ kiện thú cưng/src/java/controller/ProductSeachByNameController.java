package controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
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

public class ProductSeachByNameController extends HttpServlet {

    CategoryService cateService = new CategoryServicesImpl();
    ProductService productService = new ProductServiceImpl();
    DecimalFormat df = new DecimalFormat("#.000");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("s");
        List<Catalog> cateList = cateService.getAll();
        request.setAttribute("catelist", cateList);

        List<Product> productSeachByName = productService.searchByName(name);
        request.setAttribute("productlist", productSeachByName);

        List<Product> productAllList = productService.getAll();
        request.setAttribute("product_all", productAllList);

        //Giá giảm
        List<Product> productsList1 = new ArrayList<Product>();
        for (Product product : productSeachByName) {
            Product product1 = productService.get(Integer.parseInt(product.getId()));
            product1.setPrice(String.valueOf(df.format(Double.parseDouble(product.getPrice())
                    * (1 - (Double.parseDouble(product.getDiscount()) / 100)))));
            productsList1.add(product1);

        }

        request.setAttribute("productlist1", productsList1);
        // Product bán chạy
        List<Product> product_banchay = productService.getProductById(6);
        request.setAttribute("product_banchay", product_banchay);

        request.getRequestDispatcher("/view/client/product-search.jsp").forward(request, response);
    }
}
