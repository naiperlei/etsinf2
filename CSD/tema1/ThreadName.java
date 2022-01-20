
public class ThreadName extends Thread{
    public void run() {
        for(int i = 0; i < 3; i++){
            printMsg();
        }
    }
    
    public void printMsg() {
        System.out.println("name=" +
         Thread.currentThread().getName());
    }
    
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            ThreadName tt = new ThreadName ();
            tt.setName("MyThread" + i);
            if (i<5) tt.start();
        }
    }
}
