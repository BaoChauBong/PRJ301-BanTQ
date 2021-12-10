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

public class BoardnewListClientDetailController extends HttpServlet {

    BoardnewService boardnewService = new BoardnewServicesImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Boardnew boardnew = boardnewService.get(Integer.parseInt(id));
        request.setAttribute("boardnew", boardnew);

        List<Boardnew> boardnewList = boardnewService.getAll();
        request.setAttribute("boardnewlist", boardnewList);

        request.getRequestDispatcher("/view/client/blog-single.jsp").forward(request, response);
    }

}
