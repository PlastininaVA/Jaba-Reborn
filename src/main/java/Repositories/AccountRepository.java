package Repositories;

import DataBase.HibernateManager;
import AccountsAndOperations.Account;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AccountRepository {
    private HibernateManager db;

    public AccountRepository() {
        this.db = new HibernateManager();
    }

    public Account getAccountsByUserID(String id){
        Session session = db.getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Account account = (Account) session.get(Account.class, id);

        //Не до конца разобралась с работой базы данных, что будет возвращаться, только один счет?
        //Как сделать, чтобы возвращался список счетов для каждого пользователя?

        transaction.commit();
        session.close();
        return account;
    }
}
