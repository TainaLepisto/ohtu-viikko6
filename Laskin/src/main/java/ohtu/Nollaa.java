/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;

/**
 *
 * @author tainalep
 */
public class Nollaa extends KaksiparametrinenLaskuoperaatio {

    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        super(sovellus, tuloskentta, syotekentta);

    }

    @Override
    protected void laske(Sovelluslogiikka sovellus, int arvo) {
        sovellus.nollaa();
    }

}
