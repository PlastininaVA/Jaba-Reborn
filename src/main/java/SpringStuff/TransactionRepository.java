package SpringStuff;

import SpringStuff.Entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Transaction getById(long id);
    List<Transaction> getBySender_id(Long Sender_id);
    List<Transaction> getByReceiver_id(Long Receiver_id);

}
