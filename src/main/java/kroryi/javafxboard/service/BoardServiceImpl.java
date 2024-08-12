package kroryi.javafxboard.service;

import kroryi.javafxboard.dao.BoardDAO;
import kroryi.javafxboard.dto.Board;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class BoardServiceImpl implements BoardService {


    private BoardDAO boardDAO = new BoardDAO();
    private Connection connection;

    @Override
    public List<Board> list() {
        List<Board> boardList = (List<Board>) boardDAO.selectlist();
        return boardList;
    }

    @Override
    public Board select(int no) {
        Board board = boardDAO.select(no);
        return board;
    }

    @Override
    public int insert(Board board) {
        int result = boardDAO.insert(board);
        return result;
    }

    @Override
    public int update(Board board) {
        int result = boardDAO.update(board);
        return result;
    }

    @Override
    public int delete(int no) {
        int result = boardDAO.delete(no);
        return result;
    }

    @Override
    public List<Board> pageList(int pageNo){
        List<Board> boardList = boardDAO.selectPageList(pageNo);
        return boardList;
    }

    @Override
    public int totalListCount(){
        int count = boardDAO.selectTotalCount();
        return count;
    }
}
