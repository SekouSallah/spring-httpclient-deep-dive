package dev.sekousow.superheroesserverproducer;

/**
 * @author Sékou Sallah Sow <sowsekou@hotmail.com>
 */
public record Hero(
        String heroName,

        String realName,

        HeroAlignment alignment,
        
        String favoriteGadgetName

) {
    public enum HeroAlignment {
        HERO, CHAOTIC, VILLAIN
    }
}
