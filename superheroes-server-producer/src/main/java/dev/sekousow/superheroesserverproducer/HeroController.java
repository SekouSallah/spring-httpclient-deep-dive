package dev.sekousow.superheroesserverproducer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Sékou Sallah Sow <sowsekou@hotmail.com>
 */
@RestController
@RequestMapping("/api/marvels")
public class HeroController {

    private final HeroRepository heroRepository;

    public HeroController(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @GetMapping("{id}")
    public Hero getHero(@PathVariable("id") String id) {
        return heroRepository.getHero(id);
    }

    @GetMapping("heroes")
    public List<Hero> getHeroes() {
        return heroRepository.getHeroes();
    }

    @GetMapping("villains")
    public List<Hero> getVillains() {
        return heroRepository.getVillains();
    }

    @GetMapping("chaotics")
    public List<Hero> getChaotics() {
        return heroRepository.getChaotics();
    }
}
