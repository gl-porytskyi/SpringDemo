package demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@ComponentScan(basePackages = "demo")
@PropertySource("/demo.properties")
@EnableCaching
public class Config {
    @Bean
    @Profile("default")
    CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }

    @Bean
    @Profile("redis")
    CacheManager redisCacheManager(JedisConnectionFactory connectionFactory) {
        return RedisCacheManager.create(connectionFactory);
    }

    @Bean
    JedisConnectionFactory connectionFactory(@Value("${redis}") String redis) {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.getStandaloneConfiguration().setHostName(redis);
        return jedisConnectionFactory;
    }
}
