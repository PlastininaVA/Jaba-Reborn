package AccountsAndOperations;

public class Transaction {
    private Integer id;
    private Currency currency;
    private Integer sum;
    private Integer Sender_id;
    private Integer Receiver_id;
    private Tag tag;

    public Integer GetID()
    {
        return this.id;
    }

    public Currency GetCurrency()
    {
        return this.currency;
    }

    public Integer GetSum()
    {
        return this.sum;
    }

    public Integer GetSenderID()
    {
        return this.Sender_id;
    }

    public Integer GetReceiverID()
    {
        return this.Receiver_id;
    }

    public Tag GetTag()
    {
        return this.tag;
    }
}

enum Currency {
    RU, US, EU;
}
enum Tag {
    RESTAURANT, SHOP, PHARMACY;
}