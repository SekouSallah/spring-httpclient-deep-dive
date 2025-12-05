package dev.sekousow.superheroesserverproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootApplication
public class ServerApplication {

    static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    public HeroRepository heroRepository() {
        MultiValueMap<String, Hero> heroes = new LinkedMultiValueMap<>();
        heroes.add("1", new Hero("Iron Man", "Tony Stark", Hero.HeroAlignment.HERO, "Arc Reactor"));
        heroes.add("2", new Hero("Spider-Man", "Peter Parker", Hero.HeroAlignment.HERO, "Web Shooter"));
        heroes.add("3", new Hero("Thor", "Thor Odinson", Hero.HeroAlignment.HERO, "Stormbreaker"));
        heroes.add("4", new Hero("Loki", "Loki Laufeyson", Hero.HeroAlignment.CHAOTIC, "Vibranium Shield"));
        heroes.add("5", new Hero("Thanos", "Thanos", Hero.HeroAlignment.VILLAIN, "Infinity Gauntlet"));
        return new HeroRepository(heroes);
    }
}
