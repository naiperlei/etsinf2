
/**
 * Write a description of class T2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class T2 extends Thread{
    private int level;
    public T2(int n){
        level = n;
    }
    public void createThread(int i){
        T2 h = new T2(i);
        if(i>=1)
            h.start();
        System.out.println("Thread of level "+i+" created.");
    }
    public void run() {
        if(level>0)
            createThread(level-1);
        System.out.println("End of thread. Level:" + level);
    }
    public static void main(String[] argv) {
        for(int i = 1; i<3; i++)
            new T2(2).start();
    }
}
