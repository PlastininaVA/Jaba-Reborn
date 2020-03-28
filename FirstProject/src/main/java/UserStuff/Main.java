package UserStuff;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;


public class Main {
    public static void main(String[] args) {
        UserDataBaseServlet userDataBaseServlet = new UserDataBaseServlet(new UserDataBase());
       // AccountDataBaseServlet accountDataBaseServlet = new AccountDataBaseServlet(------------------------------);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(userDataBaseServlet), "/user");
        //context.addServlet(new ServletHolder(accountDataBaseServlet), "/account");

        Server server = new Server(8080);
        server.setHandler(context);

        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}