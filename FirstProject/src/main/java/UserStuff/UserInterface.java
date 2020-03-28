package UserStuff;

import org.mindrot.jbcrypt.BCrypt;

public interface UserInterface {

    public String Cipher(String password);
    public String getId();
    public String getName();
    public String getSurname();
    public String getPatronymic();
    public String getPassport();
    public String getPhone();
    public String getPasswordHash();
    public void setId(String id);
    public void setName(String name);
    public void setSurname(String surname);
    public void setPatronymic(String patronymic);
    public void setPassport(String passport);
    public void setPhone(String phone);
    public void setPassword(String password);
    public void addAccount(String id);
}
