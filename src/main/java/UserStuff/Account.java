package UserStuff;

import java.util.ArrayList;
import java.util.List;

public class Account implements AccountInterface {
    private String number;
    private double balance;
    private CURRENCY currency;
    private List<Transaction> history;

    private class Transaction
    {
        private Integer id;
        private CURRENCY currency;
        private double sum;
        private Integer Sender_id;
        private Integer Receiver_id;
        private TAG tag;
    }


    private double CountBalance()
    {
        double returnvalue = 0;
        for (int i = 0; i < history.size(); i++) {
            returnvalue += history.get(i).sum;
        }
        return returnvalue;
        //Добавить проверку на валюту в транзакции, переводить ее по курсу валют из базы данных?
    }

    public Account(String number, double balance, CURRENCY currency)
    {
        this.number = number;
        this.balance = balance;
        this.currency = currency;
        this.history = new ArrayList<Transaction>();
        //Добавить проверку корректности инициализации, совпадение баланса и историии транзакций?
    }

    public void addTransaction(Transaction transaction){

    }

}
enum CURRENCY {
    RU, US, EU;
}
enum TAG {
    RESTAURANT, SHOP, PHARMACY, TANKIONLINE, PIVO;
}