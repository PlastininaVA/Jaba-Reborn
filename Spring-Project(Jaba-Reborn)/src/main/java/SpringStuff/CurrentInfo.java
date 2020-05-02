package SpringStuff;

import SpringStuff.Repos.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
Класс хранит данные о том, какой пользователь залогинен и какой аккаунт сейчас используется
 */
public class CurrentInfo {
    @Autowired
    static ExchangeRateRepository exchangeRateRepository;

    private static Long currentUser;
    public static void setCurrentUser(Long user){ currentUser = user; }
    public static Long getCurrentUser() { return currentUser; }

    private static Long currentAccount;
    public static void setCurrentAccount(Long account) { currentAccount = account; }
    public static Long getCurrentAccount() { return currentAccount; }

    public static Long currentExchangeRate;
    public static void setCurrentExchangeRate(Long exchangeRate){ currentExchangeRate = exchangeRate; }
    public static Long getCurrentExchangeRate() { return currentExchangeRate; }
}
