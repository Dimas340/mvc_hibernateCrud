package web.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.User;

//@Component
@Repository
@EnableJpaRepositories("web")
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}