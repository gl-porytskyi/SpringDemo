package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InfoService {
    @Autowired
    WeatherService weatherService;

    public String getInfo() {
//        weatherService.setTemp();
        return "Current temp: " + weatherService.getCurrentTemp();
    }
}
