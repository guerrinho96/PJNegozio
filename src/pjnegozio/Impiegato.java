
package pjnegozio;

import java.util.*;
/**
 * <i><b>Classe Impiegato<b><br>
 * La classe Impiegato è un estensione della classe Dipendente.
 * @author Oscar
 */
public class Impiegato extends Dipendente {
    //Attributi
    private String ruolo;
    //Metodi
    //Costruttore
    public Impiegato(String n, String c, Calendar d, String t, String i, int nc, String r) {
        super(n, c, d, t, i, nc);
        ruolo=r;
    }
    //Getter&Setter
    public String getRuolo() {
        return ruolo;
    }
    public void setRuolo(String r) {
        this.ruolo = r;
    }
    //toString
    @Override
    public String toString() {
        return "Impiegato "+super.toString()+" "+ruolo;
    }
    @Override
    public String printDipendente(){
        return super.printDipendente()+"\n"+ruolo;
    }

}