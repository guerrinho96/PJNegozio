
package pjnegozio;

import java.util.Date;

/**
 * @author Oscar
 */
import java.util.*;
/**
 * Classe Impiegato
 * La classe operaio è una sottoclasse di Dipendente. Il ruolo indica la manzione all'interno del negozio.
 */
public class Impiegato extends Dipendente {
    //Attributi
    private String ruolo;
    //Metodi
    //Costruttore
    public Impiegato(String n, String c, Date d, String t, String i, int nc, String r) {
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
        return "Operaio{ "+nome+" "+cognome + ", matricola=" + matricola + ", ruolo=" + ruolo + '}';
    }

}