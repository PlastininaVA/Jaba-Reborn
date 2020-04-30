package SpringStuff.Entities;

import javax.persistence.*;

/**
 * Сущность - транзакция с полями id, currency, sum, date, sender(аккаунт - отправитель), receiver(аккаунт - получатель)
 */
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "currency")
    private currencyEnum currency;

    @Column(name = "sum")
    private double sum;

    @Column(name = "date")
    private String date;

    @ManyToOne
    @JoinColumn(name = "senderid")
    private Account sender;

    @ManyToOne
    @JoinColumn(name = "receiverid")
    private Account receiver;
//----------------------------------------------------------------
    /**
     * Конструктор с параметрами currency, sum, date, sender, receiver (id генерируется само)
     * */
    public Transaction(currencyEnum currency, double sum, String date, Account sender, Account receiver){
        this.currency = currency;
        this.sum=sum;
        this.date=date;
        this.sender=sender;
        this.receiver=receiver;
    }
    public Transaction(){ }
//------------------------------------------------------------------------------
    /**
     * Геттер для поля id
     */
    public long getId() { return id; }
    /**
     * Геттер для поля currency
     */
    public currencyEnum getCurrency() { return currency; }
    /**
     * Геттер для поля sum
     */
    public double getSum() { return sum; }
    /**
     * Геттер для поля date
     */
    public String getDate() { return date; }
    /**
     * Геттер для поля sender
     */
    public Account getSender() { return sender; }
    /**
     * Геттер для поля receiver
     */
    public Account getReceiver() { return receiver; }
//----------------------------------------------------------------------------
    /**
     * Сеттер для поля currency
     */
    public void setCurrency(currencyEnum currency) { this.currency = currency; }
    /**
     * Сеттер для поля sum
     */
    public void setSum(double sum) { this.sum = sum; }
    /**
     * Сеттер для поля date
     */
    public void setDate(String date) { this.date = date; }
//----------------------------------------------------------------------------------

}

//enum tag {
  //  RESTAURANT, SHOP, PHARMACY, TANKIONLINE, PIVO;
//} I removed tag cause it doesn't seem to be of a big use