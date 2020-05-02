package SpringStuff.Entities;


import lombok.Data;
import org.json.JSONObject;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Entity
@Data
@Table(name = "exchangerate")
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "dollar_value")
    private double dollarValue;

    @Column(name = "euro_value")
    private double euroValue;

    public ExchangeRate(){};

    public ExchangeRate(JSONObject jsonObject){
        Map<String, Object> jsonMap = jsonObject.toMap();
        Map<String, Object> valuteMap = (Map<String, Object>) jsonMap.get("Valute");
        Map<String, Object> usdMap = (Map<String, Object>) valuteMap.get("USD");
        Map<String, Object> eurMap = (Map<String, Object>) valuteMap.get("EUR");

        this.date = new Date();
        this.dollarValue = Double.parseDouble(usdMap.get("Value").toString());
        this.euroValue = Double.parseDouble(eurMap.get("Value").toString());
    }
}
