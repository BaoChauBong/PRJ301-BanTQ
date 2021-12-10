package controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Item;
import model.Order;

public class UpdateCartController extends HttpServlet {

    DecimalFormat df = new DecimalFormat("#.000");

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(request.getContextPath() + "/view/client/cart").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Order order = (Order) session.getAttribute("order");
        List<Item> listItems = order.getItems();
        order.setSumPrice(0);
        for (Item item : listItems) {
            item.setQty(Integer.parseInt(request.getParameter(item.getProduct().getId())));
            item.setPrice((Double.parseDouble(item.getProduct().getPrice())
                    - Double.parseDouble(item.getProduct().getPrice())
                    * (Double.parseDouble(item.getProduct().getDiscount()) / 100))
                    * Double.parseDouble(request.getParameter(item.getProduct().getId())));
            order.setSumPrice(order.getSumPrice() + item.getPrice());
        }
        order.setItems(listItems);
        session.setAttribute("order", order);
        session.setAttribute("sumprice", df.format(order.getSumPrice()));
        response.sendRedirect(request.getContextPath() + "/view/client/cart");
    }
}
