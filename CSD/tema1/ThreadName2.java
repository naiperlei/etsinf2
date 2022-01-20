
/**
 * Write a description of class ThreadName2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ThreadName2
{
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            if(i<5){
                new Thread("MyThread" + i){
                    public void run(){
                        for(int i = 0; i < 3; i++){
                            System.out.println("name=" +
                             Thread.currentThread().getName());
                        }
                    }
                }.start();
            }
            else{
                new Thread("MyThread" + i){
                    public void run(){
                        for(int i = 0; i < 3; i++){
                            System.out.println("name=" +
                             Thread.currentThread().getName());
                        }
                    }
                };
            }
        }
    }
}
