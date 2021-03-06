package ua.epicwasa.minibank.data.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ua.epicwasa.minibank.data.entity.Account;
import ua.epicwasa.minibank.data.entity.Card;
import ua.epicwasa.minibank.data.entity.User;

@Component
public interface CardRepo extends CrudRepository<Card, Long> {
public Iterable<Card> getAllByAccount(Account account);
public Iterable<Card> getCardsById(Long id);
public Iterable<Card> getAllByAccountUser(User user);
}

