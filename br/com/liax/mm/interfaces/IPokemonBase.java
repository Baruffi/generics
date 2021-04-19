package br.com.liax.mm.interfaces;

import java.util.List;

public interface IPokemonBase {

    public String getNome();

    public int getHp();

    public void setHp(int hp);

    public int getPp();

    public void setPp(int pp);

    public List<String> getModificadores();

    public void addModificador(String modificador);
}
