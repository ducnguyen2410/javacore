package threadd;

public class multithr implements Runnable{
    private int threadn;
    public multithr(int threadnumber)
    {
        this.threadn = threadnumber;
    }
    public void run()
    {
        for(int i = 0; i <= 5; i++)
        {
            System.out.println(i + " from thread " + threadn);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e)
            {}
        }
    }
}
