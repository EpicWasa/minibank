package ua.epicwasa.minibank.data.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ua.epicwasa.minibank.data.entity.DepositContract;

@Component
public interface DepositRepo extends CrudRepository<DepositContract, Long> {
}

