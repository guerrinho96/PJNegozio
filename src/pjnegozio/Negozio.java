
package pjnegozio;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.*;

/**<i><b>Classe Negozio</b> <br>
 * La classe Negozio ha al suo interno informazioni sul nome, i dipendenti, e il magazzino.<br>
 * Il costruttore è dichiarato privato in quanto questa classe deve generare un unica istanza, 
 * il metodo "getInstance" avrà il compito di accedere al costruttore del negozio.</i>
 * @author Oscar
 */
public class Negozio {
    private static Negozio istanza;
    private String nome;
    private ArrayList<Dipendente> dipendenti;
    private ArrayList<Prodotto> magazzino; 
    
    /**
     * Costruttore di default che inizializza le due liste utilizzate dipendenti e magazzino
     * e permette di inserire il nome del negozio.
     */
    private Negozio(){
        this.nome=new String();
        this.dipendenti = new ArrayList<Dipendente>();
        this.magazzino = new ArrayList<Prodotto>();
        
    }
    /**
     * Questo metodo ritorna l'istanza del negozio, se l'istanza non è ancora stata creata ne crea una nuova attraverso il costruttore.
     * @return istanza del negozio.
     */
    public static Negozio getInstance(){
    if (istanza == null)
    {
      istanza = new Negozio();
    }
    return istanza; 
  }
    /**
     * Questo metodo restituisce il nome del negozio.
     * @return il nome del negozio.
     */
    public String getNome() {
        return this.nome;
    }
    /**
     * Questo metodo permette di cambiare il nome del negozio.
     * @param n nome del negozio.
     */
    public void setNome(String n) {
        this.nome = n;
    }
    /**
     * Questo metodo restituisce la lista di dipendenti del negozio.
     * @return dipendenti del negozio. 
     */
    public ArrayList<Dipendente> getDipendenti() {
        return this.dipendenti;
    }
    /**
     * Questo metodo restituisce l'inventario del magazzino.
     * @return i prodotti presenti nel magazino.
     */
    public ArrayList<Prodotto> getMagazzino() {
        return this.magazzino;
    }
    /**
     * Questo metodo restituisce l'i-esimo prodotto all'interno del magazzino.
     * @param i posizione del prodotto.
     * @return prodotto richiesto.
     * @throws IllegalArgumentException se la posizione è negativa o più grande della lunghezza della lista
     */
    public Prodotto getProdotto(int i) throws IllegalArgumentException{
        if(i>=magazzino.size() || i<0) throw new IllegalArgumentException("Invalid position");
        else return this.magazzino.get(i);
    }
    /**
     * Questo metodo restituisce l'i-esimo dipendente del negozio.
     * @param i posizione del dipendente.
     * @return dipendente richiesto.
     * @throws IllegalArgumentException se la posizione è negativa o più grande della lunghezza della lista
     */
    public Dipendente getDipendente(int i) throws IllegalArgumentException{
        if(i>=dipendenti.size() || i<0) throw new IllegalArgumentException("Invalid position");
        else return this.dipendenti.get(i);
    }
    /**
     * Questo metodo permette di aggiungere un dipendente alla lista dipendenti.
     * @param d dipendente che va aggiunto alla lista.
     */        
    public void addDipendente(Dipendente d){
        this.dipendenti.add(d);
    }
    /**
     * Questo metodo permette di aggiungere un prodotto nel magazzino.
     * @param p prodotto che si vuole inserire.
     */
    public void addProdotto(Prodotto p){
        this.magazzino.add(p);
    }
    /**
     * Questo metodo permette di licenziare l'i-esimo dipendente.
     * @param i posizione del dipendente.
     * @throws IllegalArgumentException se la posizione è negativa o più grande della lunghezza della lista
     */
    public void deleteDipendente(int i) throws IllegalArgumentException{
        if(i>=this.dipendenti.size() || i<0) throw new IllegalArgumentException("Invalid position");
        this.dipendenti.remove(i);
    }
    /**
     * Questo metodo permette di eliminare l'i-esimo prodotto dal magazzino.
     * @param i posizione prodotto.
     * @throws IllegalArgumentException se la posizione è negativa o più grande della lunghezza della lista
     */
    public void deleteProdotto(int i) throws IllegalArgumentException{
        if(i>=this.magazzino.size() || i<0) throw new IllegalArgumentException("Invalid position");
        else this.magazzino.remove(i);
    }
    /**
     * Questo metodo permette di eliminare un prodotto dal suo nome.
     * @param n nome del prodotto che si vuole eliminare
     * @return vero/falso in base al risultato della funzione.
     */
    public boolean deleteProdotto(String n){
        boolean r=false;
        for(int i=0; i<magazzino.size();i++){
            Prodotto p= magazzino.get(i);
            if(p.getNome().equals(n))
                magazzino.remove(i);
                r=true;
                i=magazzino.size();//Così facendo viene eliminato il primo prodotto nell'array che ha quel nome
        }
        return r;
    }
    /**
     * Questo metodo permette di eliminare un dipendente data la sua matricola.
     * @param m matricola del dipendente.
     * @return vero/falso in base al risultato della funzione.
     */
    public boolean deleteDipendentebyMat(int m){
        boolean r=false;
        for(int i=0; i<dipendenti.size();i++){
            Dipendente d= dipendenti.get(i);
            if(d.matricola==m){
                dipendenti.remove(i);
                r=true;
                i=dipendenti.size(); //quando si trova il dipendente si esce dal ciclo
            }
        }
        return r;
    }
    /**
     * Questo metodo restituisce il numero totale di prodotti nel magazzino.
     * @return totale prodotti
     */
    public int totMagazzino(){
        return this.magazzino.size();
    }
    /**
     * Questo metodo restituisce il numero totale di dipendenti del negozio
     * @return totale dipendenti.
     */
    public int totDipendenti(){
        return this.dipendenti.size();
    }
    /**
     * Questo metodo una volta richiamato elimina gli eventuali prodotti scaduti dal magazzino.
     */
    public void controllaScadenza(){
        Date d = GregorianCalendar.getInstance().getTime(); //data del giorno
        Calendar c = Calendar.getInstance();
        for(int i=0; i<magazzino.size();i++){
            Prodotto p= magazzino.get(i);
            c=p.getDatascadenzabyCal(); //data del prodotto
            if(d.compareTo(c.getTime())>0 || d.compareTo(c.getTime())==0)
                this.deleteProdotto(i);     
        }
    }
    /**
     * Questo metodo permette di stampare una stringa contenente le informazioni del negozio
     * @return informazioni negozio
     */
    @Override
    public String toString(){
        String s=this.nome+" "+magazzino.size()+" ";
        for(Prodotto p : this.magazzino) s+=p.toString();
        s+=dipendenti.size()+" ";
        for(Dipendente d : this.dipendenti)
            s+=d.toString();
        return s;
    }
    /**
     * Questo metodo permette il salvataggio delle informazioni di negozio su un file.
     * @param nome nome del file dove vengono salvate le informazioni
     * @throws FileNotFoundException 
     */
    public void savetoFile(String nome) throws FileNotFoundException{
        PrintWriter file=new PrintWriter(nome);
        String t=this.toString();
        file.println(t);
        file.close();
    }
    /**
     * Questo metodo permette di prendere i dati da un file.
     * @param name nome del file
     * @throws FileNotFoundException
     * @throws ParseException 
     */
    public void getFromFile(String name) throws FileNotFoundException, ParseException{
        File input=new File(name);
        Scanner in=new Scanner(input);
        this.magazzino.clear();
        this.dipendenti.clear();
        while(in.hasNext())
        {
            String n=new String();
            while(!in.hasNextInt())
                n+=in.next()+" "; //prende il nome del negozio
            this.nome=n;
            int size=in.nextInt(); //prende la lunghezza della lista prodotti
            for(int i=0; i<size; i++){
                String p=in.next(); //nome del prodotto
                String m=in.next(); //marca del prodotto
                String d=in.next(); //data del prodotto
                int q=in.nextInt(); //quantità
                double pr=in.nextDouble(); //prezzo
                DateFormat df = new SimpleDateFormat("dd/M/yyyy");
                df.setLenient(false);
                Date data= df.parse(d);
                Calendar c = Calendar.getInstance();
                c.setTime(data);
                Prodotto prod = new Prodotto(p,m,c,q,pr);
                this.addProdotto(prod);
            }
            size=in.nextInt(); //lunghezza lista dipendenti
            for(int i=0; i<size; i++){
                String chiave =in.next(); //parola chiave
                int mat =in.nextInt(); //matricola
                String no =in.next(); //nome
                String c =in.next(); //cognome
                String data =in.next(); //data
                String tel =in.next();
                String ind =in.next();
                int nc =in.nextInt(); //numero civico
                String r=in.next(); //ruolo o riferimento
                DateFormat df = new SimpleDateFormat("dd/M/yyyy");
                df.setLenient(false);
                Date dat= df.parse(data);
                Calendar cal = Calendar.getInstance();
                cal.setTime(dat);
                if(chiave.equals("Impiegato")){
                    Impiegato imp = new Impiegato(no,c,cal,tel,ind,nc,r);
                    this.addDipendente(imp);
                }
                else{
                    Fornitore f = new Fornitore(no,c,cal,tel,ind,nc,r);
                    this.addDipendente(f);    
                }
            }
        }
    }
}
