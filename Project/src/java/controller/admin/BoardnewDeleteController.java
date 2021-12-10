package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardnewService;
import service.impl.BoardnewServicesImpl;

public class BoardnewDeleteController extends HttpServlet {

    BoardnewService boardnewService = new BoardnewServicesImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        boardnewService.delete(Integer.parseInt(id));
        response.sendRedirect(request.getContextPath() + "/admin/new/list");
    }

}
