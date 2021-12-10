package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Boardnew;
import service.BoardnewService;
import service.impl.BoardnewServicesImpl;

public class BoardnewListClientController extends HttpServlet {

    BoardnewService boardnewService = new BoardnewServicesImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Boardnew> boardnewList = boardnewService.getAll();
        request.setAttribute("boardnewlist", boardnewList);
        request.getRequestDispatcher("/view/client/blog-archive.jsp").forward(request, response);
    }

}
