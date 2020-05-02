package SpringStuff.Utilities;

import SpringStuff.CurrentInfo;
import SpringStuff.Entities.currencyEnum;
import SpringStuff.Repos.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class MoneyConverter {



    public static double convert(Double sum, currencyEnum senderCurrency, currencyEnum receiverCurrency, Double euroValue, Double dollarValue) {
        if (senderCurrency.equals(receiverCurrency)) {
            return sum;
        } else if ((senderCurrency.equals(currencyEnum.EUR)) && (receiverCurrency.equals(currencyEnum.RUB))) {
            return sum * euroValue;
        } else if ((senderCurrency.equals(currencyEnum.USD)) && (receiverCurrency.equals(currencyEnum.RUB))) {
            return sum * dollarValue;
        } else if ((senderCurrency.equals(currencyEnum.RUB)) && (receiverCurrency.equals(currencyEnum.EUR))) {
            return sum / euroValue;
        } else if ((senderCurrency.equals(currencyEnum.RUB)) && (receiverCurrency.equals(currencyEnum.USD))) {
            return sum / dollarValue;
        } else if ((senderCurrency.equals(currencyEnum.EUR)) && (receiverCurrency.equals(currencyEnum.USD))) {
            return sum / euroValue * dollarValue;
        } else if ((senderCurrency.equals(currencyEnum.USD)) && (receiverCurrency.equals(currencyEnum.EUR))) {
            return sum / dollarValue * euroValue;
        } else return 0;
    }
}