
/**
 * Write a description of class ExThreadLambda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExThreadLambda
{
    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName());
        for(int i = 0; i<10; i++){
            new Thread(()-> System.out.println("executed by" + 
                        Thread.currentThread().getName()), ("MyThread" + i)).start();

        }
    }
}
