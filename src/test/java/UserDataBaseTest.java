import UserStuff.UserDataBase;
import UserStuff.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class UserDataBaseTest {
    @Test
    public void putUser(){
        UserDataBase testBase = new UserDataBase();
        User Semen = new User("1","Semen", "Semenov", "Semenovich", "1234123456",
                "880005553535","123456");
        testBase.putUser(Semen);
        assertEquals(testBase.getUserByPassport("1234123456").getPassport(),"1234123456");
        assertEquals(testBase.getUserByPassport("1234123456").getName(),"Semen");
        assertEquals(testBase.getUserByPhone("88005553535").getPhone(),"88005553535");
        assertEquals(testBase.getUserByPhone("88005553535").getName(),"Semen");
        assertEquals(testBase.getUserBySurname("Semenov").getSurname(),"Semenov");
        assertEquals(testBase.getUserBySurname("Semenov").getName(),"Semen");
        assertEquals(testBase.getUserById("1").getName(), "Semen");
    }
    @Test
    public void getUserByPassport(){
        UserDataBase testBase = new UserDataBase();
        User Semen = new User("1", "Semen", "Semenov", "Semenovich", "1234123456",
                "880005553535","123456");
        testBase.putUser(Semen);
        assertEquals(testBase.getUserByPassport("1234123456").getPassport(),"1234123456");
        assertEquals(testBase.getUserByPassport("1234123456").getName(),"Semen");
    }
    @Test
    public void getUserByPhone(){
        UserDataBase testBase = new UserDataBase();
        User Semen = new User("1","Semen", "Semenov", "Semenovich", "1234123456",
                "880005553535","123456");
        testBase.putUser(Semen);
        assertEquals(testBase.getUserByPhone("88005553535").getPhone(),"88005553535");
        assertEquals(testBase.getUserByPhone("88005553535").getName(),"Semen");
    }
    @Test
    public void getUserBySurname() {
        UserDataBase testBase = new UserDataBase();
        User Semen = new User("1","Semen", "Semenov", "Semenovich", "1234123456",
                "880005553535", "123456");
        testBase.putUser(Semen);
        assertEquals(testBase.getUserBySurname("Semenov").getSurname(),"Semenov");
        assertEquals(testBase.getUserBySurname("Semenov").getName(),"Semen");

    }
}
