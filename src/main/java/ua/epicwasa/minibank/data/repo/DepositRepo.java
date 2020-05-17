package ua.epicwasa.minibank.data.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ua.epicwasa.minibank.data.entity.DepositContract;
import ua.epicwasa.minibank.data.entity.User;

@Component
public interface DepositRepo extends CrudRepository<DepositContract, Long> {
    public Iterable<DepositContract> getAllByAccountUser(User user);
}

