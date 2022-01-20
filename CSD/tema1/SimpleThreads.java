
public class SimpleThreads
{
    static void threadMessage(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.format("%s:%s%n", threadName, message);
    }
    private static class MessageLoop implements Runnable{
        public void run() {
            String importantInfo[] = {"One","Two","Three","Four"};
            try{
                for(int i = 0; i < importantInfo.length; i++){
                    Thread.sleep(4000);
                    threadMessage(importantInfo[i]);
                } 
            }catch(InterruptedException e){threadMessage("I wasn't done!");}
        }
    }
    public static void main(String[] args) throws InterruptedException{
        long patience = 1000 * 60;
        threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();
        threadMessage("Waiting for MessageLoop thread to finish");
        while(t.isAlive()){
            threadMessage("Still waiting...");
            t.join(1000);
            if(((System.currentTimeMillis()-startTime) > patience) && t.isAlive()){
                threadMessage("Tired of waiting!");
                t.interrupt();
                t.join();
            }
        }
        threadMessage("Finally!");
    }
}
