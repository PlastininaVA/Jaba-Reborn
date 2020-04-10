package SpringStuff.UI;

import SpringStuff.CurrentInfo;
import SpringStuff.CurrentInfo;
import SpringStuff.Entities.User;
import SpringStuff.Repos.UserRepository;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.LoginForm;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.atomic.AtomicReference;

@SpringUI(path = "/layout/login")
public class Login extends UI {
    @Autowired
    private UserRepository userRepository;

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout layout = new VerticalLayout();
        LoginForm loginForm = new LoginForm();
        final Label label = new Label();
        loginForm.addLoginListener(event -> {
            String phone = event.getLoginParameter("phone");
            String password = event.getLoginParameter("password");
            User user = userRepository.getByPhone(phone);
            if ((user == null) || ((user != null) && !(BCrypt.checkpw(password,user.getPasswordHash())))) {
                label.setValue("No suсh account");
            }
            else {
                CurrentInfo.setCurrentUser(user.getId());
                label.setValue("Login successful, redirecting to profile");
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Page.getCurrent().setLocation("/main");
            }
        });
        layout.addComponents(loginForm,label);
        setContent(layout);
    }
}