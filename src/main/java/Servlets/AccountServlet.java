package Servlets;

import AccountsAndOperations.Account;
import Repositories.AccountRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AccountServlet extends HttpServlet {
    private AccountRepository accountRepository;

    public AccountServlet(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("account_userID");

        Account account = accountRepository.getAccountsByUserID(id);
        if (account != null){
            resp.getWriter().println(account);
        } else {
            resp.getWriter().println("Accounts not found");
        }

        resp.setContentType("text/html;charset=utf-8");
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
