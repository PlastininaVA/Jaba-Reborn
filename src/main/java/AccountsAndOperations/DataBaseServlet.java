package AccountsAndOperations;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DataBaseServlet extends HttpServlet {

    DataBase dataBase;

    public DataBaseServlet(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        if (id >= 0) {
            Account account = dataBase.getAccountById(id);
            if (account != null) {
                /* response.getWriter().println(String.format("Hello %s",user.getFirstName()));
            } else {
                response.getWriter().println("User not found"); */

                //Нужен ли какой-либо web-функционал для счетов?
            }
        }
    }
}