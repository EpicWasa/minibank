package ua.epicwasa.minibank.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ua.epicwasa.minibank.data.entity.Account;
import ua.epicwasa.minibank.data.entity.User;

@Component
public interface AccountRepo extends JpaRepository<Account, Long> {
    public Iterable<Account> getAllByUser(User user);
}

