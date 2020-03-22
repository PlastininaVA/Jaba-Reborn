package SpringStuff;

import SpringStuff.Entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Transaction getById(long id);
    List<Transaction> getBySenderid(Long senderid);
    List<Transaction> getByReceiverid(Long receiverid);

}
