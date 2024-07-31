package kroryi.javafxboard.dao;

import javafx.beans.property.SimpleStringProperty;
import kroryi.javafxboard.dto.Board;
import kroryi.javafxboard.service.BoardService;
import kroryi.javafxboard.service.BoardServiceImpl;

import java.sql.*;
import java.util.List;

public class JDBConnection {

    public Connection con;
    public Statement stmt;
    public PreparedStatement pstmt;
    public ResultSet rs;

    public JDBConnection() {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bbs?useSSL=false&allowPublicKeyRetrieval=true";
            String username = "root";
            String passward = "159357!@";

            con = DriverManager.getConnection(url, username, passward);
//            System.out.println("DB 연결 성공");

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("DB 연결 실패");
        }
    }
    public static void main(String[] args){

    }
}
