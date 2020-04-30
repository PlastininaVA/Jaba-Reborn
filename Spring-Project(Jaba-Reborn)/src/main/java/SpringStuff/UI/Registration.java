package SpringStuff.UI;


import SpringStuff.CurrentInfo;
import SpringStuff.CurrentInfo;
import SpringStuff.DTO.UserDTO;
import SpringStuff.Entities.User;
import SpringStuff.Repos.UserRepository;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.viritin.layouts.MVerticalLayout;



@SpringUI(path = "/layout/registration")
public class Registration extends UI{
    @Autowired
    UserRepository userRepository;


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        UserForm editor = new UserForm();
        editor.setEntity(new UserDTO());
        editor.setSavedHandler(userDTO ->{
            User user = new User(userDTO);
            userRepository.save(user);
            editor.setEntity(new UserDTO());
        });

        Button login = new Button("Login");
        login.addClickListener(e ->
        {
            Page.getCurrent().setLocation("/layout/login");
        });

        setContent(new VerticalLayout(editor,login));
    }
}
