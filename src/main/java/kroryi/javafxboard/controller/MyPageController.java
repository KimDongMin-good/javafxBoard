package kroryi.javafxboard.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import kroryi.javafxboard.dto.Board;
import kroryi.javafxboard.dto.User;
import kroryi.javafxboard.service.UserService;
import kroryi.javafxboard.service.UserServiceImpl;
import kroryi.javafxboard.util.CommonStatic;
import kroryi.javafxboard.util.SceneUtil;

import java.io.IOException;
import java.sql.SQLException;

public class MyPageController {

    @FXML
    private Label lbUserName;
    @FXML
    private TextField tfUserId;
    @FXML
    private PasswordField tfUserPassword;
    @FXML
    private PasswordField tfPasswordChk;


    int uid;
    private UserService userService = new UserServiceImpl();

    public void moveToChange(ActionEvent event) throws IOException {
        System.out.println("회원정보 수정 화면 이동");
        SceneUtil.getInstance().switchScene(event, UI.UserUpdate.getPath());
    }

    public void moveToResign(ActionEvent event) throws IOException {
        System.out.println("회원탈퇴 페이지 이동");
        SceneUtil.getInstance().switchScene(event, UI.RESIGN.getPath());
    }

    public void read(String userid) {
        lbUserName.setText(CommonStatic.getUserName()+"님 환영합니다.");
    }
}
