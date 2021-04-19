package br.com.liax.mm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.liax.mm.interfaces.IAplicativo;
import br.com.liax.mm.interfaces.IHabilidade;
import br.com.liax.mm.model.HabilidadeGenerica;
import br.com.liax.mm.model.PokemonDois;

public class AplicativoDois implements IAplicativo {
    private final PokemonDois pokemon;

    public AplicativoDois() {
        Map<String, IHabilidade<String>> habilidades = new HashMap<>();
        habilidades.put("Teste 1", new HabilidadeGenerica<>());

        pokemon = new PokemonDois("Pikachu", 10, 10, habilidades);
    }

    @Override
    public void execute() {
        List<IHabilidade<String>> habilidades = pokemon.getHabilidades();

        System.out.println("AplicativoDois");
        System.out.println("Pokemon: " + pokemon);
        System.out.println("Habilidades: " + habilidades);

        for (IHabilidade<String> habilidade : habilidades) {
            habilidade.use("Teste");
            habilidade.use(pokemon.toString());
            habilidade.use(habilidade.toString());
        }
    }
}
