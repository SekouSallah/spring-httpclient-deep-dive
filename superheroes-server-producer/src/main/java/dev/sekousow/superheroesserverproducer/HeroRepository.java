package dev.sekousow.superheroesserverproducer;

import org.springframework.http.HttpStatus;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author Sékou Sallah Sow <sowsekou@hotmail.com>
 */
public record HeroRepository(MultiValueMap<String, Hero> heroes) {

    private final static Predicate<Hero> HEROES_PREDICATE = hero -> Hero.HeroAlignment.VILLAIN.equals(hero.alignment());
    private final static Predicate<Hero> CHAOTICS_PREDICATE = hero -> Hero.HeroAlignment.CHAOTIC.equals(hero.alignment());
    private final static Predicate<Hero> VILLAINS_PREDICATE = hero -> Hero.HeroAlignment.VILLAIN.equals(hero.alignment());

    public HeroRepository(MultiValueMap<String, Hero> heroes) {
        this.heroes = new LinkedMultiValueMap<>(heroes);
    }

    private List<Hero> getOrDefault(Predicate<Hero> alignment) {
        return this.heroes.asSingleValueMap()
                .values().stream()
                .filter(alignment)
                .toList();
    }

    public List<Hero> getHeroes() {
        return getOrDefault(HEROES_PREDICATE);
    }

    public List<Hero> getVillains() {
        return getOrDefault(VILLAINS_PREDICATE);
    }

    public List<Hero> getChaotics() {
        return getOrDefault(CHAOTICS_PREDICATE);
    }

    public Hero getHero(String id) {
        Hero hero = this.heroes.getFirst(id);
        if (hero == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return hero;
    }
}
