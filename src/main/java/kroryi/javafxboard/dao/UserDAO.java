package kroryi.javafxboard.dao;

import kroryi.javafxboard.dto.Board;
import kroryi.javafxboard.dto.User;

import java.sql.SQLException;

public class UserDAO extends JDBConnection{

    public User select(String userId){
        User user = new User();
        String sql = "select * from User where userId=?";

        try{
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();

            if(rs.next()){
                user.setuId(rs.getInt("uid"));
                user.setUserId(rs.getString("userId"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
            }else{
                System.out.println(userId + "존재하지 않는 사용자 입니다.");
                userId = null;
            }
        }catch(SQLException e){
            System.out.println("사용자 조회 에러");
            e.printStackTrace();
        }
        return user;
    }
    public int insert(User user){

        int result = 0;
        String sql = "insert into User (userId,userName,password) values(?,?,?)";

        try{
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getUserName());
            pstmt.setString(3, user.getPassword());
            result = pstmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("사용자를 DB에 등록 시 문제발생");
            e.printStackTrace();
        }
        return result;
    }
    public int update(User user) {
        int result = 0;
        String sql = "update User set userId = ?, password = ? where uid = ?";

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getPassword());
            pstmt.setInt(3, user.getuId());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("회원정보 수정 에러");
        }
        return result;
    }
    public int delete(int uid){
        int result = 0;
        String sql = "delete from User where uid = ?";  //test   1

        try {
            System.out.println("22222222222222222222:" + sql);
            pstmt = con.prepareStatement(sql);
            System.out.println("22222222222222222223");
            pstmt.setInt(1, uid); //test  1
            System.out.println("22222222222222222224");
            result = pstmt.executeUpdate();     //1
            System.out.println("22222222222222222225");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("회원탈퇴 에러");
        }
        return result;
    }
}
