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
import model.Review;
import service.CategoryService;
import service.ProductService;
import service.ReviewService;
import service.impl.CategoryServicesImpl;
import service.impl.ProductServiceImpl;
import service.impl.ReviewServicesImpl;

public class ProductDetailController extends HttpServlet {

    CategoryService cateService = new CategoryServicesImpl();
    ProductService productService = new ProductServiceImpl();
    ReviewService reviewService = new ReviewServicesImpl();
    DecimalFormat df = new DecimalFormat("#.000");

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Product detail_product = productService.get(Integer.parseInt(id));
        request.setAttribute("detail_product", detail_product);

        List<Catalog> name_cate_of_product = cateService.getCateByProduct(Integer.parseInt(id));
        request.setAttribute("name_cate_of_product", name_cate_of_product);

        String idCate = detail_product.getCatalog_id();

        List<Product> productListCate = productService.getProductById(Integer.parseInt(idCate));

        request.setAttribute("productById", productListCate);

        List<Review> reviewById = reviewService.getReviewById(Integer.parseInt(id));
        request.setAttribute("reviewbyid", reviewById);

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
        request.getRequestDispatcher("/view/client/product-detail.jsp").forward(request, response);
    }

}
