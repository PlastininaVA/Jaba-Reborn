package SpringStuff.Repos;

import SpringStuff.Entities.Account;
import SpringStuff.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Репозиторий аккаунтов
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    /**
     * @return аккаунт с соответствующим id(задаётся как параметр) из базы данных
     */
    Account getById(Long id);
    /**
     * @return List всех аккаунтов, принадлежащих данному user(задается как параметр)
     */
    List<Account> getByUser(User user);
}
