package UserStuff;

    import java.util.HashMap;
    import java.util.Map;
    import java.util.concurrent.atomic.AtomicLong;

    public class AccountDataBase {
        private Map<Long, Account> accountMap;
        private AtomicLong currentId = new AtomicLong(0);

        public AccountDataBase() {
            accountMap = new HashMap<Long, Account>();

        }

        public Account getAccountById(long id){
            return accountMap.get(id);
        }

        public void putAccount (Account account){
            accountMap.put(currentId.get(), account);
            currentId.getAndIncrement();
        }
        public Long getCurrentId() {
            return currentId.longValue();
        }
    }

