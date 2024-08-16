package kroryi.javafxboard.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import kroryi.javafxboard.dto.Board;
import kroryi.javafxboard.service.BoardService;
import kroryi.javafxboard.service.BoardServiceImpl;
import kroryi.javafxboard.util.CommonStatic;
import kroryi.javafxboard.util.SceneUtil;

import java.io.IOException;

public class InsertController {

    Stage stage;
    Scene scene;
    Parent root;

    BoardService boardService = new BoardServiceImpl();

    @FXML
    private TextField tfTitle;
    @FXML
    private Label lbWriter;
    @FXML
    private TextArea taContent;

    public void moveToList(ActionEvent event) throws IOException {
        System.out.println("글 목록 화면 이동");
        SceneUtil.getInstance().switchScene(event, UI.LIST.getPath());
    }

    public void insert(ActionEvent event) throws IOException {

        String title = tfTitle.getText();
        String content = taContent.getText();

        if(title == null || title.trim().isEmpty()){
            showAlert("제목을 입력하세요");
            return;
        }

        if(content == null || title.trim().isEmpty()){
            showAlert("내용을 입력하세요");
            return;
        }

        Board board = new Board(tfTitle.getText(), taContent.getText());

        int result = boardService.insert(board);

        if(result > 0){
            System.out.println("글쓰기 성공");
            SceneUtil.getInstance().switchScene(event, UI.LIST.getPath());

        }else{
            showAlert("글 저장에 문제가 있습니다.");
        }

    }

    private void showAlert(String msg){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("입력 오류");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

}
