package kroryi.javafxboard.service;

import kroryi.javafxboard.dto.User;

public interface UserService {

    User select(String userId);
    int insert(User user);
    int update(User user);
    int delete(int uid);

}
