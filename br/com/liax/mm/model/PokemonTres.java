package br.com.liax.mm.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.liax.mm.interfaces.IHabilidade;
import br.com.liax.mm.interfaces.IPokemonBase;
import br.com.liax.mm.interfaces.IPokemonTres;

public class PokemonTres<T_Tipo extends Enum<T_Tipo>> implements IPokemonTres<IPokemonBase, T_Tipo> {
    private final String nome;
    private final List<T_Tipo> tipos;
    private int hp;
    private int pp;
    private List<String> modificadores = new ArrayList<>();
    private final Map<String, IHabilidade<IPokemonBase>> habilidades = new HashMap<>();

    public PokemonTres(String nome, int hp, int pp, List<T_Tipo> tipos, Map<String, Ataque<IPokemonBase>> ataques,
            Map<String, Modificador<IPokemonBase>> modificadores) {
        this.nome = nome;
        this.tipos = tipos;
        this.hp = hp;
        this.pp = pp;

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
    public List<IHabilidade<IPokemonBase>> getHabilidades() {
        return new ArrayList<>(habilidades.values());
    }

    @Override
    public IHabilidade<IPokemonBase> getHabilidade(String nome) {
        return habilidades.get(nome);
    }

    @Override
    public String toString() {
        return nome;
    }
}
