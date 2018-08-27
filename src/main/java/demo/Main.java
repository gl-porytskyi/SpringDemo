package demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(InfoService infoService) {
        return args -> {
            System.out.println("=======================================");
            System.out.println(infoService.getInfo());
            System.out.println("=======================================");
            System.out.println(infoService.getInfo());
            System.out.println("=======================================");
        };
    }
}
