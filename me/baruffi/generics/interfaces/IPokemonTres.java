package me.baruffi.generics.interfaces;

import java.util.List;

public interface IPokemonTres<T_Alvo extends IPokemonBase, T_Tipo extends Enum<T_Tipo>> extends IPokemonTipado<T_Tipo> {

    public IHabilidade<T_Alvo> getHabilidade(String nome);

    public List<IHabilidade<T_Alvo>> getHabilidades();
}
