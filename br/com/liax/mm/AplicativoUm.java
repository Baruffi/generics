package br.com.liax.mm;

import java.util.HashMap;
import java.util.Map;

import br.com.liax.mm.interfaces.IAplicativo;
import br.com.liax.mm.model.PokemonUm;

public class AplicativoUm implements IAplicativo {
    private final String primeiraHabilidade = "Primeira habilidade";
    private final String segundaHabilidade = "Segunda habilidade";
    private final String terceiraHabilidade = "Terceira habilidade";

    private final PokemonUm pokemon;

    public AplicativoUm() {
        Map<String, String> habilidades = new HashMap<>();
        habilidades.put(primeiraHabilidade, "Habilidade 1");
        habilidades.put(segundaHabilidade, "Habilidade 2");
        habilidades.put(terceiraHabilidade, "Habilidade 3");

        pokemon = new PokemonUm("Pikachu", 10, 10, habilidades);
    }

    @Override
    public void execute() {
        System.out.println("AplicativoUm");
        System.out.println("Pokemon: " + pokemon);
        System.out.println("Habilidades: " + pokemon.getHabilidades());

        System.out.println(primeiraHabilidade + ": " + pokemon.getHabilidade(primeiraHabilidade));
        System.out.println(segundaHabilidade + ": " + pokemon.getHabilidade(segundaHabilidade));
        System.out.println(terceiraHabilidade + ": " + pokemon.getHabilidade(terceiraHabilidade));

        System.out.println("Habilidade inválida: " + pokemon.getHabilidade("Habilidade inválida"));
    }
}
