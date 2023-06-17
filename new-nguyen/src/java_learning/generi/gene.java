package java_learning.generi;

import java.util.ArrayList;

class test<T>
{
    T dummy;
    public void setDummy(T dummy)
    {
        this.dummy = dummy;
    }

    public T getDummy()
    {
        return this.dummy;
    }
}

public class gene {

    public static <T> void swap(int a, int b, T[]arr)
    {
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static <T extends Comparable<T>>void sorti(T[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr.length - 1 - i; j++)
            {
                if(arr[j].compareTo(arr[j+1]) > 0)
                {
                    swap(j, j+1, arr);
                }
            }
        }

        for(int i = 0; i < arr.length; i++)
        {
            System.out.printf(arr[i] + ", ");
        }
    }

    public static void main(String []args)
    {
        test<Integer> ggg = new test<>();
        ggg.setDummy(15);
        test<String> hhh = new test<>();
        hhh.setDummy("anh Thuan");
        System.out.println(ggg.getDummy());
        System.out.println(hhh.getDummy());
        Integer[] arr = {15, 14, 13};
        sorti(arr);
    }
}
