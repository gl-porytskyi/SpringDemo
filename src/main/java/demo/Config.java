package demo;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = "demo")
@PropertySource("/demo.properties")
@EnableCaching
public class Config {
    @Bean
    CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }
}
