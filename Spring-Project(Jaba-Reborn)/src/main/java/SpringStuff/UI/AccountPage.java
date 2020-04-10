package SpringStuff.UI;

import SpringStuff.CurrentInfo;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;

@SpringUI(path = "/layout/account")
public class AccountPage extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
    Button movetotransactions = new Button("Transactions");
        movetotransactions.addClickListener(e -> {

        Page.getCurrent().setLocation("/layout/transactions");
    });

//ЗДЕСЬ МЕТОД ДЛЯ ДОБАВЛЕНИЯ ТРАНЗАКЦИИ

        Button gotomain = new Button("Main screen");
        gotomain.addClickListener(e -> {
            Page.getCurrent().setLocation("/layout/main");
        });



    }

}
