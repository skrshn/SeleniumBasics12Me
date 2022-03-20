package com.syntax.groupProject17;

//We have to calculate the average of marks obtained
//        in three subjects by student A and by student B.
//        Create   class   'Marks'   with   an   abstract   method
//        'getPercentage' that will be returning the average
//        percentage   of   marks.   Provide   implementation   of
//abstract   method   in   classes   'A'   and   'B'.   The
//        constructor of student A takes the marks in three
//        subjects as its parameters and the marks in four
//        subjects as its parameters for student B. Test your
//        code
public class Task2 {
    public static void main(String[] args) {
        System.out.println("Average of Student A: "+new A(98,55,44).getPercentage());
        System.out.println("Average of Student B: "+new B(58,75,49).getPercentage());
    }
}
abstract class Marks{
    public int mark1,mark2,mark3;
    Marks(int mark1,int mark2,int mark3){
        this.mark1=mark1;
        this.mark2=mark2;
        this.mark3=mark3;
    }
    abstract int getPercentage();
}
class A extends Marks{
    A(int mark1,int mark2,int mark3){super(mark1,mark2,mark3);}

    @Override
    public int getPercentage(){return (mark1+mark2+mark3)/3;}
}
class B extends Marks{
    B(int mark1,int mark2,int mark3){super(mark1,mark2,mark3);}

    @Override
    public int getPercentage(){return (mark1+mark2+mark3)/3;}
}