package tema3;

/**
 * Write a description of class Productor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Productor extends Thread
{
    private Caja caja;
    private int prodnumber;
    public Productor(Caja c, int number){
        caja = c;
        prodnumber = number;
    }

    public void run(){
        for(int i = 0; i < 11; i++){
            caja.poner(i);
            System.out.println("Productor #" + prodnumber + " pone: " + i);
            try{
                sleep((int)(Math.random() * 100));
            } catch(InterruptedException e){}
        }
    } 
}
