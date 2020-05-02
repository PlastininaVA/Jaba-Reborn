package SpringStuff.UI;

import SpringStuff.CurrentInfo;
import SpringStuff.Entities.Account;
import SpringStuff.Entities.Transaction;
import SpringStuff.Repos.AccountRepository;
import SpringStuff.Repos.ExchangeRateRepository;
import SpringStuff.Repos.TransactionRepository;
import SpringStuff.Utilities.MoneyConverter;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.viritin.fields.DoubleField;
import org.vaadin.viritin.fields.IntegerField;
import org.vaadin.viritin.layouts.MVerticalLayout;

import java.util.Date;

@SpringUI(path = "/layout/account")
public class AccountPage extends UI {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    ExchangeRateRepository exchangeRateRepository;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        MVerticalLayout layout = new MVerticalLayout();
        Label accountLabel = new Label("current account id is" + CurrentInfo.getCurrentAccount().toString());
        Label balanceLabel = new Label("balance is " + accountRepository.getById(CurrentInfo.getCurrentAccount()).getBalance());
        Button movetotransactions = new Button("Transactions");
        movetotransactions.addClickListener(e -> {
            Page.getCurrent().setLocation("/layout/transactions");
        });

        DoubleField sum = new DoubleField("Sum");
        IntegerField receiver = new IntegerField("Receiver");
        Button committransaction = new Button("Commit");
        Label transactionstatus = new Label("");
        committransaction.addClickListener(e ->
        {
            double euroValue = exchangeRateRepository.getById(CurrentInfo.getCurrentExchangeRate()).getEuroValue();
            double dollarValue = exchangeRateRepository.getById(CurrentInfo.getCurrentExchangeRate()).getDollarValue();
            Double money=sum.getValue();
            Long receiverid = Long.valueOf(receiver.getValue());
            if ((accountRepository.getById(CurrentInfo.getCurrentAccount()).getBalance() >= money) && (money >= 0))
                {
                    Transaction transaction = new Transaction(accountRepository.getById(CurrentInfo.getCurrentAccount()).getCurrency(),
                            money, (new Date()).toString(), accountRepository.getById(CurrentInfo.getCurrentAccount()),
                            accountRepository.getById(receiverid));
                    transactionRepository.save(transaction);

                    Account changed1 = accountRepository.getById(CurrentInfo.getCurrentAccount());
                    changed1.setBalance(changed1.getBalance() - money);
                    accountRepository.save(changed1);
                   // accountRepository.getById(
                     //       CurrentInfo.getCurrentAccount()).setBalance(accountRepository.getById(CurrentInfo.getCurrentAccount())
                       //     .getBalance()-money);
                    // ПОТОМ УДАЛЮ ОБЕЩАЮ
                    Account changed2 = accountRepository.getById(receiverid);
                    changed2.setBalance(changed2.getBalance()
                            +MoneyConverter.convert(money,
                            accountRepository.getById(CurrentInfo.getCurrentAccount()).getCurrency(),
                            accountRepository.getById(receiverid).getCurrency(),
                            euroValue, dollarValue));
                    accountRepository.save(changed2);
                 //   accountRepository.getById(receiverid)
                   //         .setBalance(accountRepository.getById(receiverid).getBalance()
                     //       +MoneyConverter.convert(money,
                       //     accountRepository.getById(CurrentInfo.getCurrentAccount()).getCurrency(),
                         //   accountRepository.getById(receiverid).getCurrency(),
                           // euroValue, dollarValue));
                    // ПОТОМ УДАЛЮ ОБЕЩАЮ
                    balanceLabel.setValue("balance is " + accountRepository.getById(CurrentInfo.getCurrentAccount()).getBalance());

                    transactionstatus.setValue("Transaction successfull");
            }
            else if (money < 0){
                transactionstatus.setValue("Input error");
            }
             else {
                transactionstatus.setValue("Not enough money");
            }
        }
        );



        Button main = new Button("User page");
        main.addClickListener(e -> {
            CurrentInfo.setCurrentAccount(null);
            Page.getCurrent().setLocation("/layout/user");
        });

        layout.add(accountLabel, balanceLabel, movetotransactions, sum, receiver, committransaction, transactionstatus, main);
        setContent(layout);

    }

}
