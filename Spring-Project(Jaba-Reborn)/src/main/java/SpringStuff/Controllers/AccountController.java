package SpringStuff.Controllers;

import SpringStuff.Entities.Account;
import SpringStuff.Entities.Transaction;
import SpringStuff.Repos.AccountRepository;
import SpringStuff.Repos.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST контроллер для взаимодействия с репозиториями аккаунтов и транзакций
 */
@RestController
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    /**
     * Метод, добавляющий аккаунт в соответствующий репозиторий
     * @param account
     */
    @PostMapping(value="/api/account")
    public void putAccount(@RequestBody Account account){
        accountRepository.save(account);
    }

    /**
     * Метод для поиска транзакций, связанных с пользователем
     * @param id id пользователя
     * @return List транзакций, для которых соответствующий пользователь является либо sender, либо receiver
     */
    @GetMapping(value="/api/transaction", produces = "application/json; charset=UTF-8")
    public ResponseEntity<?> getTransactions(@RequestParam(value="id") Long id){
        Account user = accountRepository.getById(id);
        List<Transaction> sender = transactionRepository.getBySender(user);
        List<Transaction> receiver = transactionRepository.getByReceiver(user);
        sender.addAll(receiver);
        return new ResponseEntity<List<Transaction>>(sender, HttpStatus.OK);
    }

    /**
     * Метод возвращающий баланс  аккаунта с задаваемым id
     * @param id id аккаунта
     * @return баланс данного аккаунта
     */
    @GetMapping(value="/api/account/balance", produces = "application/json; charset=UTF-8")
    public ResponseEntity<?> balance(@RequestParam(value="id") Long id){
        return new ResponseEntity<Double>(accountRepository.getById(id).getBalance(),HttpStatus.OK);
    }

    /**
     * Метод, позволяющий добавить в базу данных транзакцию и перерассчитать баланс аккаунтов, связанных с ней
     * @param transaction новая транзакция
     * @return сообщение, сигнализирующее о том, возможна ли транзакция(если возможна, то она выполняется)
     */
    @PostMapping(value="/api/transaction", produces = "application/json; charset=UTF-8")
    public ResponseEntity<?> addTransaction(@RequestBody Transaction transaction){
        if (accountRepository.getById(transaction.getSender().getId()).getBalance() >= transaction.getSum()) {
            transactionRepository.save(transaction);
            Account sender = accountRepository.getById(transaction.getSender().getId());
            Account receiver = accountRepository.getById(transaction.getReceiver().getId());
            sender.setBalance(sender.getBalance() - transaction.getSum());
            receiver.setBalance(receiver.getBalance() + transaction.getSum());
            accountRepository.save(sender);
            accountRepository.save(receiver);
            return new ResponseEntity<String>("Transaction performed!", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>("Failed to perform the transaction, sender doesn't have enough money on his account",HttpStatus.OK);
        }
    }


}
