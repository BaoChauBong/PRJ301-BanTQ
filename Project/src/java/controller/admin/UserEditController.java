package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserService;
import service.impl.UserServicesImpl;

public class UserEditController extends HttpServlet {

    UserService userService = new UserServicesImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int user_id = Integer.parseInt(request.getParameter("user-id"));
        User user = userService.get(user_id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/view/admin/edituser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        int user_id = Integer.parseInt(request.getParameter("user-id"));
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
        user.setId(user_id);
        userService.edit(user);
        response.sendRedirect(request.getContextPath() + "/admin/user/list");
    }

}
