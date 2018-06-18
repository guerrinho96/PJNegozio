
package pjnegozio;

import java.util.*;
import java.text.*;
/** <i><b> Classe Prodotto.</b> <br>
 *La classe prodotto definisce dei prodotti caratterizzati da:
 * <ul><li> Nome</li> <li>Marca(produttore)</li> <li>Data di scadenza</li> <li>Quantità</li><li>Prezzo.</li></ul>
 * <p>Non si è ritenuto necessario aggiungere il set per gli attributi nome, marca, datascadenza in
 * quanto una volta creati oggetti con questi parametri rimangono fissi e non devono essere modificati.</i>
 * @author Oscar
 */
public class Prodotto {
    private String nome;
    private String marca;
    private Calendar datascadenza;
    private int quantità;
    private double prezzo;
    /**
    * Costruttore che crea un prodotto con tutte le sue caratteristiche.
    * @param n nome del prodotto
    * @param m marca del prodotto
    * @param d data di scadenza del prodotto
    * @param q quantità del prodotto
    * @param pr prezzo del prodotto 
    */
    public Prodotto(String n, String m, Calendar d, int q, double pr){
        this.nome=n;
        this.marca=m;
        this.datascadenza=d;
        this.setQuantità(q);
        this.setPrezzo(pr);
    }
    /**
     * Questo metodo restituisce il nome del negozio.
     * @return nome del negozio
     */
    public String getNome(){
        return this.nome;
    }
    /**
     * Questo metodo restituisce la marca del prodotto.
     * @return marca del prodotto
     */
    public String getMarca() {
        return this.marca;
    }
    /**
     * Questo metodo restituisce la data di scadenza del prodotto in un stringa.
     * @return data di scadenza prodotto [string]
     */
    public String getDatascadenza() {
        DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        String sd= d.format(datascadenza.getTime());
        return sd;
    }
    /**
     * Questo metodo restituisce la data di scadenza del prodotto in formato Calendar.
     * @return data in formato Calendar
     */
    public Calendar getDatascadenzabyCal() {
        return this.datascadenza;
    }
    /**
     * Questo metodo restituisce la quantità del prodotto.
     * @return quantità del prodotto
     */
    public int getQuantità() {
        return this.quantità;
    }
    /**
     * Questo metodo permette di cambiare la quantità del prodotto.
     * @param q nuova quantità
     * @throws IllegalArgumentException se la quantità è minore o uguale a 0
     */
    public void setQuantità(int q) throws IllegalArgumentException {
        if(q<=0) throw new IllegalArgumentException("Quantità negativa");
        else this.quantità = q;
    }
    /**
     * Questo metodo restituisce il prezzo del prodotto.
     * @return prezzo del prodotto
     */
     public double getPrezzo() {
        return this.prezzo;
    }/**
     * Questo metodo permette di cambiare il prezzo del prodotto.
     * @param p nuovo prezzo
     * @throws IllegalArgumentException se il prezzo è minore o uguale a 0
     */
    public void setPrezzo(double p) throws IllegalArgumentException{
        if(p<=0) throw new IllegalArgumentException("Prezzo negativo");
        else this.prezzo = p;
    }/**
     * Questo metodo permette di stampare le informazioni del prodotto.
     * @return informazioni del prodotto
     */
    @Override
    public String toString(){
        DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        String sd= d.format(datascadenza.getTime());
        return  nome+" "+marca+" "+sd+" "+quantità+" "+prezzo+" ";
    }
    /**
     * Questo metodo permette di stampare le informazioni del prodotto.
     * @return  informazioni del prodotto
     */
    public String printProdotto(){
        DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        String sd= d.format(datascadenza.getTime());
        return "Prodotto: \n"+nome+" "+marca+"\ndata scadenza: "+sd+"\nquantità: "+quantità+"\nprezzo(€): "+prezzo;
    }
}
    
    
