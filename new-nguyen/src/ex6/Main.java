package ex6;

class test extends Thread {
    public void run()
    {
        for(int i=1;i<5;i++)
        {
            try
            {
                Thread.sleep(500);
            }catch(InterruptedException e){System.out.println(e);}
            System.out.println(i);
        }
    }
}

class test2 extends Thread {
    public void run()
    {
        for(int i=1;i<5;i++)
        {
            try
            {
                Thread.sleep(500);
            }catch(InterruptedException e){System.out.println(e);}
            System.out.println(i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        test t1 = new test();
        test2 t2 = new test2();
        t1.start();
        t2.start();
    }
}
