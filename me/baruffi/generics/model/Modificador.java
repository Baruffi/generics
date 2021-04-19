package me.baruffi.generics.model;

import me.baruffi.generics.interfaces.IHabilidade;
import me.baruffi.generics.interfaces.IPokemonBase;

public class Modificador<T extends IPokemonBase> implements IHabilidade<T> {
    private final IPokemonBase dono;
    private final String modificador;
    private final int pp;

    public Modificador(IPokemonBase dono, String modificador, int pp) {
        this.dono = dono;
        this.modificador = modificador;
        this.pp = pp;
    }

    public Modificador(IPokemonBase dono, Modificador<T> outro) {
        this.dono = dono;
        this.modificador = outro.getModificador();
        this.pp = outro.getPp();
    }

    @Override
    public void use(T target) {
        int ppRestante = dono.getPp() - pp;

        dono.setPp(ppRestante);

        target.addModificador(modificador);
    }

    public String getModificador() {
        return modificador;
    }

    public int getPp() {
        return pp;
    }

    @Override
    public String toString() {
        return String.format("Modificador [dono=%s, modificador=%s, pp=%s]", dono, modificador, pp);
    }
}
