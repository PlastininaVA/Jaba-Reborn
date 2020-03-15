package UserStuff;

import java.util.ArrayList;
import java.util.List;

public class Account implements AccountInterface {
    private String id;
    private String number;
    private double balance;
    private CURRENCY currency;
    private List<Transaction> history;

    class Transaction
    {
        private String id;
        private CURRENCY currency;
        private double sum;
        private String date;
        private String Sender_id;
        private String Receiver_id;
        private TAG tag;
        public Transaction(String id, CURRENCY currency, double sum, String date,String Sender_id, String Receiver_id, TAG tag){
            this.id=id;
            this.currency=currency;
            this.sum=sum;
            this.date=date;
            this.Sender_id=Sender_id;
            this.Receiver_id=Receiver_id;
            this.tag=tag;
        }
    }
//-------------------------------------------------------
    public String getId(){return id;}
    public String getNumber(){return number;}
    public double getBalance(){return CountBalance();}
    public CURRENCY getCurrency(){return currency;}
//---------------------------------------------------------
    public void setId(String id){this.id=id;}
    public void setNumber(String number){this.number=number;}
    public void setBalance(double balance){this.balance=balance;}
    public void setCurrency(CURRENCY currency){this.currency=currency;}
//----------------------------------------------------------
    private double CountBalance()
    {
        double returnvalue = 0;
        for (int i = 0; i < history.size(); i++) {
            if (history.get(i).Receiver_id == this.number) {
                returnvalue += history.get(i).sum;
            } else {
                returnvalue -= history.get(i).sum;
            }
        }
        return returnvalue;
        //Добавить проверку на валюту в транзакции, переводить ее по курсу валют из базы данных?
        //Ответ: ну вот сама и добавляй
    }
//---------------------------------------------------------------------------
    public Account(String id, String number,double balance, CURRENCY currency)
    {
        this.id = id;
        this.number = number;
        this.balance = balance;
        this.currency = currency;
        this.history = new ArrayList<Transaction>();
        //Добавить проверку корректности инициализации, совпадение баланса и историии транзакций?
        //Ответ: ну вот сама и добавляй
    }

    public void addTransaction(String id, CURRENCY currency, double sum, String date, String Sender_id, String Receiver_id, TAG tag){
        this.history.add(new Transaction(id,currency,sum,date,Sender_id, Receiver_id,tag));
    }

}
enum CURRENCY {
    RU, US, EU;
}
enum TAG {
    RESTAURANT, SHOP, PHARMACY, TANKIONLINE, PIVO;
}