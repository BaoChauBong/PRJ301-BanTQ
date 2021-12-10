package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ReviewService;
import service.impl.ReviewServicesImpl;

public class ReviewDeleteController extends HttpServlet {

    ReviewService reviewService = new ReviewServicesImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        reviewService.delete(Integer.parseInt(id));
        response.sendRedirect(request.getContextPath() + "/admin/review/list");
    }

}
