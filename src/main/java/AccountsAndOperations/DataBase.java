package AccountsAndOperations;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class DataBase {
    private Map<Long, Account> accountMap;
    private AtomicLong currentId = new AtomicLong(0);

    public DataBase() {
        accountMap = new HashMap<Long, Account>();
        currentId.getAndIncrement();
    }

    public Account getAccountById(long id){
        return accountMap.get(id);
    }

    public void putAccount (Account account){
        accountMap.put(currentId.get(), account);
        currentId.getAndIncrement();
    }
}