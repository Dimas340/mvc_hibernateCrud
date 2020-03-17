package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import web.dao.Dao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ServiceImpl implements web.service.Service {

    private final User user = new User("Masha", "Kovrova");
    private final User user2 = new User("Andrey", "Habarov");
    private final User user3 = new User("John", "Nazarov");

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
        addUser(user);
        addUser(user2);
        addUser(user3);
    }
}
