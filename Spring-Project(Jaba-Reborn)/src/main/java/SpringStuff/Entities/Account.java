package SpringStuff.Entities;

import javax.persistence.*;

import SpringStuff.CurrentInfo;
import SpringStuff.DTO.AccountDTO;
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
    private currencyEnum currency;

    //--------------------------------------------------------------------------
    public Account(User user, double balance, currencyEnum currency){
        this.user=user;
        this.balance=balance;
        this.currency = currency;
    }
    public Account(currencyEnum currency){
        this.user=userRepository.getById(CurrentInfo.getCurrentUser());
        this.balance=0;
        this.currency = currency;
    }
    public Account(AccountDTO dto){
       //удалю как нибудь потом
        //this.user=userRepository.getById(CurrentInfo.getCurrentUser());
        this.user = new User();
        this.balance=0;
        if (dto.getCurrency().equals("RU")) {
            this.currency = currencyEnum.RU;
        }
        else if (dto.getCurrency().equals("US")) {
            this.currency = currencyEnum.US;
        }
        else this.currency=currencyEnum.EU;
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
    public currencyEnum getCurrency(){return currency;}
    //---------------------------------------------------------
    /**
     * Сеттер для поля balance
     */
    public void setBalance(double balance){this.balance=balance;}
    /**
     * Сеттер для поля currency
     */
    public void setCurrency(currencyEnum currency){this.currency = currency;}

    /**
     * Сеттер для поля user
     */
    public void setUser(User user){this.user = user;}
    //----------------------------------------------------------------------
    @Deprecated
    private double CountBalance(){
      return 0;
        //good night sweet prince (этот метод больше не нужен, но он мне очень нравится, так что пусть будет)
    }

    //---------------------------------------------------------------------------
}
