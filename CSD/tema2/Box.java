package tema2;


/**
 * Write a description of class Box here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Box
{
    private int content = 0;
    private boolean full = false;
    
    public synchronized int get(){
        int value = content;
        content = 0;
        full = false;
        return value;
    }
    
    public synchronized void put(int value){
        full = true;
        content = value;
    }
}
