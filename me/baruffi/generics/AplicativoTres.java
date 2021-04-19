package me.baruffi.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.baruffi.generics.enums.PokemonStarterTypeEnum;
import me.baruffi.generics.interfaces.IAplicativo;
import me.baruffi.generics.interfaces.IHabilidade;
import me.baruffi.generics.interfaces.IPokemonBase;
import me.baruffi.generics.model.Ataque;
import me.baruffi.generics.model.Modificador;
import me.baruffi.generics.model.PokemonTres;

public class AplicativoTres implements IAplicativo {
    private final List<PokemonTres<PokemonStarterTypeEnum>> starters;

    public AplicativoTres() {
        Map<String, Ataque<IPokemonBase>> ataques = new HashMap<>();
        ataques.put("Ataque Teste", new Ataque<>(null, 10, 1));

        Map<String, Modificador<IPokemonBase>> modificadores = new HashMap<>();
        modificadores.put("Modificador Teste", new Modificador<>(null, "Teste", 2));

        List<PokemonTres<PokemonStarterTypeEnum>> starters = new ArrayList<>();
        starters.add(new PokemonTres<>("Bulbassauro", 10, 10, List.of(PokemonStarterTypeEnum.GRASS), ataques,
                modificadores));
        starters.add(
                new PokemonTres<>("Charmander", 10, 10, List.of(PokemonStarterTypeEnum.WATER), ataques, modificadores));
        starters.add(
                new PokemonTres<>("Squirtle", 10, 10, List.of(PokemonStarterTypeEnum.FIRE), ataques, modificadores));

        this.starters = Collections.unmodifiableList(starters);
    }

    @Override
    public void execute() {
        System.out.println("AplicativoTres");

        for (PokemonTres<PokemonStarterTypeEnum> pokemon : starters) {
            System.out.println("Pokemon: " + pokemon);

            List<IHabilidade<IPokemonBase>> habilidades = pokemon.getHabilidades();

            for (IHabilidade<IPokemonBase> habilidade : habilidades) {
                System.out.println("Habilidade: " + habilidade);

                for (PokemonTres<PokemonStarterTypeEnum> outroPokemon : starters) {
                    if (!pokemon.equals(outroPokemon)) {
                        System.out.println(pokemon + " vs " + outroPokemon);

                        habilidade.use(outroPokemon);

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
}
