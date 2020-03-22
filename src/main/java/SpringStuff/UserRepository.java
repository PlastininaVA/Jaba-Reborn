package SpringStuff;

import SpringStuff.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getById(Long id);
    User getByPhone(String phone);
    User getByPassport(String Passport);
    List<User> getBySurname(String Surname);

}
