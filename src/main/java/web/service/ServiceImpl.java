package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.Dao;
import web.model.Role;
import web.model.User;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class ServiceImpl implements web.service.Service {

    private final Role role_1 = new Role("ROLE_ADMIN");
    private final Role role_2 = new Role("ROLE_USER");
    private final User user = new User("1", "1");
    private final User user2 = new User("2", "2");
    private final User user3 = new User("3", "3");

    @Autowired
    private Dao dao;

    @Override
    public List<User> getAllUser() {
        return dao.getAllUser();
    }

    @Override
    public User findByUsername(String name) {
        return dao.findByUsername(name);
    }

    @Transactional
    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(User user) {
        dao.deleteUser(user);
    }

    @Transactional
    @Override
    public void editUser(User user) {
            dao.editUser(user);
    }

    @Transactional
    @Override
    public User getById(long id) {
        return dao.getById(id);
    }

    @Transactional
    public void init() {
        dao.addRoles(role_1);
        dao.addRoles(role_2);
        Set<Role> set = new HashSet<>();
        set.add(role_1);
        set.add(role_2);
        user.setRoles(set);
        user2.setRoles(Collections.singleton(role_2));
        user3.setRoles(Collections.singleton(role_2));
        addUser(user);
        addUser(user2);
        addUser(user3);
    }
}
