package SpringStuff.UI;

import SpringStuff.Entities.User;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.viritin.form.AbstractForm;

public class UserForm extends AbstractForm<User> {

    private final TextField name = new TextField("Enter name");
    private final TextField surname = new TextField("Enter surname");
    private final TextField patronymic = new TextField("Enter patronymic");
    private final TextField passport = new TextField("Enter passport");
    private final TextField phone = new TextField("Enter phone");
    private final TextField password = new TextField("Enter password");
    private final Button saveButton = new Button("Register");

    public UserForm() {
        super(User.class);
    }

    @Override
    protected Component createContent() {
        setSaveButton(saveButton);
        return new VerticalLayout(name, surname, patronymic, passport, phone, password, saveButton);
    }
}
