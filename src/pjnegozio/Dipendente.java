
package pjnegozio;
/**
 * @author Oscar 
 */

import java.util.*;
/** Classe Dipendente.
 * La classe dipendente permette di generare oggetti di tipo dipenente caratterizati da:
 * Matricola identificativa, Nome, Cognome, Data di nascita, numero di telefono, indirizzo di residenza.
 * La classe dipendente è composta unicamente dai metodi del costruttore, get, set e toString.
 * Non si è ritenuto necessario aggiungere il set per gli attributi matricola, nome, cognome, datanascità in
 * quanto una volta creati oggetti con questi parametri rimangono fissi e non devono essere modificati.
 * 
 */
public abstract class Dipendente {
    //Attributi
    protected int matricola;
    protected String nome;
    protected  String cognome;
    protected  Date datanascita;
    protected  String telefono;
    protected  String indirizzo;
    protected  int numciv;
    protected static int nextMat=1;
    //Meotdi
    //Costruttore
    public Dipendente(String n, String c,Date d, String t, String i, int nc){
        nome=n;
        cognome=c;
        datanascita =d;
        telefono=t;
        indirizzo=i;
        matricola=nextMat++;
    }
    //Getter&Setter
    public int getMatricola() {
        return matricola;
    }
    public String getNome() {
        return nome;
    }
    public String getCognome() {
        return cognome;
    }
    public Date getDatanascita() {
        return datanascita;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String t) {
        this.telefono = t;
    }
    public String getIndirizzo() {
        return indirizzo;
    }
    public void setIndirizzo(String i) {
        this.indirizzo = i;
    }
    public int getNumciv() {
        return numciv;
    }
    public void setNumciv(int nc) {
        this.numciv = nc;
    }
    @Override
    public String toString() {
        return  "Dipendente{" + "Matricola=" + matricola + "nome=" + nome + ", cognome=" + cognome + 
                ", data nascità=" + datanascita + ", telefono=" + telefono + 
                ", indirizzo=" + indirizzo +" "+ numciv + '}';
    }
    
}
