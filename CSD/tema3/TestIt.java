package tema3;


/**
 * Write a description of class TestIt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestIt
{
    public class Test{
        public synchronized void test(Test t){
            t.SayHola();
        }
        public synchronized void SayHola(){
            System.out.println("Hola");
        }
    }
    public TestIt(){
        Test t1 = new Test();
        Test t2 = new Test();
        new Thread(new Runnable(){public void run(){
            t1.test(t2);
        }}).start();
        new Thread(new Runnable() {public void run(){
            t2.test(t1);
        }}).start();
    }
    public static void main(String[] args){
        new TestIt();
    }
}
