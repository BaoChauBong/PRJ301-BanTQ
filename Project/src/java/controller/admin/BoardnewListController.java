package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Boardnew;
import service.BoardnewService;
import service.impl.BoardnewServicesImpl;

public class BoardnewListController extends HttpServlet {

    BoardnewService newService = new BoardnewServicesImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Boardnew> boardnewList = newService.getAll();
        request.setAttribute("boardnewlist", boardnewList);
        request.getRequestDispatcher("/view/admin/show-new.jsp").forward(request, response);
    }
}
