package me.baruffi.generics;

import me.baruffi.generics.interfaces.IAplicativo;

public final class App {
    private static IAplicativo aplicativo;

    public static void main(String[] args) {
        aplicativo = new AplicativoUm();

        aplicativo.execute();

        aplicativo = new AplicativoDois();

        aplicativo.execute();

        aplicativo = new AplicativoTres();

        aplicativo.execute();

        aplicativo = new AplicativoQuatro();

        aplicativo.execute();
    }
}
