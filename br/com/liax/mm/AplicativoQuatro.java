package br.com.liax.mm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.liax.mm.enums.PokemonLegendaryTypeEnum;
import br.com.liax.mm.interfaces.IAplicativo;
import br.com.liax.mm.interfaces.IPokemonBase;
import br.com.liax.mm.model.Ataque;
import br.com.liax.mm.model.Modificador;
import br.com.liax.mm.model.PokemonQuatro;

public class AplicativoQuatro implements IAplicativo {
    private final List<PokemonQuatro<PokemonLegendaryTypeEnum>> legendaries;

    public AplicativoQuatro() {
        Map<String, Ataque<IPokemonBase>> ataques = new HashMap<>();
        ataques.put("Ataque Teste", new Ataque<>(null, 10, 1));

        Map<String, Modificador<IPokemonBase>> modificadores = new HashMap<>();
        modificadores.put("Modificador Teste", new Modificador<>(null, "Teste", 2));

        List<PokemonQuatro<PokemonLegendaryTypeEnum>> legendaries = new ArrayList<>();
        legendaries.add(new PokemonQuatro<>("Umbreon", 10, 10, List.of(PokemonLegendaryTypeEnum.DARK), ataques,
                modificadores, PokemonLegendaryTypeEnum.class));
        legendaries.add(new PokemonQuatro<>("Sylveon", 10, 10, List.of(PokemonLegendaryTypeEnum.FAIRY), ataques,
                modificadores, PokemonLegendaryTypeEnum.class));
        legendaries.add(new PokemonQuatro<>("Koffing", 10, 10, List.of(PokemonLegendaryTypeEnum.POISON), ataques,
                modificadores, PokemonLegendaryTypeEnum.class));
        legendaries.add(new PokemonQuatro<>("Espeon", 10, 10, List.of(PokemonLegendaryTypeEnum.PSYCHIC), ataques,
                modificadores, PokemonLegendaryTypeEnum.class));

        this.legendaries = Collections.unmodifiableList(legendaries);
    }

    @Override
    public void execute() {
        System.out.println("AplicativoQuatro");

        for (PokemonQuatro<PokemonLegendaryTypeEnum> pokemon : legendaries) {
            System.out.println("Pokemon: " + pokemon);

            for (PokemonQuatro<PokemonLegendaryTypeEnum> outroPokemon : legendaries) {
                if (!pokemon.equals(outroPokemon)) {
                    System.out.println(pokemon + " vs " + outroPokemon);

                    pokemon.useHabilidades(outroPokemon, PokemonQuatro.class);

                    System.out.println("Pokemon agindo: " + pokemon);
                    System.out.println(pokemon.getHp());
                    System.out.println(pokemon.getPp());
                    System.out.println(pokemon.getModificadores());

                    System.out.println("Pokemon atingido: " + outroPokemon);
                    System.out.println(outroPokemon.getHp());
                    System.out.println(outroPokemon.getPp());
                    System.out.println(outroPokemon.getModificadores());
                }
            }
        }

    }
}
