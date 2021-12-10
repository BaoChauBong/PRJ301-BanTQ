package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.impl.UserServicesImpl;

public class UserDeleteController extends HttpServlet {

    UserService userService = new UserServicesImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int user_id = Integer.parseInt(request.getParameter("user-id"));
        userService.delete(user_id);
        request.getRequestDispatcher("/view/admin/user.jsp").forward(request, response);
    }
}
