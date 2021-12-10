package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import model.User;
import service.UserService;
import service.impl.UserServicesImpl;

public class UserListController extends HttpServlet {

    UserService userService = new UserServicesImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userService.getAll();
        request.setAttribute("userList", users);
        request.getRequestDispatcher("/view/admin/user.jsp").forward(request, response);
    }
}
