package stuff;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class test {

    public static <T extends Comparable<T>> void gensort(ArrayList<Integer> a)
    {
        a.stream().sorted().forEach(m -> System.out.println(m));
    }

    public static void main(String []args)
    {
        ArrayList <Integer> a = new ArrayList<>();
        a.add(2);
        a.add(5);
        a.add(4);
        gensort(a);
    }
}
