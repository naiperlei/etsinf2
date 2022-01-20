package tema2;


/**
 * Write a description of class Consumer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Consumer extends Thread
{
    private Box box;
    private int cname;
    public Consumer(Box c, int name){
        box = c;
        cname = name;
    }
    
    public void run(){
        for(int i = 1; i <= 10; i++){
            int value = 0;
            value = box.get();
            System.out.println("Consumer #" + cname + " gets: " + value);
            try{
                Thread.sleep((int)(Math.random() * 100));
            } catch(InterruptedException e){}
        }
    }
}
