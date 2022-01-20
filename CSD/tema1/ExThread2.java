
/**
 * Write a description of class ExThread2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExThread2{
    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName());
        for(int i = 0; i<10; i++){
            Thread tt = new Thread(){
                public void run(){
                    System.out.println("executed by"+
                        Thread.currentThread().getName());
                }
            };
            tt.setName("MyThread"+i);
            tt.start();
        
        }
    }
}
