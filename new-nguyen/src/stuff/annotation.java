package stuff;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class annotation {
    public static void main(String []args)
    {
        test1 demo = new test1();
        for(Method method: demo.getClass().getDeclaredMethods())
        {
            if(method.isAnnotationPresent(important.class))
            {
                try
                {
                    method.invoke(demo);
                }catch (IllegalAccessException e)
                {
                    e.printStackTrace();
                }catch (InvocationTargetException e)
                {
                    e.printStackTrace();
                }
            }
        }

    }
}
