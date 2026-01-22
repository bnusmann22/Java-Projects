class Shape{
    private String type;
    private int sides;

    Shape(String t , int s){
        this.sides = s;
        this.type = t;
    }

    public String getType(){
        return type;
    }

    public int getSides(){
        return sides;
    }



}

public class Oblong {
    private double length;
    private double width;

    public Oblong(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }

    public double getPerimeter() {
        return 2 * (length + width);
    }

    public static void main(String[] args) {
        Shape s1 =  new Shape("Triangle", 3);

        System.out.println(s1.getSides());
    }
}