
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
    public static void main(String[] args) {
        // TODO code application logic here
        String n = "Red Bull";
        String m = n;
        Calendar d = Calendar.getInstance();
        int q=10;
        double p =2;
        Prodotto pro = new Prodotto(n,m,d,q,p);
        System.out.println(pro.toString());
        System.out.println(pro.getDatascadenza());
        
    }
    
}
