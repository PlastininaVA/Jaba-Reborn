package SpringStuff;
/**
Класс хранит данные о том, какой пользователь залогинен и какой аккаунт сейчас используется
 */
public class CurrentInfo {

    private static Long currentUser;
    public static void setCurrentUser(Long user){ currentUser = user; }
    public static Long getCurrentUser() { return currentUser; }
    private static Long currentAccount;
    public static void setCurrentAccount(Long account) { currentAccount = account; }
    public static Long getCurrentAccount() { return currentAccount; }
}
