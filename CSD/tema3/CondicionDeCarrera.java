package tema3;


/**
 * Write a description of class CondicionDeCarrera here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CondicionDeCarrera
{
    public static void main(String[] args){
        Caja c = new Caja();
        Consumidor c1 = new Consumidor(c, 1);
        Productor p1 = new Productor(c, 1);
        
        c1.start();
        p1.start();
    }
}
