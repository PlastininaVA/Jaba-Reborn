package SpringStuff.UI;

import SpringStuff.DTO.UserDTO;
import SpringStuff.Entities.User;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.viritin.button.MButton;
import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.form.AbstractForm;

public class UserForm extends AbstractForm<UserDTO> {

    private final MTextField name = new MTextField("Enter name");
    private final MTextField surname = new MTextField("Enter surname");
    private final MTextField patronymic = new MTextField("Enter patronymic");
    private final MTextField passport = new MTextField("Enter passport");
    private final MTextField phone = new MTextField("Enter phone");
    private final MTextField password = new MTextField("Enter password");
    private final MButton saveButton = new MButton("Register");

    public UserForm() {
        super(UserDTO.class);
    }

    @Override
    protected Component createContent() {
        setSaveButton(saveButton);
        return new VerticalLayout(name, surname, patronymic, passport, phone, password, saveButton);
    }
}
