package com.syntax.groupProject17;
//Create an Interface 'Shape' with undefined methods
//as calculateArea and calculatePerimeter. Create 2
//classes Circle & Square that implements functionality
//defined in the Shape Interface. Test your code.
public class Task1 {
    public static void main(String[] args) {

        Shape[] shape = {new Circle(),new Square()};
        for (Shape s:shape) {
            System.out.println(s.calculateArea(5.0));
            System.out.println(s.calculatePerimeter(5.0));
        }
    }
}
interface Shape{
    double calculateArea(double radius);
    double calculatePerimeter(double side);
}
class Circle implements Shape{
    @Override
    public double calculateArea(double radius){
        return Math.PI*(Math.pow(radius,2));
    }

    @Override
    public double calculatePerimeter(double radius){
        return 2*Math.PI*radius;
    }
}
class Square implements Shape{
    @Override
    public double calculateArea(double side){
        return Math.pow(side,2);
    }

    @Override
    public double calculatePerimeter(double side){
        return 4*side;
    }
}

