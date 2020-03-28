/*package UserStuff;

import org.mindrot.jbcrypt.BCrypt;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccountDataBaseServlet extends HttpServlet {

    private AccountDataBase accountDataBase;

    public AccountDataBaseServlet(UserDataBase userDataBase, AccountDataBase accountDataBase) {
      this.accountDataBase = accountDataBase;
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long id = -1;
        double balance = -1;
        String number = request.getParameter("number");
        if (request.getParameter("balance")!=null) {
            balance = Double.parseDouble(request.getParameter("balance"));
        }
        String action = request.getParameter("action");

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
            userDataBase.getUserById(id).addAccount(accountDataBase.getCurrentId()-1);
        }
        //-----------------------------------------------------------------
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}

 */