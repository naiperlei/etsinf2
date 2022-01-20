package tema3;


/**
 * Write a description of class Caja here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Caja
{
    private int contenido = 0;
    private boolean llena = false;
    
    public synchronized int obtener(){
        if(!llena){
            try{wait();}
            catch(InterruptedException e){}
        }
        int valor = contenido;
        contenido = 0;
        llena = false;
        notifyAll();
        return valor;
    }
    
    public synchronized void poner(int valor){
        if(llena){
            try{
                wait();
            } catch(InterruptedException e){}
        }
        llena = true;
        contenido = valor;
        notifyAll();
    }
}
