package SpringStuff.Repos;

import SpringStuff.Entities.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ExchangeRateRepository  extends JpaRepository<ExchangeRate, Long> {
    List<ExchangeRate> getByDate(Date date);
    ExchangeRate getById(long id);
}
