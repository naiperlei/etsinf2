package pract2;

import pract1.Figure;
import pract2.librerias.implementaciones.QueueAL;

/**
 * class FiguresQueue.
 * 
 * @author LTP 
 * @version 2020-21
 */

public class FiguresQueue<T extends Figure> extends QueueAL<T> { 
    public double area(){
        double suma = 0;
        int size = size();
        T aux = null;
        for(int i = 0; i <size; i++){
            aux = dequeue();
            suma += aux.area();
            enqueue(aux);
        }
        return suma;
    }
}