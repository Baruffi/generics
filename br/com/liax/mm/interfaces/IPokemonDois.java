package br.com.liax.mm.interfaces;

import java.util.List;

public interface IPokemonDois<T> extends IPokemonBase {

    public IHabilidade<T> getHabilidade(String nome);

    public List<IHabilidade<T>> getHabilidades();
}
