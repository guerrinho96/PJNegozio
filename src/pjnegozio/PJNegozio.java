
package pjnegozio;

import java.io.*;
import java.util.*;
import java.text.*;

/**<i><b>Classe PJNegozio</b><br>
 * La classe PJNegozio è la classe di esecuzione dove si interfaccia l'utente per gestire il negozio.<br>
 * Sono presenti diverse funzioni private che poi vengono richiamate nel main.</i>
 * @author Oscar
 */
public class PJNegozio {
    private static Negozio n = Negozio.getInstance();
    /**
     * Funzione che setta/cambia il nome del negozio.
     */
    private static void nameNeg(){
        Scanner in= new Scanner(System.in);
        System.out.println("Nome negozio?");
        String s = in.next();
        n.setNome(s);
    }
    /**
     * Funzione che permette la gestione dei dipendenti.
     * @throws ParseException 
     */
    private static void opDip() throws ParseException{
        Scanner in= new Scanner(System.in);
        boolean quit=true;
        while(quit){
            System.out.println("Cosa si desidere fare?\n"
                               + "1:Visualizzare il numero e la lista dipendenti;\n"
                               + "2:Aggiungere un dipendente;\n"
                               + "3:Licenziare un dipendente;\n"
                               + "4:Torno al menù precedente.");
            int scelta= in.nextInt();
            if(scelta==1)
                System.out.println("Il numero di dipendenti è: "+n.totDipendenti()+"\n"+n.getDipendenti());
            else if(scelta==2){
                try{
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
                    in.nextLine();
                    String ind = in.nextLine();
                            
                    System.out.println("Numero civico?");
                    int nc = in.nextInt();
                    System.out.println("Impiegato[i/I] o Fornitore[f/F]?");
                    String dip = in.next();
                    System.out.println("Ruolo/Riferimento?");
                    String r = in.next();
                    boolean d=true;
                    while(d){
                        if(dip.equals("i") || dip.equals("I")){
                            Impiegato imp = new Impiegato(name,cog,cal,tel,ind,nc,r);
                            n.addDipendente(imp);
                            d=false;
                            System.out.print("Impiegato aggiunto\n");
                        }
                        else if(dip.equals("f") || dip.equals("F")){
                            Fornitore fo= new Fornitore(name,cog,cal,tel,ind,nc,r);
                            n.addDipendente(fo);
                            d=false;
                            System.out.println("Fornitore aggiunto");
                        }
                        else{
                            System.out.println("ERRORE!\n Impiegato[i/I] o Fornitore[f/F]?");
                            dip = in.next();
                        }
                    }
                }
                catch (IllegalArgumentException a){
                    System.out.println("Numero civico non valido.");
                }
            }
            else if(scelta==3){
                try{
                    if(n.getDipendenti().isEmpty())
                        System.out.println("Non ci sono dipendenti.");
                    else{
                        System.out.println("Posizione[p/P] o Matricola[m/M]?");
                        String sc=in.next();
                        boolean d=true;
                        while(d){
                            if(sc.equals("p") || sc.equals("P")){
                                System.out.println("Inserire la posizione: ");
                                int i=in.nextInt();
                                n.deleteDipendente(i);
                                d=false;
                            }
                            else if(sc.equals("m") || sc.equals("M")){
                                System.out.println("Inserire la matricola: ");
                                int m=in.nextInt();
                                boolean ris=n.deleteDipendentebyMat(m);
                                if(ris==true) d=false;
                                else d=true;
                            }
                            else{
                                System.out.println("ERRORE!\n Posizione[p/P] o Matricola[m/M]?");
                                sc=in.next();
                            }
                        }
                        System.out.println("Dipendente licenziato.");
                    }
                }
                catch (IllegalArgumentException a){
                    System.out.println("Posizione non valida.");
                }
            }
            else if(scelta==4) quit=false;      
        }
    }
    /**
     * Funzione che permette la gestione del magazzino.
     * @throws ParseException 
     */
    private static void opMag() throws ParseException{
        Scanner in= new Scanner(System.in);
        boolean quit=true;
        while(quit){
            System.out.println("Cosa si desidere fare?\n"
                               + "1:Visualizzare il numero e la lista prodotti nel magazzino;\n"
                               + "2:Aggiungere un prodotto;\n"
                               + "3:Eliminare un prodotto;\n"
                               + "4:Controllare la scadenza dei prodotti;\n"
                               + "5:Torno al menù precedente.");
            int scelta= in.nextInt();
            if(scelta==1)
                System.out.println("Il numero di prodotti è: "+n.totMagazzino()+"\n"+n.getMagazzino());
            else if(scelta==2){
                try{
                    System.out.println("Nome?");
                    String nome = in.next();
                    System.out.println("Marca?");
                    String marca = in.next();
                    System.out.println("Data di scadenza (gg/mm/aaaa)?");
                    String data = in.next();
                    DateFormat df = new SimpleDateFormat("dd/M/yyyy");
                    df.setLenient(false);
                    Date dat= df.parse(data);
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(dat);
                    System.out.println("Quantità?");
                    int q = in.nextInt();
                    System.out.println("Prezzo?");
                    double pr = in.nextDouble();
                    Prodotto p = new Prodotto(nome,marca,cal,q,pr);
                    n.addProdotto(p);
                    System.out.println("Il prodotto è stato aggiunto.");
                }
                catch (IllegalArgumentException a){
                    System.out.println("Quantità o Prezzo non valido.");
                } 
            }
            else if(scelta==3){
                try{
                    if(n.getMagazzino().isEmpty())
                    System.out.println("Non ci sono prodotti in magazzino");
                    else{
                        System.out.println("Posizione[p/P] o Nome[n/N]?");
                        String sc=in.next();
                        boolean d=true;
                        while(d){
                            if(sc.equals("p") || sc.equals("P")){
                                System.out.println("Inserire la posizione: ");
                                int i=in.nextInt();
                                n.deleteProdotto(i);
                                d=false;
                            }
                            else if(sc.equals("n") || sc.equals("N")){
                                System.out.println("Inserire il nome: ");
                                String no=in.next();
                                boolean ris=n.deleteProdotto(no);
                                if(ris==true) d=false;
                                else d=true;
                            }
                            else{
                                System.out.println("ERRORE!\n Posizione[p/P] o Nome[n/N]?");
                                sc=in.next();
                            }
                        }
                        System.out.println("Prodotto Eliminato.");
                    }
                }
                catch (IllegalArgumentException a){
                    System.out.println("Posizione non valida.");
                }
            }
            else if(scelta==4){
                 if(n.getMagazzino().isEmpty())
                    System.out.println("Non ci sono prodotti in magazzino");
                else{
                    n.controllaScadenza();
                    System.out.println("Eventuali prodotti scaduti sono stati eliminati.");
                 }
            }
            else if(scelta==5) quit=false; 
        }
    }
    /**
     * La funzione permette di salvare su file.
     */
    private static void saveTo(){
        String path ="negozio.txt";
        File file = new File(path);
        try {
            if(file.exists()){
                try{
                    n.savetoFile(path);
                    System.out.println("Salvataggio effettutato.");
                }
                catch(FileNotFoundException f){f.printStackTrace();}
            }    
            else if(file.createNewFile()){
                try{
                    n.savetoFile(path);
                    System.out.println("Salvataggio effettutato.");
                }
                catch(FileNotFoundException f){f.printStackTrace();}
            }
            else System.out.println("Il file " + path + " non può essere creato");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * La funzione main è l'interfaccia del utente, all'avvio prende le informazioni da file e crea
     * il menù a tendina con cui l'utente si interfaccia.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String path ="negozio.txt";
        File file = new File(path);
        if (file.exists()){
            try{
                n.getFromFile(path);
                System.out.println("Caricamento effettuato.");
            }
            catch(FileNotFoundException | ParseException f) {f.printStackTrace();}
        }
        else System.out.println("Il file " + path + " non può essere creato");
        boolean quit=true;
        Scanner in= new Scanner(System.in);
        int scelta;
        while(quit){
            System.out.println("Cosa si desidera fare?\n"
                               + "1:Inserire nome negozio;\n"
                               + "2:Operazioni con i dipendenti;\n"
                               + "3:Operare nel magazzino;\n"
                               + "4:Salvare;\n"
                               + "5:Stampa informazioni negozio;\n"
                               + "6:Quit.");
            scelta = in.nextInt();
            if(scelta==1) nameNeg();
            else if(scelta==2){
                try{
                    opDip();
                }
                catch (ParseException p){
                    System.out.println("Formato data errato.");
                }
            }
            else if(scelta==3){
                try{
                    opMag();
                }
                catch (ParseException p){
                    System.out.println("Formato data errato.");
                }
            }
            else if(scelta==4) saveTo();
            else if(scelta==5) System.out.println(n.printNegozio());
            else if(scelta==6) quit=false;
        }
    }
}