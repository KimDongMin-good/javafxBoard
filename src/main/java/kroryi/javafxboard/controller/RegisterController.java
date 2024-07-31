package kroryi.javafxboard.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import kroryi.javafxboard.dto.User;
import kroryi.javafxboard.service.UserService;
import kroryi.javafxboard.service.UserServiceImpl;
import kroryi.javafxboard.util.SceneUtil;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    public TextField tfId;
    @FXML
    public TextField tfUserName;
    @FXML
    public PasswordField tfPw;
    @FXML
    public PasswordField tfPwre;

    Stage stage;
    Scene scene;
    Parent root;

    private UserService userService = new UserServiceImpl();

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("입력 오류");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public void join(ActionEvent event) throws IOException {

        String userId = tfId.getText();
        String userName = tfUserName.getText();
        String passWord = tfPw.getText();
        String passWord_re = tfPwre.getText();
        if (userId == null || userId.trim().isEmpty()) {
            showAlert("아이디를 입력하세요.");
            return;
        }
        if (userName == null || userName.trim().isEmpty()) {
            showAlert("사용자명을 입력하세요.");
            return;
        }
        if (passWord == null || passWord.trim().isEmpty()) {
            showAlert("비밀번호를 입력하세요.");
            return;
        }
        if (passWord_re == null || passWord_re.trim().isEmpty()) {
            showAlert("비밀번호를 확인 해주세요.");
        }
        assert passWord != null;
        if (!passWord.trim().equals(passWord_re.trim())) {
            showAlert("비밀번호가 일치하지 않습니다.");
        }else {
            User user = new User(tfId.getText(), tfUserName.getText(), tfPw.getText());
            int result = userService.insert(user);
            if (result > 0) {
                showAlert("회원가입 성공");
                SceneUtil.getInstance().switchScene(event, UI.LOGIN.getPath());
            } else {
                showAlert("회원가입에 문제가 발생 했습니다.");
            }
        }

    }

    public void goToLogin(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
