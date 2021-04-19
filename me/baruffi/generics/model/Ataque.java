package me.baruffi.generics.model;

import me.baruffi.generics.interfaces.IHabilidade;
import me.baruffi.generics.interfaces.IPokemonBase;

public class Ataque<T extends IPokemonBase> implements IHabilidade<T> {
    private final T dono;
    private final int dano;
    private final int pp;

    public Ataque(T dono, int dano, int pp) {
        this.dono = dono;
        this.dano = dano;
        this.pp = pp;
    }

    public Ataque(T dono, Ataque<T> outro) {
        this.dono = dono;
        this.dano = outro.getDano();
        this.pp = outro.getPp();
    }

    @Override
    public void use(T target) {
        int ppRestante = dono.getPp() - pp;

        dono.setPp(ppRestante);

        int hpRestante = target.getHp() - dano;

        target.setHp(hpRestante);
    }

    public int getDano() {
        return dano;
    }

    public int getPp() {
        return pp;
    }

    @Override
    public String toString() {
        return String.format("Ataque [dano=%s, dono=%s, pp=%s]", dano, dono, pp);
    }
}
