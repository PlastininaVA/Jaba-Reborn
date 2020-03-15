package UserStuff;

import org.mindrot.jbcrypt.BCrypt;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class UserDataBaseServlet extends HttpServlet {

    private UserDataBase userDataBase;
    private String notfound = "User not found";


    public UserDataBaseServlet(UserDataBase userDataBase) {
        this.userDataBase = userDataBase;
    }


    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        String id  = request.getParameter("id");
        String phone = request.getParameter("phone");
        String passport = request.getParameter("passport");
        String surname = request.getParameter("surname");
        String password = request.getParameter("password");
        String action = request.getParameter("action");
        //-------------------------------------------------------
        if ((id != null) && (action.equals("seeUsersAccounts"))){
            User user = userDataBase.getUserById(id);
            if (user!=null){
                for (int i=0; i<user.accounts.size(); i++){
                    response.getWriter().println("Accounts ids are");
                    response.getWriter().println(user.accounts.get(i).toString());
                }
            }
        }

        //--------------------------------------------------------
        if (( surname != null ) && (action.equals("surnameSearch"))) {
            ArrayList<User> users = userDataBase.getUserBySurname(surname);
            if (users.get(0)!=null){
                for (int i =0 ; i<users.size();i++){
                    response.getWriter().println(String.format("User found: ",users.get(i).getName()));
                }

            } else {
                response.getWriter().println(notfound);
            }



        }


        if (( passport != null ) && ( action.equals("passportSearch"))){
            User user = userDataBase.getUserByPassport(passport);
            if (user != null) {
                response.getWriter().println(String.format("User found: ", user.getName()));
            } else {
                response.getWriter().println(notfound);
            }
        }

        if (( phone != null) && (action.equals("phoneSearch"))) {
            User user = userDataBase.getUserByPhone(phone);
            if (user != null) {
                response.getWriter().println(String.format("User found: ", user.getName()));
            } else {
                response.getWriter().println(notfound);
            }
        }

        if (( id != null ) && (action.equals("idSearch"))) {
            User user = userDataBase.getUserById(id);
            if (user != null){
                response.getWriter().println(String.format("Hello %s",user.getName()));
            } else {
                response.getWriter().println(notfound);
            }
        }

        if ((password != null) && ( phone != null ) && (action.equals("login")))  {
            User user = userDataBase.getUserByPhone(phone);
            if (BCrypt.checkpw(password,user.getPasswordHash())) {
                response.getWriter().println(String.format("Nice to meet you, ",user.getName()));
            } else {
                response.getWriter().println("Invalid login/password");
            }
        }

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action =request.getParameter("action");

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String patronymic = request.getParameter("patronymic");
        String passport = request.getParameter("passport");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

       if (action.equals("putUser")) {
           User user = new User(id, name,surname,patronymic,passport,phone,password);
           userDataBase.putUser(user);
       }
       //------------------------------------------------------
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}