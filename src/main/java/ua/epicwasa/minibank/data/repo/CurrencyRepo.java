package ua.epicwasa.minibank.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ua.epicwasa.minibank.data.entity.Account;
import ua.epicwasa.minibank.data.entity.Currency;

@Component
public interface CurrencyRepo extends JpaRepository<Currency, Long> {
}

