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

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("알림창");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public void MyPageBtn(ActionEvent event) throws IOException {
        String userId = tfUserId.getText();
        String userPassword = tfUserPassword.getText();
        String passwordChk = tfPasswordChk.getText();
        if (userId == null || userId.trim().isEmpty()) {
            showAlert("아이디를 입력하세요.");
            return;
        }
        if (userPassword == null || userPassword.trim().isEmpty()) {
            showAlert("비밀번호를 입력하세요.");
            return;
        }
        if (passwordChk == null || passwordChk.trim().isEmpty()) {
            showAlert("비밀번호를 확인 해주세요.");
        }
        assert userPassword != null;
        if (!userPassword.trim().equals(passwordChk.trim())) {
            showAlert("비밀번호가 일치하지 않습니다.");
        } else {
            User user = userService.select(userId);
            user.setUserId(userId);
            user.setPassword(userPassword);
            int result = userService.update(user);
            System.out.println(user.toString());
            System.out.println("result:" + result);
            if (result > 0) {
                showAlert("정보수정 완료");
                SceneUtil.getInstance().switchScene(event, UI.LOGIN.getPath());
            } else {
                showAlert("정보수정에 문제가 발생 했습니다.");
            }
        }

    }

    public void resign(ActionEvent event) throws IOException {
        String userId = tfUserId.getText();
        String userPassword = tfUserPassword.getText();
        String passwordChk = tfPasswordChk.getText();
        if (userId == null || userId.trim().isEmpty()) {
            showAlert("아이디를 입력하세요.");
            return;
        }
        if (userPassword == null || userPassword.trim().isEmpty()) {
            showAlert("비밀번호를 입력하세요.");
            return;
        }
        User user = userService.select(userId);
        if (userPassword.equals(user.getPassword())) {
            int result = userService.delete(uid);
            if (result > 0) {
                showAlert("회원탈퇴 완료");
                SceneUtil.getInstance().switchScene(event, UI.LOGIN.getPath());
            } else {
                showAlert("회원탈퇴 오류 다시 시도해주세요.");
            }
        } else {
            System.out.println("비밀번호가 맞지 않습니다.");
        }
    }

    public void read(String userid) {
        User user = userService.select(String.valueOf(userid));
        uid = user.getuId();
        lbUserName.setText(user.getUserName());
    }
}