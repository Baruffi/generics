package me.baruffi.generics.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import me.baruffi.generics.interfaces.IHabilidade;
import me.baruffi.generics.interfaces.IPokemonDois;

public class PokemonDois implements IPokemonDois<String> {
    private final String nome;
    private int hp;
    private int pp;
    private List<String> modificadores = new ArrayList<>();
    private final Map<String, IHabilidade<String>> habilidades;

    public PokemonDois(String nome, int hp, int pp, Map<String, IHabilidade<String>> habilidades) {
        this.nome = nome;
        this.hp = hp;
        this.pp = pp;

        this.habilidades = habilidades;
    }

    @Override
    public String getNome() {
        return nome;
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
    public List<IHabilidade<String>> getHabilidades() {
        return new ArrayList<>(habilidades.values());
    }

    @Override
    public IHabilidade<String> getHabilidade(String nome) {
        return habilidades.get(nome);
    }

    @Override
    public String toString() {
        return nome;
    }
}
