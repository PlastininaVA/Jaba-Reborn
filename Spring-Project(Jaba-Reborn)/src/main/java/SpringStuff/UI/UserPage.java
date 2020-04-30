package SpringStuff.UI;
import SpringStuff.CurrentInfo;
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
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        MVerticalLayout layout = new MVerticalLayout();

        Label CurrentUser = new Label("Current user id  " + CurrentInfo.getCurrentUser().toString());

        Label CurrentUserName = new Label("name " + userRepository.getById(CurrentInfo.getCurrentUser()).getName());

        TextField accountIdField = new TextField("Account ID");

        Button AccountPage = new Button("Account Page");

        AccountPage.addClickListener(e ->{
                CurrentInfo.setCurrentAccount(Long.valueOf(accountIdField.getValue()));
                Page.getCurrent().setLocation("/layout/account");
        });

        Button AccountsTable = new Button("Accounts Table");
        AccountsTable.addClickListener(e ->{
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




        layout.add(CurrentUser,CurrentUserName, accountIdField, AccountPage, AccountsTable ,addAccount, main);
        setContent(layout);
    }
}
