package UserStuff;

import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

public class User implements UserInterface{

    private String name;
    private String surname;
    private String patronymic;
    private String passport;
    private String phone;
    private String passwordHash;
    public List<Long> accounts;

    public User(String name, String surname, String patronymic, String passport, String phone, String password){
        this.name=name;
        this.surname=surname;
        this.patronymic=patronymic;
        this.passport=passport;
        this.phone=phone;
        this.passwordHash=BCrypt.hashpw(password,BCrypt.gensalt());
        accounts = new ArrayList<Long>();
    }
    public String getName(){ return name; }
    public String getPhone(){
        return phone;
    }
    public String getPassport(){
        return passport;
    }
    public String getSurname(){
        return surname;
    }
    public String getPatronymic() { return patronymic; }

    public String getPasswordHash() { return passwordHash; }
    //---------------------------------------------------------
    public void addAccount(long id){
        accounts.add(id);
    }

}
