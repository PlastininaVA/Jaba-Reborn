package UserStuff;

import org.mindrot.jbcrypt.BCrypt;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DataBaseServlet extends HttpServlet {

    private DataBase dataBase;
    private AccountDataBase accountDataBase;

    public DataBaseServlet(DataBase dataBase, AccountDataBase accountDataBase) {
        this.dataBase = dataBase; this.accountDataBase = accountDataBase;
    }


    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        long id = -1;
        if (request.getParameter("id")!=null) {
            id = Long.parseLong(request.getParameter("id"));
        }
        String phone = request.getParameter("phone");
        String passport = request.getParameter("passport");
        String surname = request.getParameter("surname");
        String password = request.getParameter("password");
        String action = request.getParameter("action");
        //-------------------------------------------------------
        if ((id>=0) && (action.equals("seeUsersAccounts"))){
            User user = dataBase.getUserById(id);
            if (user!=null){
                for (int i=0; i<user.accounts.size(); i++){
                    response.getWriter().println("Accounts ids are");
                    response.getWriter().println(user.accounts.get(i).toString());
                }
            }
        }

        //--------------------------------------------------------
        if (( surname != null ) && (action.equals("surnameSearch"))) {
            boolean mightbefound = true;
            boolean notfoundanything = true;
            while (mightbefound) {
                User user = dataBase.getUserBySurname(surname);
                if (user != null) {
                    response.getWriter().println(String.format("User found: ", user.getName()));
                    notfoundanything = false;
                } else {
                    if (notfoundanything) {response.getWriter().println("User not found");}
                    mightbefound = false;
                }
            }
        }


        if (( passport != null ) && ( action.equals("passportSearch"))){
            User user = dataBase.getUserByPassport(passport);
            if (user != null) {
                response.getWriter().println(String.format("User found: ", user.getName()));
            } else {
                response.getWriter().println("User not found");
            }
        }

        if (( phone != null) && (action.equals("phoneSearch"))) {
            User user = dataBase.getUserByPhone(phone);
            if (user != null) {
                response.getWriter().println(String.format("User found: ", user.getName()));
            } else {
                response.getWriter().println("User not found");
            }
        }

        if (( id >= 0 ) && (action.equals("idSearch"))) {
            User user = dataBase.getUserById(id);
            if (user != null){
                response.getWriter().println(String.format("Hello %s",user.getName()));
            } else {
                response.getWriter().println("User not found");
            }
        }

        if ((password != null) && ( phone != null ) && (action.equals("login")))  {
            User user = dataBase.getUserByPhone(phone);
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
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String patronymic = request.getParameter("patronymic");
        String passport = request.getParameter("passport");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

       if (action.equals("putUser")) {
           User user = new User(name,surname,patronymic,passport,phone,password);
           dataBase.putUser(user);
       }
        //---------------------------------------------------------------
        long id = -1;
        double balance = -1;
        String number = request.getParameter("number");
        if (request.getParameter("balance")!=null) {
             balance = Double.parseDouble(request.getParameter("balance"));
        }
        //-----------------------------------------------
        CURRENCY currency = CURRENCY.US;
        if (request.getParameter("currency").equals("EU")){
            currency=CURRENCY.EU;
        }
        if (request.getParameter("currency").equals("RU")){
            currency=CURRENCY.RU;
        }
        //---------------------------------------------------
        if (request.getParameter("id")!=null){
            id = Long.parseLong(request.getParameter("id"));
        }
        //----------------------------------------------------------------
        if (action.equals("addAccount")){
            Account account = new Account(number, balance, currency);
            accountDataBase.putAccount(account);
            dataBase.getUserById(id).addAccount(accountDataBase.getCurrentId()-1);
        }
        //-----------------------------------------------------------------
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}