package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TransactionService;
import service.impl.TransactionServicesImpl;

public class OrderDeleteController extends HttpServlet {

    TransactionService transactionService = new TransactionServicesImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        transactionService.delete(id);
        response.sendRedirect(request.getContextPath() + "/admin/order/list");
    }
}
