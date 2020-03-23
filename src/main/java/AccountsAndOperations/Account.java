package AccountsAndOperations;

import java.util.ArrayList;
import java.util.List;

public class Account implements AccountInterface {
    private Integer id;
    private Integer number;
    private Integer balance;
    private Currency currency;
    private List<Transaction> history;

    //Добавить инициализацию пользователя? Инициализацию счета?

    private void CountBalance() {
        for (int i = 0; i < history.size(); i++) {
            if (history.get(i).GetCurrency() == this.currency)
                this.balance += history.get(i).GetSum();
        }
        //Добавить базу данных с курсами валют и перевод из одной валюты в другую?
    }

    public Account(Integer id, Integer number, Integer balance, Currency currency) {
        this.id = id;
        this.number = number;
        this.balance = balance;
        this.currency = currency;
        this.history = new ArrayList<Transaction>();
    }

}