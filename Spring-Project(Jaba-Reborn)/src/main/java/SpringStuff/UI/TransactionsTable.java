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
        MVerticalLayout verticalLayout = new MVerticalLayout();
        MGrid<Transaction> tableSent = new MGrid(Account.class);
        tableSent.setRows(transactionRepository.getBySender(accountRepository.getById(CurrentInfo.getCurrentAccount())));
        tableSent.withProperties("id", "currency", "sum", "date", "sender", "receiver");


        MGrid<Transaction> tableReceived = new MGrid(Account.class);
        tableSent.setRows(transactionRepository.getByReceiver(accountRepository.getById(CurrentInfo.getCurrentAccount())));
        tableSent.withProperties("id", "currency", "sum", "date", "sender", "receiver");


        verticalLayout.add(tableSent);
        verticalLayout.add(tableReceived);

        Button gotomain = new Button("Main screen");
        gotomain.addClickListener(e -> {
            Page.getCurrent().setLocation("/layout/main");
        });

        verticalLayout.add(gotomain);
        setContent(verticalLayout);
    }
}