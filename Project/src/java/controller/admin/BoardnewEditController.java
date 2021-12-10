package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Boardnew;
import service.BoardnewService;
import service.impl.BoardnewServicesImpl;

public class BoardnewEditController extends HttpServlet {

    BoardnewService boardnewService = new BoardnewServicesImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Boardnew boardnew = boardnewService.get(Integer.parseInt(id));
        request.setAttribute("boardnew", boardnew);
        request.getRequestDispatcher("/view/admin/editboardnew.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        Boardnew boardnew = new Boardnew();
        boardnew.setId(request.getParameter("new-id"));
        boardnew.setTitle(request.getParameter("new-title"));
        boardnew.setContent(request.getParameter("new-content"));
        boardnew.setImage_link(request.getParameter("new-image_link"));
        boardnew.setAuthor(request.getParameter("new-author"));
        boardnew.setCreated(request.getParameter("new-created"));
        boardnewService.edit(boardnew);

        response.sendRedirect(request.getContextPath() + "/admin/new/list");

    }

}
