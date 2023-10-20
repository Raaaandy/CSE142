import java.util.*;

public class PokemonGO {
    private HashMap<String, HashSet<String>> pokemon;

    public PokemonGO(String pokemonName, String[] skills) {
        if (skills.length < 1) {
            throw new IllegalArgumentException();
        }
        Random randy = new Random();
        this.pokemon = new HashMap<>();
        putPokemonInBag(pokemonName, skills);
    }

    public void seize(String pokemonName, String[] skills) {
        if(!pokemon.containsKey(pokemonName)) {
            putPokemonInBag(pokemonName, skills);
        } else {
            System.out.println("You have one same pokemon in your bag!");
            System.out.println("Please leave some pokemon for others.");
        }
    }

    public void fight(String pokemonName, Random randy) {
        if(!pokemon.containsKey(pokemonName)) {
            System.out.println("You don't have this pokemon");
            System.out.println("But you can seize it!");
        } else {
            int hurt = randy.nextInt(100) + 1;
            System.out.println("Your pokemon creates " + hurt + " !");
        }
    }

    private void putPokemonInBag(String pokemonName, String[] skills) {
        pokemon.put(pokemonName, new HashSet<String>());
        for (int i = 0; i < skills.length; i++) {
            pokemon.get(pokemonName).add(skills[i]);
        }
    }

}