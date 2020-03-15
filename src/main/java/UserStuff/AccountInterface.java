package UserStuff;

public interface AccountInterface {
    public String getId();
    public String getNumber();
    public double getBalance();
    public CURRENCY getCurrency();
    public void setId(String id);
    public void setNumber(String number);
    public void setBalance(double balance);
    public void setCurrency(CURRENCY currency);
}
