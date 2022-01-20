package tema3;


/**
 * Write a description of class Consumidor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Consumidor extends Thread
{
    private Caja caja;
    private int cnumber;
    public Consumidor(Caja c, int number){
        caja = c;
        cnumber = number;
    }
    public void run(){
        int value = 0;
        for(int i = 0; i < 11; i++){
            value = caja.obtener();
            System.out.println("Consumidor #" + cnumber + " obtiene: " + value);
            try{
                sleep((int)(Math.random() * 100));
            } catch(InterruptedException e){}
        }
    }
}
