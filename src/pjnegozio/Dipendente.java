
package pjnegozio;
/**
 * @author Oscar 
 */

import java.util.*;
/** <i><b>Classe Dipendente.</b> <br>
 * La classe astratta dipendente definisce un generico dipendente caratterizato da:
 * <ul><li>Matricola identificativa</li><li>Nome</li><li>Cognome</li><li>Data di nascita</li><li>Numero di telefono</li><li>Indirizzo di residenza.</li></ul>
 * <p>Non si è ritenuto necessario aggiungere il set per gli attributi matricola, nome, cognome, datanascità in
 * quanto una volta creati oggetti con questi parametri rimangono fissi e non devono essere modificati.<br>
 * La matricola essendo identificativa deve essere unica per questo si è optato per un attributo autoincrementativo.</i>
 * 
 */
public abstract class Dipendente {
    protected int matricola;
    protected String nome;
    protected  String cognome;
    protected  Date datanascita;
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
     * @throws IllegalArgumentException se il numero civico è minore o uguale a 0
     */
    public Dipendente(String n, String c,Date d, String t, String i, int nc) throws IllegalArgumentException{
        this.nome=n;
        this.cognome=c;
        this.datanascita =d;
        this.telefono=t;
        this.indirizzo=i;
        if(nc<=0) throw new IllegalArgumentException();
        else this.numciv=nc;
        this.matricola=nextMat++;
    }
    /**
     * 
     * @return 
     */
    public int getMatricola() {
        return this.matricola;
    }
    /**
     * 
     * @return 
     */
    public String getNome() {
        return this.nome;
    }
    /**
     * 
     * @return 
     */
    public String getCognome() {
        return this.cognome;
    }
    /**
     * 
     * @return 
     */
    public Date getDatanascita() {
        return this.datanascita;
    }
    /**
     * 
     * @return 
     */
    public String getTelefono() {
        return this.telefono;
    }
    /**
     * 
     * @param t 
     */
    public void setTelefono(String t) {
        this.telefono = t;
    }
    /**
     * 
     * @return 
     */
    public String getIndirizzo() {
        return this.indirizzo;
    }/**
     * 
     * @param i 
     */
    public void setIndirizzo(String i) {
        this.indirizzo = i;
    }
    /**
     * 
     * @return 
     */
    public int getNumciv() {
        return this.numciv;
    }
    /**
     * 
     * @param nc 
     */
    public void setNumciv(int nc) {
        this.numciv = nc;
    }
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return  "Dipendente{" + "Matricola=" + matricola + "nome=" + nome + ", cognome=" + cognome + 
                ", data nascità=" + datanascita + ", telefono=" + telefono + 
                ", indirizzo=" + indirizzo +" "+ numciv + '}';
    }
    
}
