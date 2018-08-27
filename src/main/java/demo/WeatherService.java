package demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
@CacheConfig(cacheNames = "weatherCache")
public class WeatherService {
    @Value("${weatherService.temp}")
    int value;

    @Value("${weatherService.url}")
    String url;

    @Cacheable
    public String getCurrentTemp() {
        System.out.println("[LOG] Reading temp from " + url);
        return String.valueOf(value);
    }

    @CacheEvict
    public void removeTemp() {
        System.out.println("removed");
    }

    @CachePut
    public String setTemp() {
        System.out.println("set");
        return "42F";
    }
}
