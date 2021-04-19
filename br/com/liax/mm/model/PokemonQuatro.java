package br.com.liax.mm.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.liax.mm.helpers.AplicaVantagensHelper;
import br.com.liax.mm.interfaces.IHabilidade;
import br.com.liax.mm.interfaces.IPokemonBase;
import br.com.liax.mm.interfaces.IPokemonQuatro;
import br.com.liax.mm.interfaces.IPokemonTipado;

public class PokemonQuatro<T_Tipo extends Enum<T_Tipo>> implements IPokemonQuatro<T_Tipo> {
    private final String nome;
    private final List<T_Tipo> tipos;
    private int hp;
    private int pp;
    private List<String> modificadores = new ArrayList<>();
    private final Map<String, IHabilidade<IPokemonBase>> habilidades = new HashMap<>();
    private final Class<T_Tipo> clazzTipo;

    public PokemonQuatro(String nome, int hp, int pp, List<T_Tipo> tipos, Map<String, Ataque<IPokemonBase>> ataques,
            Map<String, Modificador<IPokemonBase>> modificadores, Class<T_Tipo> clazzTipo) {
        this.nome = nome;
        this.tipos = tipos;
        this.hp = hp;
        this.pp = pp;
        this.clazzTipo = clazzTipo;

        for (String identificador : ataques.keySet()) {
            Ataque<IPokemonBase> ataque = ataques.get(identificador);

            this.habilidades.put(identificador, new Ataque<>(this, ataque));
        }

        for (String identificador : modificadores.keySet()) {
            Modificador<IPokemonBase> modificador = modificadores.get(identificador);

            this.habilidades.put(identificador, new Modificador<>(this, modificador));
        }
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public List<T_Tipo> getTipos() {
        return tipos;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public int getPp() {
        return pp;
    }

    @Override
    public void setPp(int pp) {
        this.pp = pp;
    }

    @Override
    public List<String> getModificadores() {
        return Collections.unmodifiableList(modificadores);
    }

    @Override
    public void addModificador(String modificador) {
        this.modificadores.add(modificador);
    }

    @Override
    public <T_Alvo extends IPokemonBase> void useHabilidade(String nome, T_Alvo alvo, Class<T_Alvo> clazz) {
        IHabilidade<IPokemonBase> habilidade = habilidades.get(nome);

        aplicarVantagens(alvo, clazz);

        habilidade.use(alvo);
    }

    @Override
    public <T_Alvo extends IPokemonBase> void useHabilidades(T_Alvo alvo, Class<T_Alvo> clazz) {
        aplicarVantagens(alvo, clazz);

        for (IHabilidade<IPokemonBase> habilidade : habilidades.values()) {
            habilidade.use(alvo);
        }
    }

    private <T_Alvo extends IPokemonBase> void aplicarVantagens(T_Alvo alvo, Class<T_Alvo> clazz) {
        if (IPokemonTipado.class.isAssignableFrom(clazz)) {
            try {
                IPokemonTipado<?> alvoTipado = IPokemonTipado.class.cast(alvo);
                List<T_Tipo> tiposAlvo = alvoTipado.getTipos().stream().map(tipoAlvo -> clazzTipo.cast(tipoAlvo))
                        .collect(Collectors.toList());

                for (T_Tipo tipoAlvo : tiposAlvo) {
                    for (T_Tipo tipo : this.tipos) {
                        if (AplicaVantagensHelper.temVantagem(tipo, tipoAlvo, clazzTipo)) {
                            this.addModificador("Vantagem");
                            alvo.addModificador("Desvantagem");
                        }

                        if (AplicaVantagensHelper.temVantagem(tipoAlvo, tipo, clazzTipo)) {
                            this.addModificador("Desvantagem");
                            alvo.addModificador("Vantagem");
                        }
                    }
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("Pokemons de tipos incompatíveis!", e);
            }
        }
    }

    @Override
    public String toString() {
        return nome;
    }
}
