package SpringStuff;

import SpringStuff.Entities.Account;
import SpringStuff.Entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;


    @PostMapping(value="/putAccount")
    public void putAccount(@RequestBody Account account){
        accountRepository.save(account);
    }


    @GetMapping(value="/getTransactions", produces = "application/json; charset=UTF-8")
    public ResponseEntity<?> getTransactions(@RequestParam(value="id") Long id){
        List<Transaction> sender = transactionRepository.getBySenderid(id);
        List<Transaction> receiver = transactionRepository.getByReceiverid(id);
        sender.addAll(receiver);
        return new ResponseEntity<List<Transaction>>(sender, HttpStatus.OK);
    }

    @GetMapping(value="/balance", produces = "application/json; charset=UTF-8")
    public ResponseEntity<?> balance(@RequestParam(value="id") Long id){
        return new ResponseEntity<Double>(accountRepository.getById(id).getBalance(),HttpStatus.OK);
    }

    @PostMapping(value="/addTransaction", produces = "application/json; charset=UTF-8")
    public ResponseEntity<?> addTransaction(@RequestBody Transaction transaction){
        transactionRepository.save(transaction);
        Account sender = accountRepository.getById(transaction.getSenderid());
        Account receiver = accountRepository.getById(transaction.getReceiverid());
        accountRepository.delete(sender);
        accountRepository.delete(receiver);
        sender.setBalance(sender.getBalance()-transaction.getSum());
        receiver.setBalance(receiver.getBalance()+transaction.getSum());
        accountRepository.save(sender);
        accountRepository.save(receiver);
        Double senderbalance =  sender.getBalance();
        Double receiverbalance = receiver.getBalance();
        return  new ResponseEntity<String>("New sender balance is "+senderbalance.toString()+
                ". New receiver balance is "+receiverbalance.toString(),HttpStatus.OK);
    }


}
