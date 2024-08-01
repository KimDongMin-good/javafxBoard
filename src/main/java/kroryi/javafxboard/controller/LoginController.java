package kroryi.javafxboard.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import kroryi.javafxboard.Controller;
import kroryi.javafxboard.dto.User;
import kroryi.javafxboard.service.UserService;
import kroryi.javafxboard.service.UserServiceImpl;
import kroryi.javafxboard.util.CommonStatic;
import kroryi.javafxboard.util.SceneUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginController {

    @FXML
    private TextField tfId;
    @FXML
    private PasswordField tfPw;

    private Alert alert;

    private UserService userService = new UserServiceImpl();

    public void logIn(ActionEvent event) throws IOException {
        if(tfId.getText().isEmpty() || tfPw.getText().isEmpty()) {
            showAlert(ErrorCode.LOGIN_INPUT_ERROR, null, Alert.AlertType.ERROR);
            return;
        }else{
            User user = userService.select(tfId.getText());
            System.out.println(user.getUserId());
            if(user.getUserId().isEmpty()){
                showAlert(ErrorCode.USER_NOT_FOUND, null, Alert.AlertType.ERROR);
                return;
            }else{
                // 추후 암호화 추가
                if(!user.getPassword().equals(tfPw.getText())){
                    showAlert(ErrorCode.LOGIN_FAILED, null, Alert.AlertType.ERROR);
                    return;
                }else{
                    showAlert(ErrorCode.LOGIN_SUCCESS, user.getUserId(), Alert.AlertType.INFORMATION);
                    CommonStatic.setUid(user.getuId());
                    CommonStatic.setUserId(user.getUserId());
                    CommonStatic.setUserName(user.getUserName());
                    Controller controller = (Controller) SceneUtil.getInstance().getController(UI.LIST.getPath());
                    controller.userid = user.getUserId();
                    Parent root = SceneUtil.getInstance().getRoot();
                    SceneUtil.getInstance().switchScene(event, "", root);
                }
            }
        }
    }

    public void goToRegister(ActionEvent event) throws IOException {
        RegisterController registerController = (RegisterController) SceneUtil.getInstance().getController(UI.REGISTER.getPath());
        Parent root = SceneUtil.getInstance().getRoot();
        SceneUtil.getInstance().switchScene(event, UI.REGISTER.getPath(), root);
    }

    public void showAlert(String title, String header, String content) {

        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public void showAlert(ErrorCode errorCode, String parameter, Alert.AlertType alertType){
        alert = new Alert(alertType);
        String message = StringResource.getErrorMessage(errorCode);
        if(parameter != null) {
            message = String.format(message, parameter);
        }
        showAlert("로그인" + (alertType == Alert.AlertType.ERROR ? "오류" : "알림"),
                null, message);
    }
    // inner Class //
    public class StringResource{
        private static final Map<ErrorCode, String> errorMessages = new HashMap<>();

        static {
            errorMessages.put(ErrorCode.LOGIN_INPUT_ERROR, "ID나 PW 입력하지 않았습니다.");
            errorMessages.put(ErrorCode.USER_NOT_FOUND, "사용자가 존재하지 않습니다.");
            errorMessages.put(ErrorCode.LOGIN_FAILED, "비밀번호가 일치하지 않습니다.");
            errorMessages.put(ErrorCode.LOGIN_SUCCESS, "%s 님 환영합니다.");
        }
        public static String getErrorMessage(ErrorCode errorCode) {
            return errorMessages.get(errorCode);
        }
    }

    public enum ErrorCode{
        LOGIN_INPUT_ERROR,
        USER_NOT_FOUND,
        LOGIN_FAILED,
        LOGIN_SUCCESS
    }

}
