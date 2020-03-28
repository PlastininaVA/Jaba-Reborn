package SpringStuff.Entities;

import javax.persistence.*;
import javax.sound.midi.Receiver;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "currency")
    private currency currency;
    @Column(name = "sum")
    private double sum;
    @Column(name = "date")
    private String date;
    @Column(name = "senderid")
    private long senderid;
    @Column(name = "receiverid")
    private long receiverid;
//----------------------------------------------------------------
    public Transaction(currency currency, double sum, String date, long senderid, long receiverid){
        this.currency=currency;
        this.sum=sum;
        this.date=date;
        this.senderid=senderid;
        this.receiverid=receiverid;
    }
//------------------------------------------------------------------------------
    public long getId() { return id; }
    public currency getCurrency() { return currency; }
    public double getSum() { return sum; }
    public String getDate() { return date; }
    public long getSenderid() { return senderid; }
    public long getReceiverid() { return receiverid; }
//----------------------------------------------------------------------------
    public void setCurrency(currency currency) { this.currency = currency; }
    public void setSum(double sum) { this.sum = sum; }
    public void setDate(String date) { this.date = date; }
//----------------------------------------------------------------------------------

}

//enum tag {
  //  RESTAURANT, SHOP, PHARMACY, TANKIONLINE, PIVO;
//} I removed tag cause it doesn't seem to be of a big use