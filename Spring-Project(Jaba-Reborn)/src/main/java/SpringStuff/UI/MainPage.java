package SpringStuff.UI;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import org.vaadin.viritin.button.MButton;
import org.vaadin.viritin.layouts.MVerticalLayout;
import sun.rmi.runtime.Log;

@SpringUI(path = "/layout/main")
public class MainPage extends  UI{
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        MVerticalLayout layout = new MVerticalLayout();
        MButton LogOut = new MButton("Log out");
        LogOut.addClickListener(e -> {
            SpringStuff.CurrentInfo.setCurrentUser(null);
            Page.getCurrent().setLocation("/layout/login");
        });
        MButton toUserPage = new MButton("To user page");
        toUserPage.addClickListener(e -> Page.getCurrent().setLocation("/layout/user"));
        layout.add(LogOut, toUserPage);
        setContent(layout);
    }
}
