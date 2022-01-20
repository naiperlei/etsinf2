package tema5;

import java.util.concurrent.locks;
/**
 * Write a description of class Buffer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Buffer
{
    private int store = 0;
    private boolean full = false;
    private ReentrantLock lock;
    private Condition item, slot;

    public int get(){
        int value = store;
        store = 0;
        full = false;
        return value;
    }
    
    public void put(int value){
        full = true;
        store = value;
    }
}
