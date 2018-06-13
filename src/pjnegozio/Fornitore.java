
package pjnegozio;
/**
 * @author Oscar
 */
import java.util.*;

/**Classe Fornitore
 * La classe fornitore è una sottoclasse di Dipendente. L'attributo riferimento va ad indicare il nome della
 * fabbrica dove prende i prodotti fornisce al negozio.
 */
public class Fornitore extends Dipendente{
    //Attributi
    private String riferimento; //Nome della fabbrica da dove prende i prodotti
    public Fornitore(String n, String c, Date d, String t, String i, int nc, String r) {
        super(n, c, d, t, i, nc);
        riferimento=r;
    }
    public String getRiferimento() {
        return riferimento;
    }
    public void setRiferimento(String r) {
        this.riferimento = r;
    }
    //toString
    @Override
    public String toString() {
        return "Fornitore "+super.toString()+" "+riferimento;
    }
    
    
}
