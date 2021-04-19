package me.baruffi.generics.interfaces;

public interface IPokemonQuatro<T_Tipo extends Enum<T_Tipo>> extends IPokemonTipado<T_Tipo> {

    public <T_Alvo extends IPokemonBase> void useHabilidade(String nome, T_Alvo alvo, Class<T_Alvo> clazz);

    public <T_Alvo extends IPokemonBase> void useHabilidades(T_Alvo alvo, Class<T_Alvo> clazzAlvo);
}
