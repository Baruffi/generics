package br.com.liax.mm.interfaces;

import java.util.List;

public interface IPokemonUm<T> extends IPokemonBase {

    public T getHabilidade(String nome);

    public List<T> getHabilidades();
}
