package ua.epicwasa.minibank.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ua.epicwasa.minibank.data.entity.User;

import java.util.List;

@Component
public interface UserRepo extends JpaRepository<User, Long> {
    public User findById(String id);
    public Iterable<User> findAllById(String id);


}

