package SpringStuff.Repos;

import SpringStuff.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Репозиторий пользователей
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * @return пользователь с соответствующим id(задаётся как параметр) из базы данных
     */
    User getById(Long id);
    /**
     * @return пользователь с соответствующим phone(задаётся как параметр) из базы данных
     */
    User getByPhone(String phone);
    /**
     * @return пользователь с соответствующим passport(задаётся как параметр) из базы данных
     */
    User getByPassport(String Passport);
    /**
     * @return List пользователей с соответствующим surname(задаётся как параметр) из базы данных
     */
    List<User> getBySurname(String Surname);

}
