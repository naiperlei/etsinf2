
/**
 * Write a description of class RunnableLambdaEx here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RunnableLambdaEx
{
    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName() + ": RunnableTest");

        // --- Parte 1 -----------------------
        Runnable task1 = new Runnable(){
                public void run(){
                    System.out.println(Thread.currentThread().getName() + " is running");
                }
            };
        Thread thread1 = new Thread(task1);
        thread1.setName("hilo1"); thread1.start();
        new Thread(task1, "hilo1b").start();

        // --- Parte 2 ---------------------
        Thread thread2 = new Thread(new Runnable(){
                    public void run(){
                        System.out.println(Thread.currentThread().getName() + " is running");
                    }
                });
        thread2.setName("hilo2"); thread2.start();

        new Thread(new Runnable () {
                public void run(){
                    System.out.println(Thread.currentThread().getName() + " is running");
                }
            },"hilo2b").start();

        // --- Parte 3 ------------------
        Runnable task3 = () -> {
                System.out.println(Thread.currentThread().getName() + " is running");
            };
        new Thread(task3, "hilo3b").start();

        Thread thread3 = new Thread(() ->
                    System.out.println(Thread.currentThread().getName() + " is running"));
        thread3.setName("hilo3"); thread3.start();

        new Thread(() -> System.out.println(Thread.currentThread().getName() + " is running"), "hilo4").start();
    }
}
