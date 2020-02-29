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
    List<Integer> accounts;

    public User(String name, String surname, String patronymic, String passport, String phone, String password){
        this.name=name;
        this.surname=surname;
        this.patronymic=patronymic;
        this.passport=passport;
        this.phone=phone;
        this.passwordHash=BCrypt.hashpw(password,BCrypt.gensalt());
        accounts = new ArrayList<Integer>();
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
    public String getPasswordHash() { return passwordHash; }


    public User FindById(int id){
        return null;
    };

    public User FindByPhone(String phone) {
        return null;
    };

    public User FindByPassport(String passport) {
        return null;
    };

    public User FindBySurname(String Surname) {
        return null;
    };

    public User LogIn(String phone, String password) {
        return null;
    };


}
