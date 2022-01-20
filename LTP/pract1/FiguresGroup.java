package pract1;


/**
 * class FiguresGroup.
 * 
 * @author LTP 
 * @version 2020-21
 */

public class FiguresGroup {
    private static final int NUM_FIGURES = 10;
    private Figure[] figuresList = new Figure[NUM_FIGURES];
    private int numF = 0;
    
    public void add(Figure f) { figuresList[numF++] = f; }
    
    public String toString() {
        String s = "";
        for (int i = 0; i < numF; i++) {
            s += "\n" + figuresList[i];
        }
        return s;
    }

    private boolean found(Figure f) {
        for (int i = 0; i < numF; i++) {
            if (figuresList[i].equals(f)) return true;
        }
        return false;
    }

    private boolean included(FiguresGroup g) {
        for (int i = 0; i < g.numF; i++) {
            if (!found(g.figuresList[i])) return false;
        }
        return true;
    }
    
    public boolean equals(Object o){
        if(!(o instanceof FiguresGroup)){return false;}
        FiguresGroup g = (FiguresGroup) o;
        return this.included(g) && g.included(this);
    }
    
    public double sumaAreas(FiguresGroup g){
        double suma = 0;
        for(int i = 0; i <= g.numF - 1; i++){
            suma = suma + g.figuresList[i].area();
        }
        return suma;
    }
    
    public Figure greatestFigure(FiguresGroup g){
        Figure greatest = g.figuresList[0];
        for(int i = 1; i < g.numF; i++){
            if(g.figuresList[i].area() > greatest.area()){ greatest = g.figuresList[i];}
        }   
        return greatest;
    }
}