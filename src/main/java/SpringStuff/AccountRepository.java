package SpringStuff;

import SpringStuff.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account getById(Long id);
    List<Account> getByUserid(Long userid);
}
