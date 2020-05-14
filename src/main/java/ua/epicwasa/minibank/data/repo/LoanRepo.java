package ua.epicwasa.minibank.data.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ua.epicwasa.minibank.data.entity.DepositContract;
import ua.epicwasa.minibank.data.entity.LoanContract;

@Component
public interface LoanRepo extends CrudRepository<LoanContract, Long> {
}

