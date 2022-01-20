
/**
 * Write a description of class ExThread here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExThread{
    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName());
        for(int i = 0; i<10; i++){
            new Thread("MyThread "+i){
                public void run(){
                    System.out.println("executed by"+
                        Thread.currentThread().getName());
                }
            }.start();
        
        }
    }
}
