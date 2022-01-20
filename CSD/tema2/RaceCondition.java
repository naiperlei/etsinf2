package tema2;


/**
 * Write a description of class RaceCondition here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RaceCondition
{
    public static void main(String[] args){
        Counter c = new Counter();
        int loops = 1000;
        System.out.println("Loops " + loops);
        
        Incrementer inc1 = new Incrementer(c, 1, loops);
        Incrementer inc2 = new Incrementer(c, 2, loops);
        
        Decrementer dec1 = new Decrementer(c, 1, loops);
        Decrementer dec2 = new Decrementer(c, 2, loops);
        
        inc1.start(); inc2.start();
        dec1.start(); dec2.start();
        
        try{ inc1.join(); inc2.join(); dec1.join(); dec2.join();}
        catch(InterruptedException e){}
        System.out.println("Final result: " + c.value());
    }
}
