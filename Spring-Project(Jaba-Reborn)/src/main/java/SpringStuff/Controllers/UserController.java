package SpringStuff.Controllers;

import SpringStuff.Repos.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import SpringStuff.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST контроллер для взаимодействия с репозиторием пользователей
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(value="/test", produces =  "application/json; charset=UTF-8")
    public ResponseEntity<?> testing(){
        return new ResponseEntity<String>("Test successfull",HttpStatus.OK);
    }


    /**
     * Метод, позволяющий добавить нового пользователя в репозиторий
     * @param user Задаваемый пользователь. При добавлении в репозиторий пароль меняется на зашифрованный
     */
    @PostMapping(value="/api/user")
    public void putUser(@RequestBody User user){
        user.setPassword(BCrypt.hashpw(user.getPasswordHash(),BCrypt.gensalt()));
        userRepository.save(user);
        //Вот здесь немного костыльно, ибо по факту в @RequestBody должен закидываться юзер с уже имеющимся полем passwordHash,
        //(которое на самом деле является еще не зашифрованным паролем) но, наверное это не так критично
        //С другой стороны, передавать пароли по http вроде так себе практика?
    }

    /**
     * Метод для поиска пользователя в репозитории
     * @param id id, по которому осуществляется поиск
     * @return пользователь с соответствующим id
     */
    @GetMapping(value="/api/user",produces = "application/json; charset=UTF-8")
    public ResponseEntity<?> findId(@RequestParam(value="id") Long id){
        return new ResponseEntity<User>(userRepository.getById(id), HttpStatus.OK);
    }

    /**
     * Метод для поиска пользователя в репозитории
     * @param phone phone, по которому осуществляется поиск
     * @return пользователь с соответствующим phone
     */
    @GetMapping(value="/api/user/phone",produces = "application/json; charset=UTF-8")
    public ResponseEntity<?> findPhone(@RequestParam(value="phone") String phone){
        return new ResponseEntity<User>(userRepository.getByPhone(phone),HttpStatus.OK);
    }

    /**
     * Метод для поиска пользователя в репозитории
     * @param passport passport, по которому осуществляется поиск
     * @return пользователь с соответствующим passport
     */
    @GetMapping(value="/api/user/passport", produces = "application/json; charset=UTF-8")
    public ResponseEntity<?> findPassport(@RequestParam(value = "passport") String passport){
        return new ResponseEntity<User>(userRepository.getByPassport(passport), HttpStatus.OK);
    }

    /**
     * Метод для поиска пользователя в репозитории
     * @param surname surname, по которому осуществляется поиск
     * @return List пользователей с соответствующим surnmame
     */
    @GetMapping(value="/api/user/surname",produces = "application/json; charset=UTF-8")
    public ResponseEntity<?> findSurname(@RequestParam(value="surname") String surname){
        return new ResponseEntity<List<User>>(userRepository.getBySurname(surname),HttpStatus.OK);
    }

    /**
     * Метод, проверяющий, есть ли в репозитории пользователь с заданной комбинацией phone-password
     * @param phone заданный phone
     * @param password заданный password
     * @return сообщение о том, есть ли такой пользователь
     */
    @PutMapping(value="api/user/login",produces = "application/json; charset=UTF-8")
    public ResponseEntity<?> login(@RequestParam(value="phone") String phone, @RequestParam(value="password") String password){
        User user = userRepository.getByPhone(phone);

        if (BCrypt.checkpw(password,user.getPasswordHash())){
            return new ResponseEntity<String>("You logged in, "+user.getName(), HttpStatus.OK);
        }
        else return new ResponseEntity<String>("oops, something went wrong",HttpStatus.OK);
    }


}
