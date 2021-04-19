package br.com.liax.mm;

import br.com.liax.mm.interfaces.IAplicativo;

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
