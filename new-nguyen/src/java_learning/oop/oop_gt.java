package java_learning.oop;

abstract class programmer
{
    abstract void notifyca();
}

class frontend extends programmer
{
    @Override
    void notifyca()
    {
        System.out.println("Code frontend");
    }
}

class backend extends programmer
{
    @Override
    void notifyca()
    {
        System.out.println("Code backend");
    }
}
public class oop_gt {
    public static void main(String []args)
    {
        programmer f1 = new frontend();
        programmer f2 = new backend();
        f1.notifyca();
        f2.notifyca();
    }
}
