package SpringStuff.UI;

import SpringStuff.CurrentInfo;
import SpringStuff.Entities.Account;
import SpringStuff.Entities.User;
import SpringStuff.Repos.AccountRepository;
import SpringStuff.Repos.UserRepository;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.renderers.NumberRenderer;
import com.vaadin.ui.renderers.TextRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.viritin.fields.IntegerField;
import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.grid.MGrid;
import org.vaadin.viritin.layouts.MVerticalLayout;



@SpringUI(path = "/layout/accounttable")
public class AccountsTable extends UI {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AccountRepository accountRepository;

    @Override
    protected void init(VaadinRequest request) {
        MVerticalLayout verticalLayout = new MVerticalLayout();
        MGrid<Account> table = new MGrid<Account>(Account.class);
        table.addColumn(account -> {return account.getUser().getId();}).setCaption("userid").setId("userid");
        table.setRows(accountRepository.getByUser(userRepository.getById(CurrentInfo.getCurrentUser())));
        table.withProperties("userid", "id", "balance", "currency");


        IntegerField accountIdField = new IntegerField("Account ID");
        Button movetotransactions = new Button("Transactions");
        movetotransactions.addClickListener(e -> {
            CurrentInfo.setCurrentAccount(Long.valueOf(accountIdField.getValue()));
            Page.getCurrent().setLocation("/layout/transactions");
                });

        verticalLayout.add(table,accountIdField,movetotransactions);

        Button userPage = new Button("User page");
        userPage.addClickListener(e -> {
            Page.getCurrent().setLocation("/layout/user");
        });

        verticalLayout.add(userPage);
        setContent(verticalLayout);
    }
}