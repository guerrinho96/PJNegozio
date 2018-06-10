
package pjnegozio;

import java.util.*;

/**
 * @author Oscar
 */
public class PJNegozio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Date data1 = new Date();
        Impiegato o = new Impiegato("Nome", "Cognome",data1,"cel","ind",10,"op");
        Impiegato o2 = new Impiegato("Nome", "Cognome",data1,"cel","ind",10,"op");
        System.out.println("o: "+o.toString());
        System.out.println("o: "+o2.toString());
    }
    
}
