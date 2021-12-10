package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Transactions;
import service.TransactionService;
import service.impl.TransactionServicesImpl;

public class OrderListController extends HttpServlet {

    TransactionService transactionService = new TransactionServicesImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Transactions> transactionList = transactionService.getAll();
        request.setAttribute("order", transactionList);
        request.getRequestDispatcher("/view/admin/show-order.jsp").forward(request, response);
    }

}
