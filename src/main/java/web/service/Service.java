package web.service;

import web.model.User;

import java.util.List;

public interface Service {

    List<User> getAllUser();
    void addUser(User user);
    void deleteUser(User user);
    void editUser(User user);
    User getById(long id);
    void init();
}