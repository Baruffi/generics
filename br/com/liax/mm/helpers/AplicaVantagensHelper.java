package br.com.liax.mm.helpers;

import java.util.Map;

import br.com.liax.mm.enums.PokemonLegendaryTypeEnum;
import br.com.liax.mm.enums.PokemonStarterTypeEnum;

public class AplicaVantagensHelper {
    private static final Map<PokemonStarterTypeEnum, PokemonStarterTypeEnum> vantagensStarter = Map.of(
            PokemonStarterTypeEnum.WATER, PokemonStarterTypeEnum.FIRE, PokemonStarterTypeEnum.FIRE,
            PokemonStarterTypeEnum.GRASS, PokemonStarterTypeEnum.GRASS, PokemonStarterTypeEnum.WATER);
    private static final Map<PokemonLegendaryTypeEnum, PokemonLegendaryTypeEnum> vantagensLegendary = Map.of(
            PokemonLegendaryTypeEnum.POISON, PokemonLegendaryTypeEnum.FAIRY, PokemonLegendaryTypeEnum.FAIRY,
            PokemonLegendaryTypeEnum.DARK, PokemonLegendaryTypeEnum.DARK, PokemonLegendaryTypeEnum.PSYCHIC,
            PokemonLegendaryTypeEnum.PSYCHIC, PokemonLegendaryTypeEnum.POISON);

    public static <T extends Enum<T>> boolean temVantagem(T primeiro, T segundo, Class<T> clazz) {
        if (PokemonStarterTypeEnum.class.isAssignableFrom(clazz)) {
            if (vantagensStarter.get(primeiro).equals(segundo)) {
                return true;
            }
        } else if (PokemonLegendaryTypeEnum.class.isAssignableFrom(clazz)) {
            if (vantagensLegendary.get(primeiro).equals(segundo)) {
                return true;
            }
        }

        return false;
    }
}
