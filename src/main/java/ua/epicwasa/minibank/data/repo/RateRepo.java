package ua.epicwasa.minibank.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ua.epicwasa.minibank.data.entity.Rate;

@Component
public interface RateRepo extends JpaRepository<Rate, Long> {
}
