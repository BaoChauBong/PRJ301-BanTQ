package controller;

import java.io.IOException;
import java.text.DecimalFormat;
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

public class ProductListClientController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    CategoryService cateService = new CategoryServicesImpl();
    ProductService productService = new ProductServiceImpl();
    DecimalFormat df = new DecimalFormat("#.000");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Catalog> cateList = cateService.getAll();
        request.setAttribute("catelist", cateList);
        List<Product> productList = productService.getAll();
        request.setAttribute("productlist", productList);
        //Giá giảm
        List<Product> productsList1 = new ArrayList<Product>();
        for (Product product : productList) {
            Product product1 = productService.get(Integer.parseInt(product.getId()));
            product1.setPrice(String.valueOf(df.format(Double.parseDouble(product.getPrice())
                    * (1 - (Double.parseDouble(product.getDiscount()) / 100)))));
            productsList1.add(product1);
        }

        request.setAttribute("productlist1", productsList1);
        // Product bán chạy
        List<Product> product_banchay = productService.getProductById(6);
        request.setAttribute("product_banchay", product_banchay);

        request.getRequestDispatcher("/view/client/product.jsp").forward(request, response);
    }

}
