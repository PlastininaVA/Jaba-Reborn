package UserStuff;

import javax.xml.crypto.Data;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

public class DataBase {

    private Map<Long, User> userMap;
    private AtomicLong currId = new AtomicLong(0);

    public DataBase() {
        userMap = new HashMap<>();
    }

    public User getUserById(long id){
        return userMap.get(id);
    }

    public User getUserByPhone(String phone) {
        Iterator itr = userMap.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry entry = (Map.Entry) itr.next();
            User currentUser = (User) entry.getValue();
            if (currentUser.getPhone().equals(phone)) {
                return currentUser;
            }
        }
        System.out.println("no matches found");
        return null;
    }

    public User getUserByPassport(String passport){
        Iterator itr = userMap.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry entry = (Map.Entry) itr.next();
            User currentUser = (User) entry.getValue();
            if (currentUser.getPassport().equals(passport)) {
                return currentUser;
            }
        }
        System.out.println("no matches found");
        return null;
    }

    public User getUserBySurname(String surname){
        Iterator itr = userMap.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry entry = (Map.Entry) itr.next();
            User currentUser = (User) entry.getValue();
            if (currentUser.getSurname().equals(surname)) {
                return currentUser;
            }
        }
        System.out.println("no matches found");
        return null;
    }

    public void putUser(User user){
        userMap.put(currId.get(),user);
        currId.getAndIncrement();
    }
}
