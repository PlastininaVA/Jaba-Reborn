package SpringStuff.Entities;

import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private long id;
    @Column (name = "name")
    private String name;
    @Column (name = "surname")
    private String surname;
    @Column (name = "patronymic")
    private String patronymic;
    @Column (name = "passport")
    private String passport;
    @Column (name = "phone")
    private String phone;
    @Column (name = "passwordHash")
    private String passwordHash;

    public static String Cipher(String password){
        return BCrypt.hashpw(password,BCrypt.gensalt());
    }

   public User( String name, String surname, String patronymic, String passport, String phone, String passwordHash){
       this.name=name;
        this.surname=surname;
        this.patronymic=patronymic;
        this.passport=passport;
        this.phone=phone;
        this.passwordHash=passwordHash;
    }
    //--------------------------------------------------------
    public long getId(){return  id;}
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

    public void setName(String name){this.name=name;}
    public void setSurname(String surname){this.surname=surname;}
    public void setPatronymic(String patronymic){this.patronymic=patronymic;}
    public void setPassport(String passport){this.passport=passport;}
    public void setPhone(String phone){this.phone=phone;}
    public void setPassword(String password){this.passwordHash=BCrypt.hashpw(password,BCrypt.gensalt());}
    //---------------------------------------------------------



}
