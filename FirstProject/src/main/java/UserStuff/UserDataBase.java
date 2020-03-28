package UserStuff;

import UserStuff.DB.*;
import javax.xml.crypto.Data;
import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.sql.*;

public class UserDataBase {

    private DBConnectionManager dbConnectionManager;

    public UserDataBase() {
        this.dbConnectionManager = new DBConnectionManager();
    }

    public User getUserById(String id){
        User user = null;
        try{
            Connection conn = this.dbConnectionManager.connect();
            PreparedStatement st = conn.prepareStatement("select * from users where id = ?");
            st.setString(1,id);
            System.out.println(st);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
            user = new User(rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7));

            }
            st.close();

            //КАК ДОСТАТЬ МАССИВ АККАУНТОВ?
            if (user != null) {
                PreparedStatement nst = conn.prepareStatement("select number from account where id = ?");
                nst.setString(1, id);
                ResultSet nrs = nst.executeQuery();
                while (nrs.next()) {
                    user.accounts.add(nrs.getString(1));
                }
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public User getUserByPhone(String phone) {
        User user = null;
        try{
            Connection conn = this.dbConnectionManager.connect();
            PreparedStatement st = conn.prepareStatement("select * from users where phone = ?");
            st.setString(1,phone);
            System.out.println(st);
            ResultSet rs =st.executeQuery();
            while (rs.next()){
                user = new User(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));

            }
            st.close();

            //КАК ДОСТАТЬ МАССИВ АККАУНТОВ?
            if (user != null) {
                PreparedStatement nst = conn.prepareStatement("select number from account where id = ?");
                nst.setString(1, user.getId());
                ResultSet nrs = nst.executeQuery();
                while (nrs.next()) {
                    user.accounts.add(nrs.getString(1));
                }
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public User getUserByPassport(String passport){
        User user = null;
        try{
            Connection conn = this.dbConnectionManager.connect();
            PreparedStatement st = conn.prepareStatement("select * from users where passport = ?");
            st.setString(1,passport);
            System.out.println(st);
            ResultSet rs =st.executeQuery();
            while (rs.next()){
                user = new User(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));

            }
            st.close();

            //КАК ДОСТАТЬ МАССИВ АККАУНТОВ?
            if (user != null) {
                PreparedStatement nst = conn.prepareStatement("select number from account where id = ?");
                nst.setString(1, user.getId());
                ResultSet nrs = nst.executeQuery();
                while (nrs.next()) {
                    user.accounts.add(nrs.getString(1));
                }
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public ArrayList<User> getUserBySurname(String surname){
        ArrayList<User> users = new ArrayList<User>();
        User user = null;
        try{
            Connection conn = this.dbConnectionManager.connect();
            PreparedStatement st = conn.prepareStatement("select * from user where surname = ?");
            st.setString(1,surname);
            System.out.println(st);
            ResultSet rs =st.executeQuery();
            while (rs.next()){
                user = new User(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
                users.add(user);
            }
            st.close();

            //КАК ДОСТАТЬ МАССИВ АККАУНТОВ?
            if (users.get(0) != null){
                int i=0;
                while (i<users.size()) {
                    PreparedStatement nst = conn.prepareStatement("select number from account where id = ?");
                    nst.setString(1, users.get(i).getId());
                    ResultSet nrs = nst.executeQuery();
                    while (nrs.next()) {
                        users.get(i).accounts.add(nrs.getString(1));
                    }
                    i++;
                }
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;

        //ПРИДУМАТЬ КАК ВЫВОДИТЬ ВСЕХ ЮЗЕРОВ С ФАМИЛИЕЙ
    }

    public void putUser(User user){
        try {
            Connection conn = this.dbConnectionManager.connect();
            PreparedStatement st = conn.prepareStatement("insert into user values(?, ?, ?, ?, ?, ?, ?)");
            st.setString(1, user.getId());
            st.setString(2, user.getName());
            st.setString(3, user.getSurname());
            st.setString(4, user.getPatronymic());
            st.setString(5, user.getPassport());
            st.setString(6, user.getPhone());
            st.setString(7, user.getPasswordHash());

            st.executeUpdate();
            st.close();
            conn.close();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
