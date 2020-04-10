package SpringStuff;
import SpringStuff.Entities.User;

public class CurrentInfo {
    private static Long CurrentUser;
    public static void setCurrentUser(Long user){
        CurrentUser = user;
    }
    public static Long getCurrentUser() {
        return CurrentUser;
    }
    private static Long CurrentAccount;
    public static void setCurrentAccount(Long account) {CurrentAccount = account;}
    public static Long getCurrentAccount(){return CurrentAccount;}
}
