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
class Nollaa extends Komento {

    public Nollaa(Sovelluslogiikka sovellus) {
        super(sovellus);
    }

    @Override
    public void suorita(int operandi) {
        sovellus.nollaa();
    }

    
}
