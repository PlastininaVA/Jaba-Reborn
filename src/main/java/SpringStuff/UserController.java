package SpringStuff;

import org.mindrot.jbcrypt.BCrypt;
import SpringStuff.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Cipher;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(value="/test", produces =  "application/json; charset=UTF-8")
    public ResponseEntity<?> testing(){
        return new ResponseEntity<String>("Test successfull",HttpStatus.OK);
    }


    @PostMapping(value="/putUser")
    public void putUser(@RequestBody User user){
        userRepository.save(user);
    }

    @GetMapping(value="/findById",produces = "application/json; charset=UTF-8")
    public ResponseEntity<?> findId(@RequestParam(value="id") Long id){
        return new ResponseEntity<User>(userRepository.getById(id), HttpStatus.OK);
    }

    @GetMapping(value="/findByPhone",produces = "application/json; charset=UTF-8")
    public ResponseEntity<?> findPhone(@RequestParam(value="phone") String phone){
        return new ResponseEntity<User>(userRepository.getByPhone(phone),HttpStatus.OK);
    }

    @GetMapping(value="/findByPassport", produces = "application/json; charset=UTF-8")
    public ResponseEntity<?> findPassport(@RequestParam(value = "passport") String passport){
        return new ResponseEntity<User>(userRepository.getByPassport(passport), HttpStatus.OK);
    }

    @GetMapping(value="/findBySurname",produces = "application/json; charset=UTF-8")
    public ResponseEntity<?> findSurname(@RequestParam(value="surname") String surname){
        return new ResponseEntity<List<User>>(userRepository.getBySurname(surname),HttpStatus.OK);
    }

    @PutMapping(value="/login",produces = "application/json; charset=UTF-8")
    public ResponseEntity<?> login(@RequestParam(value="phone") String phone, @RequestParam(value="password") String password){
        User user = userRepository.getByPhone(phone);

        if (BCrypt.checkpw(password,user.getPasswordHash())){
            return new ResponseEntity<String>("You logged in, "+user.getName(), HttpStatus.OK);
        }
        else return new ResponseEntity<String>("oops, something went wrong",HttpStatus.OK);
    }


}
