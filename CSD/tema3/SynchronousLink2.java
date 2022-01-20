package tema3;


/**
 * Write a description of class SynchronousLink2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SynchronousLink2<E>
{
    int senders_waiting, receivers_waiting;
    E msg;
    
    public SynchronousLink2(){
        senders_waiting = receivers_waiting = 0;
        msg = null;
    }
    
    public synchronized void send(E m){
        if(receivers_waiting > 0){
            msg = m;
            notify();
        } else{
            msg = m;
            senders_waiting++;
            try{wait();} catch(InterruptedException e){}
            senders_waiting--;
        }
    }
    
    public synchronized E receive(){
        if(senders_waiting > 0){
            notify();
        } else{
            receivers_waiting++;
            try{wait();} catch(InterruptedException e){}
            receivers_waiting--;
        }
        return msg;
    }
}
