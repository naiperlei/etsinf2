
/**
 * Write a description of class ThreadName3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ThreadName3
{
   public static void main(String[] args){
       for(int i = 0; i < 10; i++){
           Thread hilo = new Thread(){
               public void printMsg(){
                   System.out.println("name=" + Thread.currentThread().getName());
               }
               public void run() {
                   for(int j = 0; j < 3; j++)
                        printMsg();
               }
           };
           hilo.setName("MyThread" + i);
           if(i < 5){
               hilo.start();
           }
       }
   }
}
