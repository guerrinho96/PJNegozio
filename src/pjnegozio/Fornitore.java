
package pjnegozio;

import java.util.*;

/**<i><b>Classe Fornitore</b><br>
 * La classe Fornitore è una estensione della classe Dipendente, caraterizzata dal attributo riferimento che indica il nome della
 * fabbrica dove prende i prodotti che fornisce al negozio.</i>
 * @author Oscar
 */
public class Fornitore extends Dipendente{
    private String riferimento; //Nome della fabbrica da dove prende i prodotti
    public Fornitore(String n, String c, Calendar d, String t, String i, int nc, String r) {
        super(n, c, d, t, i, nc);
        riferimento=r;
    }
    /**
     * Questo metodo restituisce l'azienda cui fa riferimento un fornitore.
     * @return azienda di riferimento
     */
    public String getRiferimento() {
        return riferimento;
    }
    /**
     * Questo metodo permette di cambiare l'azienda di riferimento.
     * @param r nuovo riferimento
     */
    public void setRiferimento(String r) {
        this.riferimento = r;
    }
    /**
     * Questo metodo permette di stampare le informazioni del dipendente.
     * @return informazioni del dipendente
     */
    @Override
    public String toString() {
        return "Fornitore "+super.toString()+" "+riferimento;
    }
    /**
     * Questo metodo permette di stampare le informazioni del dipendente.
     * @return informazioni del dipendente
     */
    @Override
    public String printDipendente(){
        return super.printDipendente()+"\n"+riferimento+"\n";
    }
}
