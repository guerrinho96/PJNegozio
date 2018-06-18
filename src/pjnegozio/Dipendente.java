
package pjnegozio;

import java.text.*;
import java.util.*;
/** <i><b>Classe Dipendente.</b> <br>
 * La classe astratta dipendente definisce un generico dipendente caratterizato da:
 * <ul><li>Matricola identificativa</li><li>Nome</li><li>Cognome</li><li>Data di nascita</li><li>Numero di telefono</li><li>Indirizzo di residenza.</li></ul>
 * <p>Non si è ritenuto necessario aggiungere il set per gli attributi matricola, nome, cognome, datanascità in
 * quanto una volta creati oggetti con questi parametri rimangono fissi e non devono essere modificati.<br>
 * La matricola essendo identificativa deve essere unica per questo si è optato per un attributo autoincrementativo.</i>
 * @author Oscar
 */
public abstract class Dipendente {
    protected int matricola;
    protected String nome;
    protected  String cognome;
    protected  Calendar datanascita;
    protected  String telefono;
    protected  String indirizzo;
    protected  int numciv;
    protected static int nextMat=1; 
    /**
     * Costruttore che crea un dipendente con tutte le sue caratteristiche.
     * @param n nome del dipendente
     * @param c cognome del dipendente
     * @param d data di nascità del dipendente
     * @param t numero di telefono del dipendente
     * @param i indirizzo del dipendente
     * @param nc numero civico del dipendente
     */
    public Dipendente(String n, String c,Calendar d, String t, String i, int nc){
        this.nome=n;
        this.cognome=c;
        this.datanascita =d;
        this.telefono=t;
        this.indirizzo=i;
        this.setNumciv(nc);
        this.matricola=nextMat++;
    }
    /**
     * Questo metodo restituisce la matricola del dipendente.
     * @return matricola
     */
    public int getMatricola() {
        return this.matricola;
    }
    /**
     * Questo metodo restituisce il nome del dipendente.
     * @return nome del dipendente.
     */
    public String getNome() {
        return this.nome;
    }
    /**
     * Questo metodo restituisce il cognome del dipendente.
     * @return cognome del dipendente
     */
    public String getCognome() {
        return this.cognome;
    }
    /**
     * Questo metodo restituisce la data di nascita del dipendente in una stringa.
     * @return data di nascita [string]
     */
    public String getDatanascita() {
        DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        String sd= d.format(datanascita.getTime());
        return sd;
    }
    /**
     * Questo metodo restituisce la data di nascità del dipendente in formato calendar.
     * @return data di nascita [calendar]
     */
    public Calendar getDatanascitabyCal() {
        return this.datanascita;
    }
    /**
     * Questo metodo restituisce il numero di telefono del dipendente.
     * @return numero di telefono
     */
    public String getTelefono() {
        return this.telefono;
    }
    /**
     * Questo metodo permette di cambiare il numero di telefono del dipendente.
     * @param t nuovo numero di telefono 
     */
    public void setTelefono(String t) {
        this.telefono = t;
    }
    /**
     * Questo metodo restituisce l'indirizzo del dipendente.
     * @return indirizzo dipendente
     */
    public String getIndirizzo() {
        return this.indirizzo;
    }/**
     * Questo metodo permette di cambiare l'indirizzo del dipendente.
     * @param i nuovo indirizzo
     */
    public void setIndirizzo(String i) {
        this.indirizzo = i;
    }
    /**
     * Questo metodo restituisce il numero civico del dipendente.
     * @return numero civico dipendente
     */
    public int getNumciv() {
        return this.numciv;
    }
    /**
     * Questo metodo permette di cambiare il numero civico del dipendente.
     * @param nc nuovo numero civico
     * @throws IllegalArgumentException se il numero civico è minore o uguale a 0
     */
    public void setNumciv(int nc) throws IllegalArgumentException{
        if(nc<=0) throw new IllegalArgumentException("Numero civico non esistente");
        else this.numciv = nc;
    }
    /**
     * Questo metodo permette di stampare le informazioni del dipendente.
     * @return informazioni del dipendente.
     */
    @Override
    public String toString() {
        DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        String sd= d.format(datanascita.getTime());
        return  matricola+" "+nome+" "+cognome+" "+sd+" "+telefono+" "+indirizzo+" "+numciv;
    }
    /**
     * Questo metodo permette di stampare le informazioni del dipendente.
     * @return informazioni del dipendente.
     */
    public String printDipendente(){
        DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        String sd= d.format(datanascita.getTime());
        return "Dipendente numero: "+matricola+"\n"+nome+" "+cognome+"\n"+sd+"\n"+indirizzo
                +" "+numciv+"\n"+telefono;
    }
}
