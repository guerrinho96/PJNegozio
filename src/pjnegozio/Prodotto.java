
package pjnegozio;

/**
 * @author Oscar
 */
import java.util.*;
/** <b> Classe Prodotto.</b> <br>
 *La classe prodotto permette di generare oggetti di tipo prodotto caratterizzati da:
 * <ul><li> Nome</li> <li>Produttore(Marca)</li> <li>Data di scadenza</li> <li>Quantità del prodotto.</li></ul>
 * <p>La classe prodotto è composta unicamente dai metodi del costruttore, get, set e toString.
 * Non si è ritenuto necessario aggiungere il set per gli attributi nome, prduttore, datascadenza in
 * quanto una volta creati oggetti con questi parametri rimangono fissi e non devono essere modificati.
 * 
 */
public class Prodotto {
    //Attributi
    private String nome;
    private String marca;
    private Date datascadenza;
    private int quantità;
    private double prezzo;
    //Metodi
    //Costruttore
    public Prodotto(String n, String m, Date d, int q, double pr){
        nome=n;
        marca=m;
        datascadenza=d;
        quantità=q;
        prezzo=pr;
    }
    
    //Getter&Setter
    public String getNome(){
        return nome;
    }
    public String getMarca() {
        return marca;
    }
    public Date getDatascadenza() {
        return datascadenza;
    }
    public int getQuantità() {
        return quantità;
    }
    public void setQuantità(int q) {
        this.quantità = q;
    }
     public double getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(int p) {
        this.prezzo = p;
    }
    @Override
    public String toString() {
        return  "Prodotto{" + "nome=" + nome + ", produttore=" + marca +
                ", datascadenza=" + datascadenza + ", quantità=" + quantità + '}';
    }
    
    
}
    
    
