package SpringStuff.UI;

import SpringStuff.CurrentInfo;
import SpringStuff.Entities.Account;
import SpringStuff.Entities.Transaction;
import SpringStuff.Repos.AccountRepository;
import SpringStuff.Repos.TransactionRepository;
import SpringStuff.Repos.UserRepository;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.grid.MGrid;
import org.vaadin.viritin.layouts.MVerticalLayout;



@SpringUI(path = "/layout/transactions")
public class TransactionsTable extends UI {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    AccountRepository accountRepository;

    @Override
    protected void init(VaadinRequest request) {
        MVerticalLayout layout = new MVerticalLayout();

        MGrid<Transaction> tableSent = new MGrid<>(Transaction.class);

        tableSent.addColumn(transaction -> {return transaction.getSender().getId();}).setCaption("senderid").setId("senderid");
        tableSent.addColumn(transaction -> {return transaction.getReceiver().getId();}).setCaption("receiverid").setId("receiverid");
        tableSent.setRows(transactionRepository.getBySender(accountRepository.getById(CurrentInfo.getCurrentAccount())));
        tableSent.withProperties("id", "currency", "sum", "date", "senderid", "receiverid");

        MGrid<Transaction> tableReceived = new MGrid<>(Transaction.class);

        tableReceived.addColumn(transaction -> {return transaction.getSender().getId();}).setCaption("senderid").setId("senderid");
        tableReceived.addColumn(transaction -> {return transaction.getReceiver().getId();}).setCaption("receiverid").setId("receiverid");
        tableReceived.setRows(transactionRepository.getByReceiver(accountRepository.getById(CurrentInfo.getCurrentAccount())));
        tableReceived.withProperties("id", "currency", "sum", "date", "senderid", "receiverid");


        layout.add(tableSent);
        layout.add(tableReceived);

        Button accountPage = new Button("Account page");

        Button main = new Button("Main screen");
        main.addClickListener(e -> {
            CurrentInfo.setCurrentAccount(null);
            Page.getCurrent().setLocation("/layout/main");
        });

        layout.add(main);
        setContent(layout);
    }
}