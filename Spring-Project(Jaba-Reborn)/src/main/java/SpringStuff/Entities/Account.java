package SpringStuff.Entities;

import javax.persistence.*;
import java.util.ArrayList;

import SpringStuff.CurrentInfo;
import SpringStuff.Repos.AccountRepository;
import SpringStuff.Repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Сущность - аккаунт с полями user(сущность типа User - владелец аккаунта), id, balance и currency(enum RU/US/EU)
 */
@Entity
@Table(name = "account")
public class Account {

    @Transient
    @Autowired
    UserRepository userRepository;

    @ManyToOne
    @JoinColumn(name="userid", nullable = false)
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "balance")
    private double balance;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency")
    private currency currency;

    //--------------------------------------------------------------------------
    public Account(User user, double balance, currency currency){
        this.user=user;
        this.balance=balance;
        this.currency=currency;
    }
    public Account(currency currency){
        this.user=userRepository.getById(CurrentInfo.getCurrentUser());
        this.balance=0;
        this.currency=currency;
    }

    public Account() {
    }
    //------------------------------------------------------------
    /**
     * Геттер для поля user
     */
    public User getUser(){return user;}
    /**
     * Геттер для поля id
     */
    public long getId(){return id;}
    /**
     * Геттер для поля balance
     */
    public double getBalance(){return balance;}
    /**
     * Геттер для поля currency
     */
    public currency getCurrency(){return currency;}
    //---------------------------------------------------------
    /**
     * Сеттер для поля balance
     */
    public void setBalance(double balance){this.balance=balance;}
    /**
     * Сеттер для поля currency
     */
    public void setCurrency(currency currency){this.currency=currency;}
    //----------------------------------------------------------------------
    @Deprecated
    private double CountBalance(){
      return 0;
        //good night sweet prince (этот метод больше не нужен, но он мне очень нравится, так что пусть будет)
    }

    //---------------------------------------------------------------------------
}

/**
 * Собственно, enum валют(RU/US/EU)
 */
enum currency {
    RU, US, EU;
}
