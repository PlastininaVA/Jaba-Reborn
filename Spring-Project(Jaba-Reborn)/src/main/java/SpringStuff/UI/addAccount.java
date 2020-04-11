package SpringStuff.UI;

import SpringStuff.CurrentInfo;
import SpringStuff.CurrentInfo;
import SpringStuff.Entities.Account;
import SpringStuff.Entities.User;
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
public class addAccount extends UI{
    @Autowired
    AccountRepository accountRepository;


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        AccountForm editor = new AccountForm();
        editor.setEntity(new Account());
        editor.setSavedHandler(account ->{
            accountRepository.save(account);
            editor.setEntity(new Account());
        });

        setContent(new VerticalLayout(editor));
    }
}
