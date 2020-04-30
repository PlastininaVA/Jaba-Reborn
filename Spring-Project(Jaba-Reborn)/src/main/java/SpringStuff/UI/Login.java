package SpringStuff.UI;

import SpringStuff.CurrentInfo;
import SpringStuff.CurrentInfo;
import SpringStuff.Entities.User;
import SpringStuff.Repos.UserRepository;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.viritin.layouts.MVerticalLayout;

import java.util.concurrent.atomic.AtomicReference;

@SpringUI(path = "/layout/login")
public class Login extends UI {
    @Autowired
    private UserRepository userRepository;

    @Override
    protected void init(VaadinRequest request) {
        MVerticalLayout layout = new MVerticalLayout();
        LoginForm loginForm = new LoginForm();
        final Label label = new Label();
        loginForm.addLoginListener(event -> {
            String phone = event.getLoginParameter("username");
            String password = event.getLoginParameter("password");
            User user = userRepository.getByPhone(phone);
            if ((user == null) || ((user != null) && !(BCrypt.checkpw(password,user.getPasswordHash())))) {
                label.setValue("No suсh account");
            }
            else {
                CurrentInfo.setCurrentUser(user.getId());
                label.setValue("Login successful, redirecting to profile");
                try {
                    Thread.sleep(4500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Page.getCurrent().setLocation("/layout/main");
            }
        });

        Button register = new Button("Registration");
        register.addClickListener(e ->
        {
            Page.getCurrent().setLocation("/layout/registration");
        });

        layout.addComponents(loginForm,label);
        layout.add(register);
        setContent(layout);
    }
}