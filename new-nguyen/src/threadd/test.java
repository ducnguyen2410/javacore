package threadd;

public class test
{
    public static void main(String []args)
    {
        for(int i = 0; i <= 4; i++)
        {
            multithr c = new multithr(i);
            Thread th = new Thread(c);
            th.start();
            try
            {
                th.join();
            }catch (InterruptedException e){}
        }
    }
}