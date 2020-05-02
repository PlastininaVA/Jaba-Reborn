package SpringStuff.Scheduled;

import SpringStuff.CurrentInfo;
import SpringStuff.Entities.ExchangeRate;
import SpringStuff.Utilities.JsonReader;
import SpringStuff.Repos.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@EnableScheduling
public class ExchangeRateScheduler {
    @Autowired
    ExchangeRateRepository exchangeRateRepository;

//86400000 - 1 сутки (не cron, чтобы при запуске приложения обновлялся курс)
    @Scheduled(fixedDelay = 86400000, initialDelay = 1000)
    public void getExchangeRate() throws IOException{
        System.out.println("blin");
        ExchangeRate exchangeRate = new ExchangeRate(JsonReader.readJsonFromUrl(
                String.format("https://www.cbr-xml-daily.ru/daily_json.js")));
        exchangeRateRepository.save(exchangeRate);
        System.out.println(exchangeRate.getDollarValue());
        System.out.println(exchangeRate.getEuroValue());
        CurrentInfo.setCurrentExchangeRate(exchangeRate.getId());
        System.out.println(CurrentInfo.getCurrentExchangeRate());
        System.out.println(exchangeRateRepository.getById(CurrentInfo.getCurrentExchangeRate()).getEuroValue());
    }
}
