/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

/**
 *
 * @author laurikin
 */
public abstract class Komento {
    protected final Sovelluslogiikka sovellus;
    protected int edellinenArvo;

    public Komento(Sovelluslogiikka sovellus) {
        this.sovellus = sovellus;
    }

    public void suorita(int operandi) {
        edellinenArvo = sovellus.tulos();
    }

    public void peru() {
        sovellus.nollaa();
        sovellus.plus(edellinenArvo);
    }

}

