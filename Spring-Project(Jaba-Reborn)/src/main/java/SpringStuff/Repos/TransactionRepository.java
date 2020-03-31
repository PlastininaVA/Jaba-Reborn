package SpringStuff.Repos;

import SpringStuff.Entities.Account;
import SpringStuff.Entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Репозиторий транзакций
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    /**
     * @return транзакция с соответствующим id(задается как параметр) из базы данных
     * */
    Transaction getById(long id);
    /**
     * @return List транзакций с соответствующим sender(задается как параметр) из базы данных
     * */
    List<Transaction> getBySender(Account sender);
    /**
     * @return List транзакций с соответствующим receiver(задается как параметр) из базы данных
     * */
    List<Transaction> getByReceiver(Account receiver);

}
