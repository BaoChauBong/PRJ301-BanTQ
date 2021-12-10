package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Boardnew;
import service.BoardnewService;
import service.impl.BoardnewServicesImpl;

public class BoardnewAddController extends HttpServlet {

    BoardnewService boardnewService = new BoardnewServicesImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/admin/addboardnew.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String new_title = request.getParameter("new-title");
        String new_content = request.getParameter("new-content");
        String new_image_link = request.getParameter("new-image_link");
        String new_author = request.getParameter("new-author");
        String new_created = request.getParameter("new-created");
        Boardnew boardnew = new Boardnew();
        boardnew.setTitle(new_title);
        boardnew.setContent(new_content);
        boardnew.setImage_link(new_image_link);
        boardnew.setAuthor(new_author);
        boardnew.setCreated(new_created);
        boardnewService.insert(boardnew);
        response.sendRedirect(request.getContextPath() + "/admin/new/list");
    }

}
