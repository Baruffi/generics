package me.baruffi.generics.interfaces;

import java.util.List;

public interface IPokemonTipado<T extends Enum<T>> extends IPokemonBase {

    public List<T> getTipos();
}
