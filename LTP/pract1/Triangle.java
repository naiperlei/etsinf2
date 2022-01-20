package pract1;


/**
 * class Triangle.
 * 
 * @author LTP
 * @version 2020-21
 */

public class Triangle extends Figure {
    private double base; 
    private double height;

    public Triangle(double x, double y, double b, double h) {
        super(x, y);
        base = b;
        height = h;
    }

    public String toString() {
        return "Triangle:\n\t" +
            super.toString() +
            "\n\tBase: " + base +
            "\n\tHeight: " + height;
    }
    
    public boolean equals(Object o){
        if(!(o instanceof Triangle)){return false;}
        Triangle t = (Triangle) o;
        return super.equals(t) &&
            base == t.base &&
            height == t.height;
    }
    
    public double area(){ return base * height / 2;}
    
    public double perimeter(){
        System.out.println("No hay suficientes datos para calcular el perimetro");
        return -1;
    }
}