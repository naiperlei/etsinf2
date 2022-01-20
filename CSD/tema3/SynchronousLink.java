package tema3;


/**
 * Write a description of class SynchronousLink here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SynchronousLink<E>
{
    boolean OKreceiver;
    E msg;
    boolean basura;
    
    public SynchronousLink(){
        msg = null;
        basura = false;
    }
    
    public void send(E m){
        while(!OKreceiver){
            try{
                wait();
            } catch(InterruptedException e){}
        }
        msg = m;
        basura = false;
        System.out.println(m + "enviado");
        notifyAll();
        while(!basura){
            try{
                wait();
            } catch(InterruptedException e){}
        }
    }
    
    public E receive(){
        OKreceiver = true;
        notifyAll();
        while(basura){
            try{
                wait();
            } catch(InterruptedException e){}
        }
        System.out.println(msg + "recibido");
        basura = true;
        OKreceiver = false;
        notifyAll();
        return msg;
    }
}
