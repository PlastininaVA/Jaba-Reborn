package UserStuff;

import org.mindrot.jbcrypt.BCrypt;
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
        int action = 0; long id = 0;
        if (request.getParameter("id")!=null) {
            id = Long.parseLong(request.getParameter("id"));
        }
        String phone = request.getParameter("phone");
        String passport = request.getParameter("passport");
        String surname = request.getParameter("surname");
        String password = request.getParameter("password");
        if (request.getParameter("action")!=null) {
            action = Integer.parseInt(request.getParameter("action"));
        }

        if (( surname != null ) && (action == 1)) {
            boolean mightbefound = true;
            while (mightbefound) {
                User user = dataBase.getUserBySurname(surname);
                if (user != null) {
                    response.getWriter().println(String.format("User found: ", user.getName()));
                } else {
                    response.getWriter().println("User not found");
                    mightbefound = false;
                }
            }
        }


        if (( passport != null ) && ( action == 2 )){
            User user = dataBase.getUserByPassport(passport);
            if (user != null) {
                response.getWriter().println(String.format("User found: ", user.getName()));
            } else {
                response.getWriter().println("User not found");
            }
        }

        if (( phone != null) && (action == 3)) {
            User user = dataBase.getUserByPhone(phone);
            if (user != null) {
                response.getWriter().println(String.format("User found: ", user.getName()));
            } else {
                response.getWriter().println("User not found");
            }
        }

        if (( id >= 0 ) && (action == 4)) {
            User user = dataBase.getUserById(id);
            if (user != null){
                response.getWriter().println(String.format("Hello %s",user.getName()));
            } else {
                response.getWriter().println("User not found");
            }
        }

        if ((password != null) && ( phone != null ) && (action == 0))  {
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
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String patronymic = request.getParameter("patronymic");
        String passport = request.getParameter("passport");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        User user = new User(name,surname,patronymic,passport,phone,password);
        dataBase.putUser(user);
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}