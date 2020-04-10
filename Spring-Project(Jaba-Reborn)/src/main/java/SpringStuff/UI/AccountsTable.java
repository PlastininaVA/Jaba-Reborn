package SpringStuff.UI;

import SpringStuff.CurrentInfo;
import SpringStuff.Entities.Account;
import SpringStuff.Repos.AccountRepository;
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



@SpringUI(path = "/layout/accounts")
public class AccountsTable extends UI {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AccountRepository accountRepository;

    @Override
    protected void init(VaadinRequest request) {
        MVerticalLayout verticalLayout = new MVerticalLayout();
        MGrid<Account> table = new MGrid(Account.class);
        table.setRows(accountRepository.getByUser(userRepository.getById(CurrentInfo.getCurrentUser())));
        table.withProperties("userid", "id", "balance", "currency");
        MTextField accountIdField = new MTextField("Account ID");

        Button movetotransactions = new Button("Transactions");
        movetotransactions.addClickListener(e -> {
            CurrentInfo.setCurrentUser(Long.valueOf(accountIdField.toString()));
            Page.getCurrent().setLocation("/layout/transactions");
                });
        verticalLayout.add(table);
        verticalLayout.add(accountIdField);
        verticalLayout.add(movetotransactions);

        Button gotomain = new Button("Main screen");
        gotomain.addClickListener(e -> {
            Page.getCurrent().setLocation("/layout/main");
        });

        verticalLayout.add(gotomain);
        setContent(verticalLayout);
    }
}