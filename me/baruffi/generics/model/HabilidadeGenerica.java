package me.baruffi.generics.model;

import me.baruffi.generics.interfaces.IHabilidade;

public class HabilidadeGenerica<T> implements IHabilidade<T> {

    @Override
    public void use(T alvo) {
        String mensagem = "Habilidade generica executada com alvo: " + alvo;

        System.out.println(mensagem);
    }

    @Override
    public String toString() {
        return String.format("HabilidadeGenerica []");
    }
}
