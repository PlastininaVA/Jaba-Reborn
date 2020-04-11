package SpringStuff.Entities;

import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Сущность - пользователь с полями id, name, surname, patronymic, passport, phone
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "passport")
    private String passport;

    @Column(name = "phone")
    private String phone;

    @Column(name = "passwordHash")
    private String passwordHash;

 //   public static String Cipher(String password){
   //   return BCrypt.hashpw(password,BCrypt.gensalt());
//}
    /**
     * Конструктор с параметрами name, surname, patronymic, passport, phone, passwordHash (id генерируется само)
     * */
   public User( String name, String surname, String patronymic, String passport, String phone, String passwordHash){
       this.name=name;
        this.surname=surname;
        this.patronymic=patronymic;
        this.passport=passport;
        this.phone=phone;
        this.passwordHash=passwordHash;
    }

    public User(){};
    //--------------------------------------------------------
    /**
     * Геттер для поля id
     */
    public long getId(){return  id;}
    /**
     * Геттер для поля name
     */
    public String getName(){ return name; }
    /**
     * Геттер для поля surname
     */
    public String getSurname(){return surname;}
    /**
     * Геттер для поля patronymic
     */
    public String getPatronymic() { return patronymic; }
    /**
     * Геттер для поля passport
     */
    public String getPassport(){
        return passport;
    }
    /**
     * Геттер для поля phone
     */
    public String getPhone(){
        return phone;
    }
    /**
     * Геттер для поля passwordhash
     */
    public String getPasswordHash() { return passwordHash; }
    //--------------------------------------------------------
    /**
     * Сеттер для поля name
     */
    public void setName(String name){this.name=name;}
    /**
     * Сеттер для поля surname
     */
    public void setSurname(String surname){this.surname=surname;}
    /**
     * Сеттер для поля patronymic
     */
    public void setPatronymic(String patronymic){this.patronymic=patronymic;}
    /**
     * Сеттер для поля passport
     */
    public void setPassport(String passport){this.passport=passport;}
    /**
     * Сеттер для поля phone
     */
    public void setPhone(String phone){this.phone=phone;}
    /**
     * Сеттер для поля passwordhash
     */
    public void setPassword(String password){this.passwordHash=BCrypt.hashpw(password,BCrypt.gensalt());}
    //---------------------------------------------------------

}
