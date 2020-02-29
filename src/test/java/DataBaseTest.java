import UserStuff.DataBase;
import UserStuff.User;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;


public class DataBaseTest {
    @Test
    public void putUser(){
        DataBase testBase = new DataBase();
        User Semen = new User("Semen", "Semenov", "Semenovich", "1234123456",
                "880005553535","123456");
        testBase.putUser(Semen);
        assertEquals(testBase.getUserByPassport("1234123456").getPassport(),"1234123456");
        assertEquals(testBase.getUserByPassport("1234123456").getName(),"Semen");
        assertEquals(testBase.getUserByPhone("88005553535").getPhone(),"88005553535");
        assertEquals(testBase.getUserByPhone("88005553535").getName(),"Semen");
        assertEquals(testBase.getUserBySurname("Semenov").getSurname(),"Semenov");
        assertEquals(testBase.getUserBySurname("Semenov").getName(),"Semen");
        assertEquals(testBase.getUserById(0).getName(), "Semen");
    }
    @Test
    public void getUserByPassport(){
        DataBase testBase = new DataBase();
        User Semen = new User("Semen", "Semenov", "Semenovich", "1234123456",
                "880005553535","123456");
        testBase.putUser(Semen);
        assertEquals(testBase.getUserByPassport("1234123456").getPassport(),"1234123456");
        assertEquals(testBase.getUserByPassport("1234123456").getName(),"Semen");
    }
    @Test
    public void getUserByPhone(){
        DataBase testBase = new DataBase();
        User Semen = new User("Semen", "Semenov", "Semenovich", "1234123456",
                "880005553535","123456");
        testBase.putUser(Semen);
        assertEquals(testBase.getUserByPhone("88005553535").getPhone(),"88005553535");
        assertEquals(testBase.getUserByPhone("88005553535").getName(),"Semen");
    }
    @Test
    public void getUserBySurname() {
        DataBase testBase = new DataBase();
        User Semen = new User("Semen", "Semenov", "Semenovich", "1234123456",
                "880005553535", "123456");
        testBase.putUser(Semen);
        assertEquals(testBase.getUserBySurname("Semenov").getSurname(),"Semenov");
        assertEquals(testBase.getUserBySurname("Semenov").getName(),"Semen");

    }
}
