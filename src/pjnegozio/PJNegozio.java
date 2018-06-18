
package pjnegozio;

import java.io.*;
import java.util.*;
import java.text.*;
import javax.swing.JOptionPane;

/**
 * @author Oscar
 */
public class PJNegozio {

    /**
     * @param args the command line arguments
     * @throws ParseException
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        Negozio n = Negozio.getInstance();
        File f = new File("C:../Desktop/negozio.txt");
        System.out.println(f.length());
        if(f.length()==0)
            System.out.println("Vuoto");
        else 
            System.out.println("pieno");
    }    
}
