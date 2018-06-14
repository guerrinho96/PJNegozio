
package pjnegozio;

import java.util.*;
import java.text.*;

/**
 * @author Oscar
 */
public class PJNegozio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        Date d = new Date("10/10/1996");
        Calendar c= Calendar.getInstance();
        c.set(1996,10,6);
        Impiegato imp = new Impiegato("Oscar", "Guerra", c, "3775036078", "Via roma", 368, "Capo Supremo");
        System.out.println(imp.printDipendente());
        Prodotto p = new Prodotto("Hamburger","Da me",c, 2, 6);
        System.out.println(p.printProdotto());
    }
    
}
