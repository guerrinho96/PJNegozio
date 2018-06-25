
package pjnegozio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * <i><b>Classe Impiegato</b><br>
 * La classe Impiegato è un estensione della classe Dipendente ed è caratterizzata dal ruolo del dipendente all'interno del negozio.</i>
 * @author Oscar
 */
public class Impiegato extends Dipendente {
    private String ruolo;
    /**
     * Il costruttore si riferisce al costruttore di dipendente con l'aggiunta del ruolo.
     * @param n nome
     * @param c cognome
     * @param d data di nascità
     * @param t numero di telefono
     * @param i indirizzo
     * @param nc numero civico
     * @param r ruolo
     */
    public Impiegato(String n, String c, Calendar d, String t, String i, int nc, String r) {
        super(n, c, d, t, i, nc);
        ruolo=r;
    }
    /**
     * Questo metodo restituisce il ruolo del dipendente.
     * @return ruolo dipendente
     */
    public String getRuolo() {
        return ruolo;
    }
    /**
     * Questo metodo permette di cambiare il ruolo ad un dipendente.
     * @param r nuovo ruolo
     */
    public void setRuolo(String r) {
        this.ruolo = r;
    }
    /**
     * Questo metodo permette di stampare le informazioni del dipendente.
     * @return informazioni del dipendente
     */
    @Override
    public String toString() {
        return "Impiegato "+super.toString()+" "+ruolo+" ";
    }
    /**
     * Questo metodo permette di stampare le informazioni del dipendente.
     * @return informazioni dipendente
     */
    @Override
    public String printDipendente(){
        DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        String sd= d.format(datanascita.getTime());
        return super.printDipendente()+"IMPIEGATO: "+nome+" "+cognome+"\nNATO IL:   "+sd+"\nRISIEDE A: "
                +indirizzo+" "+numciv+"\nTELEFONO:  "+telefono+"\nRUOLO:     "+ruolo+"\n"+"\n";
    }
}