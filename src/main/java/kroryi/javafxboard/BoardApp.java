package kroryi.javafxboard;

import kroryi.javafxboard.dto.Board;
import kroryi.javafxboard.service.BoardService;
import kroryi.javafxboard.service.BoardServiceImpl;

public class BoardApp {

        static BoardService boardService = new BoardServiceImpl();

        public static void main(String[] args) {
            for(Board board: boardService.list()){
                System.out.println(board.getNo()+" "+board.getTitle()+" "+board.getWriter()+" "+ board.getRegDate());
            }

//            Board board = new Board();
//            board.setTitle("good");
//            board.setWriter("John");
//            board.setContent("good");
//            boardService.insert(board);

//             게시글 등록


            //게시글 수정
//            Board boardselect = boardService.select(19);
//            System.out.println(boardselect.getTitle());
//            System.out.println(boardselect.getContent());
//            System.out.println(boardselect.getWriter());
//
//            boardselect.setTitle("aaa111");
//            boardselect.setContent("good");
//            boardselect.setWriter("James");
//            boardService.update(boardselect);

//             게시글 삭제 후 확인
//            boardService.delete(27);
//            for(Board board: boardService.list()){
//                System.out.println(board.getNo()+" "+board.getTitle()+" "+board.getWriter()+" "+ board.getRegDate());
//            }


            Board boardselect = boardService.select(19);
            boardselect.setWriter("Hong");
            System.out.println("게시글 상세보기");
            System.out.println("No."+boardselect.getNo());
            System.out.println("Title : "+boardselect.getTitle());
            System.out.println("Content : "+boardselect.getContent());
            System.out.println("Writer : "+boardselect.getWriter());

        }
    }

