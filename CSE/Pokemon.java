import java.util.*;

public class Pokemon implements PokemonHabit{
    private String name;

    public Pokemon(String pokemonName) {
        this.name = pokemonName;
    }

    public void food() {
        System.out.println("The food I like is apple!");
    }

    @Override
    public void intro() {
        System.out.println("I am " + name + " !");
        System.out.println("I like storming weather!");
    }
}