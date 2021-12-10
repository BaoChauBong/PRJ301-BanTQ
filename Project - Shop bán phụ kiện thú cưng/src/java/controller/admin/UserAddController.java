package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserService;
import service.impl.UserServicesImpl;

public class UserAddController extends HttpServlet {

    UserService userService = new UserServicesImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/admin/adduser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String user_name = request.getParameter("user-name");
        String user_email = request.getParameter("user-email");
        String user_phone = request.getParameter("user-phone");
        String user_userName = request.getParameter("user-userName");
        String user_password = request.getParameter("user-password");
        String user_created = request.getParameter("user-created");

        User user = new User();
        user.setName(user_name);
        user.setEmail(user_email);
        user.setPhone(user_phone);
        user.setUsername(user_userName);
        user.setPassword(user_password);
        user.setCreated(user_created);
        userService.insert(user);
        response.sendRedirect(request.getContextPath() + "/admin/user/list");
    }

}
