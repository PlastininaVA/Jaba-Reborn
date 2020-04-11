package SpringStuff.UI;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import org.vaadin.viritin.layouts.MVerticalLayout;

@SpringUI(path = "/layout/main")
public class MainPageLogged extends  UI{
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        MVerticalLayout layout = new MVerticalLayout();
        Button button1 = new Button("Log out");
        button1.addClickListener(e -> {
            SpringStuff.CurrentInfo.setCurrentUser(null);
            Page.getCurrent().setLocation("/layout/login");
        });
        Button button2 = new Button("To user page");
        button2.addClickListener(e -> Page.getCurrent().setLocation("/layout/user"));

    }
}
