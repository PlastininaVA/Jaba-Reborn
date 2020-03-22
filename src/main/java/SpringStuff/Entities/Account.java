package SpringStuff.Entities;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "account")
public class Account {

    @Column(name="userid")
    private long userid;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "balance")
    private double balance;
    @Column(name = "currency")
    private String currency;

    //--------------------------------------------------------------------------
    public Account(long user_id, double balance, String currency){
       this.userid=user_id;
        this.balance=balance;
        this.currency=currency;
    }
    //------------------------------------------------------------
    public long getUser_id(){return userid;}
    public long getId(){return id;}
    public double getBalance(){return balance;}
    public String getCurrency(){return currency;}
    //---------------------------------------------------------
    public void setBalance(double balance){this.balance=balance;}
    public void setCurrency(String currency){this.currency=currency;}
    //----------------------------------------------------------------------
    private double CountBalance(){
      return 0;
        //good night sweet prince (этот метод больше не нужен, но он мне очень нравится, так что пусть будет)
    }

    //---------------------------------------------------------------------------
}

enum CURRENCY {
    RU, US, EU;
}
