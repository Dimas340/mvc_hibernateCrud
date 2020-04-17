package web.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class  DaoImpl implements Dao {

//    @Autowired
//    private SessionFactory sessionFactory;

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

//    @Override
//    public List<User> getAllUser() {
//        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");// Получает текущий сеанс.
//        //отправляет запрос
//        return query.getResultList();//Выполните запрос SELECT и верните результаты запроса в виде типизированного списка.
        //Интерфейс, используемый для управления выполнением типизированных запросов.
//    }

    @Override
    public List<Role> getAllRole() {
        List<Role> list = entityManager.createQuery("from Role").getResultList();
        return list;
    }

    @Override
    public List<User> getAllUser() {// work
       List<User> list = entityManager.createQuery("from User").getResultList();
       return list;
    }

    @Override
    public User findByUsername(String name) {
        TypedQuery <User> query =  entityManager.createQuery("FROM User u WHERE u.name = :name", User.class);
        query.setParameter("name", name);
        User user = query.getSingleResult();
        return user;
    }


//    @Override
//    public void addUser(User user) {
//        sessionFactory.getCurrentSession().save(user);
//    }

    @Override
    public void addUser(User user) {// work
         entityManager.persist(user);
    }

    @Override
    public void addRoles(Role role) {// work
         entityManager.persist(role);
    }

//    @Override
//    public void deleteUser(User user) {
//        sessionFactory.getCurrentSession().delete(user);
//    }

    @Override
    public void deleteUser(User user) {// work
        entityManager.remove(user);
    }

//    @Override
//    public void editUser(User user) {
//        sessionFactory.getCurrentSession().update(user);
//    }

    @Override
    public void editUser(User user) {
//        entityManager.clear();
        entityManager.merge(user);
    }

//    @Override
////    public User getById(long id) {
////        User user =  sessionFactory.getCurrentSession().get(User.class, id);
////        return user;
////    }

    @Override
    public User getById(long id) {//work
         User user =  entityManager.find(User.class, id);
        return user;
    }
}
