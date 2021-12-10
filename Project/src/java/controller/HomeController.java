package controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import model.Boardnew;
import model.Product;
import service.BoardnewService;
import service.ProductService;
import service.impl.BoardnewServicesImpl;
import service.impl.ProductServiceImpl;
import javax.servlet.http.HttpServletResponse;

public class HomeController extends HttpServlet {

    ProductService productService = new ProductServiceImpl();
    BoardnewService boardnewService = new BoardnewServicesImpl();
    DecimalFormat df = new DecimalFormat("#.000");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Boardnew> boardnewList = boardnewService.getAll();
        request.setAttribute("boardnewlist", boardnewList);
        // Product Dog
        List<Product> product_cho = productService.getProductById(1);
        request.setAttribute("product_cho", product_cho);

        // Product Cat
        List<Product> product_meo = productService.getProductById(2);
        request.setAttribute("product_meo", product_meo);

        // Product Box
        List<Product> product_box = productService.getProductById(3);
        request.setAttribute("product_box", product_box);

        // Product Other
        List<Product> product_khac = productService.getProductById(4);
        request.setAttribute("product_khac", product_khac);

        // Product mới
        List<Product> product_new = productService.getProductById(5);
        request.setAttribute("product_new", product_new);

        // Product bán chạy
        List<Product> product_banchay = productService.getProductById(6);
        request.setAttribute("product_banchay", product_banchay);

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

        // Product giảm giá
        List<Product> product_sale = productService.getProductById(7);
        request.setAttribute("product_sale", product_sale);

        request.getRequestDispatcher("/view/client/index.jsp").forward(request, response);
    }
}
