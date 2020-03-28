package UserStuff;

import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

public class User implements UserInterface{

    private String id;
    private String name;
    private String surname;
    private String patronymic;
    private String passport;
    private String phone;
    private String passwordHash;
    public List<String> accounts;

    public String Cipher(String password){
        return BCrypt.hashpw(password,BCrypt.gensalt());
    }

    public User(String id, String name, String surname, String patronymic, String passport, String phone, String passwordHash){
        this.id = id;
        this.name=name;
        this.surname=surname;
        this.patronymic=patronymic;
        this.passport=passport;
        this.phone=phone;
        this.passwordHash=passwordHash;
        accounts = new ArrayList<String>();
    }
    //--------------------------------------------------------
    public String getId(){return  id;}
    public String getName(){ return name; }
    public String getSurname(){return surname;}
    public String getPatronymic() { return patronymic; }
    public String getPassport(){
        return passport;
    }
    public String getPhone(){
        return phone;
    }
    public String getPasswordHash() { return passwordHash; }
    //--------------------------------------------------------
    public void setId(String id){this.id = id;}
    public void setName(String name){this.name=name;}
    public void setSurname(String surname){this.surname=surname;}
    public void setPatronymic(String patronymic){this.patronymic=patronymic;}
    public void setPassport(String passport){this.passport=passport;}
    public void setPhone(String phone){this.phone=phone;}
    public void setPassword(String password){this.passwordHash=BCrypt.hashpw(password,BCrypt.gensalt());}
    //---------------------------------------------------------
    public void addAccount(String id){
        accounts.add(id);
    }

}
