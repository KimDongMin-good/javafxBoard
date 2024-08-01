package kroryi.javafxboard.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import kroryi.javafxboard.dto.User;
import kroryi.javafxboard.service.UserService;
import kroryi.javafxboard.service.UserServiceImpl;
import kroryi.javafxboard.util.CommonStatic;
import kroryi.javafxboard.util.SceneUtil;

import java.io.IOException;

public class ResignController {

    @FXML
    private Label lbUserName;
    @FXML
    private TextField tfUserId;
    @FXML
    private PasswordField tfUserPassword;

    private UserService userService = new UserServiceImpl();

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("알림창");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public void resign(ActionEvent event) throws IOException {
        String userId = tfUserId.getText();
        String userPassword = tfUserPassword.getText();
        if (userId == null || userId.trim().isEmpty()) {
            showAlert("아이디를 입력하세요.");
            return;
        }
        if (userPassword == null || userPassword.trim().isEmpty()) {
            showAlert("비밀번호를 입력하세요.");
            return;
        }
        User user = userService.select(userId);
//        System.out.println(userId);   --> id 잘 들어옴
        if (userPassword.equals(user.getPassword())) {
            System.out.println(CommonStatic.getUid());
            int result = userService.delete(CommonStatic.getUid());
            if (result > 0) {
                showAlert("회원탈퇴 완료");
                SceneUtil.getInstance().switchScene(event, UI.LOGIN.getPath());
            } else {
                showAlert("회원탈퇴 오류 다시 시도해주세요.");
            }
        } else {
            showAlert("비밀번호가 맞지 않습니다.");
        }
    }
    public void read(String userid) {
        User user = userService.select(String.valueOf(userid));
        lbUserName.setText(user.getUserName());
    }
}
