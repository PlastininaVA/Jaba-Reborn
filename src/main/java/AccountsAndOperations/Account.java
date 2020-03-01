package AccountsAndOperations;

import java.util.ArrayList;
import java.util.List;

public class Account implements AccountInterface {
    private Integer id;
    private Integer number;
    private Integer balance;
    private CURRENCY currency;

    private class Transaction
    {
        private Integer id;
        private CURRENCY currency;
        private Integer sum;
        private Integer Sender_id;
        private Integer Receiver_id;
        private TAG tag;
    }
    private List<Transaction> history;

    private void CountBalance()
    {
        for (int i = 0; i < history.size(); i++) {
            if (history.get(i).currency == this.currency)
                this.balance += history.get(i).sum;
        }
        //Добавить проверку на валюту в транзакции, переводить ее по курсу валют из базы данных?
    }

    public Account(Integer id, Integer number, Integer balance, CURRENCY currency)
    {
        this.id = id;
        this.number = number;
        this.balance = balance;
        this.currency = currency;
        this.history = new ArrayList<Transaction>();
        //Добавить проверку корректности инициализации, совпадение баланса и историии транзакций?
    }

}
enum CURRENCY {
    RU, US, EU;
}
enum TAG {
    RESTAURANT, SHOP, PHARMACY;
}
