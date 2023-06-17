package java_learning.annota;

import java.lang.reflect.Field;

class dummy
{
    @check(times = 2)
    int age;
}

public class test {
    public static void main(String []args) throws IllegalAccessException
    {
        dummy ggg = new dummy();
        ggg.age = 15;
        for(Field field: ggg.getClass().getDeclaredFields())
        {
            if(field.isAnnotationPresent(check.class))
            {
                Object val = field.get(ggg);
                if(val instanceof Integer inval)
                {
                    System.out.println(inval);
                }
            }
        }
    }
}
