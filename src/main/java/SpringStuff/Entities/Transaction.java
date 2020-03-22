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
    private CURRENCY currency;
    @Column(name = "sum")
    private double sum;
    @Column(name = "date")
    private String date;
    @Column(name = "Sender_id")
    private long Sender_id;
    @Column(name = "Receiver_id")
    private long Receiver_id;
//----------------------------------------------------------------
    public Transaction(CURRENCY currency, double sum, String date, long Sender_id, long Receiver_id){
        this.currency=currency;
        this.sum=sum;
        this.date=date;
        this.Sender_id=Sender_id;
        this.Receiver_id=Receiver_id;
    }
//------------------------------------------------------------------------------
    public long getId() { return id; }
    public CURRENCY getCurrency() { return currency; }
    public double getSum() { return sum; }
    public String getDate() { return date; }
    public long getSender_id() { return Sender_id; }
    public long getReceiver_id() { return Receiver_id; }
//----------------------------------------------------------------------------
    public void setCurrency(CURRENCY currency) { this.currency = currency; }
    public void setSum(double sum) { this.sum = sum; }
    public void setDate(String date) { this.date = date; }
//----------------------------------------------------------------------------------

}

enum TAG {
    RESTAURANT, SHOP, PHARMACY, TANKIONLINE, PIVO;
}