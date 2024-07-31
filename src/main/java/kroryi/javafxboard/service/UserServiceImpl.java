package kroryi.javafxboard.service;

import kroryi.javafxboard.dao.UserDAO;
import kroryi.javafxboard.dto.User;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAO();

    @Override
    public User select(String userId) {
        return userDAO.select(userId);
    }

    @Override
    public int insert(User user) {
        return userDAO.insert(user);
    }

    @Override
    public int update(User user) {
        int result = userDAO.update(user);
        return result;
    }

    @Override
    public int delete(int uid) {
        int result = userDAO.delete(uid);
        return result;
    }
}
