
package pjnegozio;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**<i><b>Classe Negozio</b> <br>
 * La classe Negozio ha al suo interno informazioni sul nome, i dipendenti, e il magazzino.<br>
 * Il costruttore è dichiarato privato in quanto questa classe deve generare un unica istanza, 
 * il metodo "getInstance" avrà il compito di accedere al costruttore del negozio.</i>
 * @author Oscar
 */
public class Negozio {
    private static Negozio istanza;
    private String nome;
    private ArrayList<Dipendente> dipendenti;
    private ArrayList<Prodotto> magazzino; 
    
    /**
     * Costruttore di default che inizializza le due liste utilizzate dipendenti e magazzino
     * e permette di inserire il nome del negozio.
     */
    private Negozio(){
        this.nome=new String();
        this.dipendenti = new ArrayList<Dipendente>();
        this.magazzino = new ArrayList<Prodotto>();
        
    }
    /**
     * Questo metodo ritorna l'istanza del negozio, se l'istanza non è ancora stata creata ne crea una nuova attraverso il costruttore.
     * @return istanza del negozio.
     */
    public static Negozio getInstance(){
    if (istanza == null)
    {
      istanza = new Negozio();
    }
    return istanza; 
  }
    /**
     * Questo metodo restituisce il nome del negozio.
     * @return il nome del negozio.
     */
    public String getNome() {
        return this.nome;
    }
    /**
     * Questo metodo permette di cambiare il nome del negozio.
     * @param n nome del negozio.
     */
    public void setNome(String n) {
        this.nome = n;
    }
    /**
     * Questo metodo restituisce la lista di dipendenti del negozio.
     * @return dipendenti del negozio. 
     */
    public ArrayList<Dipendente> getDipendenti() {
        return this.dipendenti;
    }
    /**
     * Questo metodo restituisce l'inventario del magazzino.
     * @return i prodotti presenti nel magazino.
     */
    public ArrayList<Prodotto> getMagazzino() {
        return this.magazzino;
    }
    /**
     * Questo metodo restituisce l'i-esimo prodotto all'interno del magazzino.
     * @param i posizione del prodotto.
     * @return prodotto richiesto.
     * @throws IllegalArgumentException se la posizione è negativa o più grande della lunghezza della lista
     */
    public Prodotto getProdotto(int i) throws IllegalArgumentException{
        if(i>=magazzino.size() || i<0) throw new IllegalArgumentException();
        else return this.magazzino.get(i);
    }
    /**
     * Questo metodo restituisce l'i-esimo dipendente del negozio.
     * @param i posizione del dipendente.
     * @return dipendente richiesto.
     * @throws IllegalArgumentException se la posizione è negativa o più grande della lunghezza della lista
     */
    public Dipendente getDipendente(int i) throws IllegalArgumentException{
        if(i>=dipendenti.size() || i<0) throw new IllegalArgumentException();
        else return this.dipendenti.get(i);
    }
    /**
     * Questo metodo permette di aggiungere un dipendente alla lista dipendenti.
     * @param d dipendente che va aggiunto alla lista.
     */        
    public void addDipendente(Dipendente d){
        this.dipendenti.add(d);
    }
    /**
     * Questo metodo permette di aggiungere un prodotto nel magazzino.
     * @param p prodotto che si vuole inserire.
     */
    public void addProdotto(Prodotto p){
        this.magazzino.add(p);
    }
    /**
     * Questo metodo permette di licenziare l'i-esimo dipendente.
     * @param i posizione del dipendente.
     * @throws IllegalArgumentException se la posizione è negativa o più grande della lunghezza della lista
     */
    public void deleteDipendente(int i) throws IllegalArgumentException{
        if(i>=this.dipendenti.size() || i<0) throw new IllegalArgumentException();
        this.dipendenti.remove(i);
    }
    /**
     * Questo metodo permette di eliminare l'i-esimo prodotto dal magazzino.
     * @param i posizione prodotto.
     * @throws IllegalArgumentException se la posizione è negativa o più grande della lunghezza della lista
     */
    public void deleteProdotto(int i) throws IllegalArgumentException{
        if(i>=this.magazzino.size() || i<0) throw new IllegalArgumentException();
        else this.magazzino.remove(i);
    }
    /**
     * Questo metodo permette di eliminare un prodotto dal suo nome.
     * @param n nome del prodotto che si vuole eliminare
     * @return vero/falso in base al risultato della funzione.
     */
    public boolean delateProdotto(String n){
        boolean r=false;
        for(int i=0; i<magazzino.size();i++){
            Prodotto p= magazzino.get(i);
            if(p.getNome().equals(n))
                magazzino.remove(i);
                r=true;
                i=magazzino.size();//Così facendo viene eliminato il primo prodotto nell'array che ha quel nome
        }
        return r;
    }
    /**
     * Questo metodo permette di eliminare un dipendente data la sua matricola.
     * @param m matricola del dipendente.
     * @return vero/falso in base al risultato della funzione.
     */
    public boolean delateDipendente(int m){
        boolean r=false;
        for(int i=0; i<dipendenti.size();i++){
            Dipendente d= dipendenti.get(i);
            if(d.matricola==m){
                dipendenti.remove(i);
                r=true;
                i=dipendenti.size(); //quando si trova il dipendente si esce dal ciclo
            }
        }
        return r;
    }
    /**
     * Questo metodo restituisce il numero totale di prodotti nel magazzino.
     * @return totale prodotti
     */
    public int totMagazzino(){
        return this.magazzino.size();
    }
    /**
     * Questo metodo restituisce il numero totale di dipendenti del negozio
     * @return totale dipendenti.
     */
    public int totDipendenti(){
        return this.dipendenti.size();
    }
    
    /*public void controllaScadenza(){
        Date d = new Date();
        for(int i=0; i<magazzino.size();i++){
            Prodotto p= magazzino.get(i);
            if(p.getDatascadenza()< d )
        }
    }*/
    /**
     * Questo metodo permette di stampare una stringa contenente le informazioni del negozio
     * @return informazioni negozio (string)
     */
    @Override
    public String toString(){
        String s=this.nome+" "+magazzino.size()+" ";
        for(Prodotto p : this.magazzino) s+=p.toString();
        s+=dipendenti.size()+" ";
        for(Dipendente d : this.dipendenti)
            s+=d.toString();
        return s;
    }
    
    
 
}
