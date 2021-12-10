package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Review;
import service.ReviewService;
import service.impl.ReviewServicesImpl;

public class ReviewClientController extends HttpServlet {

    ReviewService reviewService = new ReviewServicesImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(request.getContextPath() + "/view/client/product-detail?id="
                + request.getParameter("id")).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        System.out.println("thử: " + id);
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String content = request.getParameter("content");
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String today = df.format(date);
        Review review = new Review();
        review.setName(name);
        review.setEmail(email);
        review.setProduct_id(id);
        review.setContent(content);
        review.setCreated(today);
        System.out.println("thử tostring: " + review);
        reviewService.insert(review);
        response.sendRedirect(request.getContextPath() + "/view/client/product-detail?id=" + id);
    }
}
