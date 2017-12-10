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
public abstract class KaksiparametrinenLaskuoperaatio implements Komento {

    private JTextField tuloskentta;
    private JTextField syotekentta;
    private Sovelluslogiikka sovellus;
    private int edellinenArvo;

    public KaksiparametrinenLaskuoperaatio(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.syotekentta = syotekentta;
        this.tuloskentta = tuloskentta;
        edellinenArvo = sovellus.tulos();
    }

    @Override
    public void suorita() {
        int arvo = 0;

        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }

        edellinenArvo = sovellus.tulos();

        this.laske(sovellus, arvo);

        paivitaNaytonKentat();
    }

    protected abstract void laske(Sovelluslogiikka sovellus, int arvo);

    @Override
    public void peru() {
        sovellus.palauta(this.edellinenArvo);
        paivitaNaytonKentat();
    }

    private void paivitaNaytonKentat() {
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
    }

}
