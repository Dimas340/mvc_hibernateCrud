package web.service;

import web.model.Role;
import web.model.User;

import java.util.List;

@org.springframework.stereotype.Service
public interface Service {

    List<User> getAllUser();
    User findByUsername(String name);
    void addUser(User user);
    void deleteUser(User user);
    void editUser(User user);
    User getById(long id);
    void init();
}
