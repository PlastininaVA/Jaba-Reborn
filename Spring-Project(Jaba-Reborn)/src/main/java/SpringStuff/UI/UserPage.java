package SpringStuff.UI;
import SpringStuff.CurrentInfo;
import SpringStuff.Repos.AccountRepository;
import SpringStuff.Repos.UserRepository;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import org.apache.commons.lang3.math.NumberUtils;
import com.vaadin.spring.annotation.SpringUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.viritin.fields.IntegerField;
import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.layouts.MVerticalLayout;

@SpringUI(path = "/layout/user")
public class UserPage extends UI{
    @Autowired
    UserRepository userRepository;
    @Autowired
    AccountRepository accountRepository;
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        MVerticalLayout layout = new MVerticalLayout();

        Label currentUser = new Label("Current user id  " + CurrentInfo.getCurrentUser().toString());

        Label currentUserName = new Label("name " + userRepository.getById(CurrentInfo.getCurrentUser()).getName());

        TextField accountIdField = new TextField("Account ID");

        Button accountPage = new Button("Account Page");

        Label accountAccessibility = new Label("");

        accountPage.addClickListener(e ->{
                if (CurrentInfo.getCurrentUser() == accountRepository.getById(Long.valueOf(accountIdField.getValue())).getUser().getId()) {
                    CurrentInfo.setCurrentAccount(Long.valueOf(accountIdField.getValue()));
                    Page.getCurrent().setLocation("/layout/account");
                }
                else { accountAccessibility.setValue("Cannot access the account(either does not exist or belongs to another user)"); }
        });

        Button accountsTable = new Button("Accounts Table");
        accountsTable.addClickListener(e ->{
            Page.getCurrent().setLocation("/layout/accounttable");
        });

        Button addAccount = new Button("Add account");
        addAccount.addClickListener(e ->{
            Page.getCurrent().setLocation("/layout/addaccount");
        });


        Button main = new Button("Main screen");
        main.addClickListener(e -> {
            Page.getCurrent().setLocation("/layout/main");
        });


        layout.add(currentUser, currentUserName, accountIdField, accountPage, accountsTable ,addAccount, main);
        setContent(layout);
    }
}
