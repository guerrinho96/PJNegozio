
package pjnegozio;

import java.io.*;
import java.util.*;
import java.text.*;
import javax.swing.*;

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
        String path ="negozio.txt";
        File file = new File(path);
        try {
            if (file.exists())
                System.out.println("Il file " + path + " esiste");
            else if (file.createNewFile())
                System.out.println("Il file " + path + " è stato creato");
            else
                System.out.println("Il file " + path + " non può essere creato");
            }
        catch (IOException e) {
            e.printStackTrace();
        }
        Negozio n = Negozio.getInstance();
        try {
            n.getFromFile(path);
        }
        catch(FileNotFoundException f) {
                
        }
        catch(ParseException p){
        }
        boolean quit=true;
        Scanner in= new Scanner(System.in);
        while(quit){
            int scelta;
            System.out.println("Cosa si desidera fare?\n "
                               + "1:Inserire nome negozio\n "
                               + "2:Aggiungere un dipendente\n"
                               + " 3:Aggiungere un prodotto\n"
                               + " 4:Eliminare un dipendente\n"
                               + " 5:Eliminare un prodotto\n"
                               + " 6:Operare nel magazzino\n"
                               + " 7:Salvare\n"
                               + " 8:Quit.");
            scelta = in.nextInt();
            switch(scelta){
                case 1:
                    System.out.println("Nome negozio?");
                    String s = in.next();
                    n.setNome(s);
                    break;
                case 2:
                    System.out.println("Nome?");
                    String name = in.next();
                    System.out.println("Cognome?");
                    String cog = in.next();
                    System.out.println("Data di nascità (gg/mm/aaaa)?");
                    String data = in.next();
                    DateFormat df = new SimpleDateFormat("dd/M/yyyy");
                    df.setLenient(false);
                    Date dat= df.parse(data);
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(dat);
                    System.out.println("Telefono?");
                    String tel = in.next();
                    System.out.println("Indirizzo?");
                    String ind = in.next();
                    System.out.println("Numero civico?");
                    int nc = in.nextInt();
                    System.out.println("Impiegato[i] o fornitore[f]?");
                    String dip = in.next();
                    System.out.println("Ruolo/Riferimento?");
                    String r = in.next();
                    if(dip.equals("i")){
                        Impiegato imp = new Impiegato(name,cog,cal,tel,ind,nc,r);
                        n.addDipendente(imp);
                        System.out.print("Totale dipendenti: ");
                        System.out.println(n.totDipendenti());
                        n.getDipendenti();
                    }
                    else{
                        Fornitore fo= new Fornitore(name,cog,cal,tel,ind,nc,r);
                        n.addDipendente(fo);
                    }
                    break;
                case 3:
                    System.out.println("Nome?");
                    String namep = in.next();
                    System.out.println("Marca?");
                    String marc = in.next();
                    System.out.println("Data di scadenza (gg/mm/aaaa)?");
                    String datas = in.next();
                    DateFormat dfs = new SimpleDateFormat("dd/M/yyyy");
                    dfs.setLenient(false);
                    Date dats= dfs.parse(datas);
                    Calendar cals = Calendar.getInstance();
                    cals.setTime(dats);
                    System.out.println("Quantità");
                    int q = in.nextInt();
                    System.out.println("Prezzo?");
                    double pr = in.nextDouble();
                    Prodotto p = new Prodotto(namep,marc,cals,q,pr);
                    n.addProdotto(p);
                    }
                    break;    
            }
        }
        
}
