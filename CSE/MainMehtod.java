public class MainMehtod {
    public static void main(String[] args) {
        Pokemon pikachu = new Pokemon("pikachu");

        PokemonSelection kumi = new PokemonSelection();
        kumi.intro(pikachu);

        String[] pokemonSkill = new String[2];
        pokemonSkill[0] = "Thunder Punch";
        pokemonSkill[1] = "Rock Smash";
        PokemonGO pika = new PokemonGO("Pikachu", pokemonSkill);
        pika.seize("Pikachu", pokemonSkill);
    }
}