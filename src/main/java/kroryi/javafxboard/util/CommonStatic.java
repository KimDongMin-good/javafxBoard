package kroryi.javafxboard.util;

public class CommonStatic {
    private static int uid;
    private static String userId;
    private static String password;
    private static String userName;

    public static int getUid() {
        return uid;
    }

    public static void setUid(int uid) {
        CommonStatic.uid = uid;
    }

    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId) {
        CommonStatic.userId = userId;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        CommonStatic.password = password;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        CommonStatic.userName = userName;
    }
}
