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
public class Erotus extends Komento {

    public Erotus(Sovelluslogiikka sovellus) {
        super(sovellus);
    }

    @Override
    public void suorita(int operandi) {
        sovellus.miinus(operandi);
    }
    
}
