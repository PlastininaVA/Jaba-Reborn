package SpringStuff.UI;
import SpringStuff.CurrentInfo;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import org.apache.commons.lang3.math.NumberUtils;
import com.vaadin.spring.annotation.SpringUI;
import org.vaadin.viritin.fields.IntegerField;
import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.layouts.MVerticalLayout;

@SpringUI(path = "/layout/user")
public class UserPage extends UI{
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        MVerticalLayout layout = new MVerticalLayout();
        IntegerField accountIdField = new IntegerField("Account ID");
        Button AccountPage = new Button("Account Page");
        AccountPage.addClickListener(e ->{
                CurrentInfo.setCurrentUser(Long.valueOf(accountIdField.toString()));
                Page.getCurrent().setLocation("/layout/transaction");
        });

        Button AccountsTable = new Button("Accounts Table");
        AccountsTable.addClickListener(e ->
        {
            Page.getCurrent().setLocation("/layout/accountstable");
        });

        Button addAccount = new Button("Add account");
        addAccount.addClickListener(e ->{
            Page.getCurrent().setLocation("/layout/addaccount");
        });


        Button main = new Button("Main screen");
        main.addClickListener(e -> {
            Page.getCurrent().setLocation("/layout/main");
        });




        layout.add(accountIdField, AccountPage, addAccount, main);
        setContent(layout);
    }
}
