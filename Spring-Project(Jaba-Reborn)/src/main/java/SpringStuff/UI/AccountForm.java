package SpringStuff.UI;

import SpringStuff.DTO.AccountDTO;
import SpringStuff.Entities.Account;
import SpringStuff.Entities.User;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.viritin.form.AbstractForm;

public class AccountForm extends AbstractForm<AccountDTO> {

    private final TextField currency = new TextField("Enter currency");
    private final Button saveButton = new Button("Add account");

    public AccountForm() {
        super(AccountDTO.class);
    }

    @Override
    protected Component createContent() {
        setSaveButton(saveButton);
        return new VerticalLayout(currency, saveButton);
    }
}