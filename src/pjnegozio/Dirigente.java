package pjnegozio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**<i><b>Classe Dirigente</b><br>
 * La classe Dirigente è una estensione della classe Dipendente, 
 * caraterizzata dal ambito di lavoro del dirigente.</i>
 * @author Oscar
 */
public class Dirigente extends Dipendente{
    private int nMission ; 
    public Dirigente(String n, String c, Calendar d, String t, String i, int nc, int m) {
        super(n, c, d, t, i, nc);
        nMission=m;
    }
    /**
     * Questo metodo restituisce il numero di missioni del dirigente.
     * @return numero di missioni
     */
    public int getNumMissioni() {
        return nMission;
    }
    /**
     * Questo metodo permette di aggiornare il numero di missioni.
     * @param m nuovo riferimento
     */
    public void setNumMissioni(int m) {
        this.nMission=m;
    }
    /**
     * Questo metodo permette di stampare le informazioni del dipendente.
     * @return informazioni del dipendente
     */
    @Override
    public String toString() {
        return "Dirigente "+super.toString()+" "+nMission+" ";
    }
    /**
     * Questo metodo permette di stampare le informazioni del dipendente.
     * @return informazioni del dipendente
     */
    @Override
    public String printDipendente(){
        DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        String sd= d.format(datanascita.getTime());
        return super.printDipendente()+"DIRIGENTE: "+nome+" "+cognome+"\nNATO IL:   "+sd+"\nRISIEDE A: "
                +indirizzo+" "+numciv+"\nTELEFONO:  "+telefono+"\nMISSIONI:  "+nMission+"\n"+"\n";
    }
}