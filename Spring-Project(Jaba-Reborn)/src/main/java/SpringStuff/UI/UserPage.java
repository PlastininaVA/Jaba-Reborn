package SpringStuff.UI;
import SpringStuff.CurrentInfo;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import org.apache.commons.lang3.math.NumberUtils;
import com.vaadin.spring.annotation.SpringUI;
import org.vaadin.viritin.fields.MTextField;

@SpringUI(path = "/layout/user")
public class UserPage extends UI{
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        MTextField accountIdField = new MTextField("Account ID");
        Button AccountPage = new Button("Account Page");
        AccountPage.addClickListener(e ->{
            if (NumberUtils.isDigits(accountIdField.toString())) {
                CurrentInfo.setCurrentUser(Long.valueOf(accountIdField.toString()));
                Page.getCurrent().setLocation("/layout/transaction");
            }
        });

        Button AccountsTable = new Button("Accounts Table");


        Button gotomain = new Button("Main screen");
        gotomain.addClickListener(e -> {
            Page.getCurrent().setLocation("/layout/main");
        });

    }
}
