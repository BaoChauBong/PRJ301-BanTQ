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

public class OrderEditController extends HttpServlet {

    TransactionService transactionService = new TransactionServicesImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        Transactions transaction = transactionService.get(Integer.parseInt(id));
        request.setAttribute("order", transaction);

        request.getRequestDispatcher("/view/admin/editorder.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        Transactions transactions = new Transactions();
        transactions.setId(Integer.parseInt(request.getParameter("order-id")));
        transactions.setUser_name(request.getParameter("order-name"));
        transactions.setUser_mail(request.getParameter("order-mail"));
        transactions.setUser_phone(request.getParameter("order-phone"));
        transactions.setAddress(request.getParameter("order-address"));
        transactions.setMessage(request.getParameter("order-mess"));
        transactions.setAmount(request.getParameter("order-amount"));
        transactions.setPayment(request.getParameter("order-payment"));
        transactions.setStatus(request.getParameter("order-status"));
        transactionService.edit(transactions);
        response.sendRedirect(request.getContextPath() + "/admin/order/list");
    }
}
