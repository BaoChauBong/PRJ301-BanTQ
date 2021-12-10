package controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Item;
import model.Order;
import model.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;

public class DeleteProductInCartController extends HttpServlet {

    ProductService productservice = new ProductServiceImpl();
    DecimalFormat df = new DecimalFormat("#.000");
    DecimalFormat df1 = new DecimalFormat("#.0");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        HttpSession session = request.getSession(true);
        Product product = productservice.get(Integer.parseInt(id));
        Order order = (Order) session.getAttribute("order");
        List<Item> listItems = order.getItems();
        for (Item item : listItems) {
            if (Integer.parseInt(item.getProduct().getId()) == Integer.parseInt(product.getId())) {
                order.setSumPrice(order.getSumPrice() - item.getPrice());
                listItems.remove(item);
                break;
            }
        }
        order.setItems(listItems);
        session.setAttribute("order", order);
        response.sendRedirect(request.getContextPath() + "/view/client/cart");
        if (order.getSumPrice() == 0) {
            session.setAttribute("sumprice", "0");
        } else {
            session.setAttribute("sumprice", df.format(order.getSumPrice()));
        }

    }
}
