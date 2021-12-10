package service.impl;

import java.util.List;

import dao.BoardnewDao;
import dao.impl.BoardnewDaoImpl;
import model.Boardnew;
import service.BoardnewService;

public class BoardnewServicesImpl implements BoardnewService {

    BoardnewDao boardnewDao = new BoardnewDaoImpl();

    @Override
    public void insert(Boardnew boardnew) {
        boardnewDao.insert(boardnew);
    }

    @Override
    public void edit(Boardnew newBoardnew) {
        Boardnew oldBoardnew = boardnewDao.get(Integer.parseInt(newBoardnew.getId()));
        System.out.println("xem thử có chưa " + oldBoardnew);
        oldBoardnew.setTitle(newBoardnew.getTitle());
        oldBoardnew.setContent(newBoardnew.getContent());
        oldBoardnew.setImage_link(newBoardnew.getImage_link());
        oldBoardnew.setAuthor(newBoardnew.getAuthor());
        oldBoardnew.setCreated(newBoardnew.getCreated());
        boardnewDao.edit(oldBoardnew);
    }

    @Override
    public void delete(int id) {
        boardnewDao.delete(id);
    }

    @Override
    public Boardnew get(int id) {
        return boardnewDao.get(id);
    }

    @Override
    public Boardnew get(String name) {
        return boardnewDao.get(name);
    }

    @Override
    public List<Boardnew> getAll() {
        return boardnewDao.getAll();
    }

}
