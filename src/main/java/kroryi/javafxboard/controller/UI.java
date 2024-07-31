package kroryi.javafxboard.controller;

public enum UI {

    LIST("/kroryi/javafxboard/boardlist-view.fxml"),
    INSERT("/kroryi/javafxboard/INSERT.fxml"),
    READ("/kroryi/javafxboard/READ.fxml"),
    UPDATE("/kroryi/javafxboard/UPDATE.fxml"),
    REGISTER("/kroryi/javafxboard/REGISTER.fxml"),
    LOGIN("/kroryi/javafxboard/LOGIN.fxml"),
    MYPAGE("/kroryi/javafxboard/MYPAGE.fxml"),
    ChangePage("/kroryi/javafxboard/ChangePage.fxml");

    private final String path;

    UI(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
