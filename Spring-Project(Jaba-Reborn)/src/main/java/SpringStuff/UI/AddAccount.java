package SpringStuff.UI;

import SpringStuff.CurrentInfo;
import SpringStuff.CurrentInfo;
import SpringStuff.DTO.AccountDTO;
import SpringStuff.Entities.Account;
import SpringStuff.Entities.User;
import SpringStuff.Entities.currencyEnum;
import SpringStuff.Repos.AccountRepository;
import SpringStuff.Repos.UserRepository;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.viritin.layouts.MVerticalLayout;



@SpringUI(path = "/layout/addaccount")
public class AddAccount extends UI{
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        AccountForm editor = new AccountForm();
        editor.setEntity(new AccountDTO());
        editor.setSavedHandler(accountDTO ->{
            Account account = new Account();
            account.setBalance(new Double(100));
            account.setUser(userRepository.getById(CurrentInfo.getCurrentUser()));
            account.setCurrency(currencyEnum.valueOf(accountDTO.getCurrency()));
            accountRepository.save(account);
            editor.setEntity(new AccountDTO());
        });
        Button userPage = new Button("User Page");
        userPage.addClickListener(e -> {
           Page.getCurrent().setLocation("/layout/user");
        });
        setContent(new VerticalLayout(editor,userPage));
    }
}
