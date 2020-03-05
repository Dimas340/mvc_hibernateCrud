package web.dao;

import web.model.User;

import java.util.List;

public interface Dao {

    List<User> getAllUser();
    void addUser(User user);
    void deleteUser(User user);
    void editUser(User user);
    User getById(long id);
}
