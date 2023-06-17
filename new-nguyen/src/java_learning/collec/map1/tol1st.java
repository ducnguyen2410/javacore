package java_learning.collec.map1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class tol1st {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        System.out.println("Array elements before changing: "+ list);
        Stream<Integer> s_int = list.stream();
        List<Integer> list2 = s_int.map(x -> x+2).collect(Collectors.toList());
        System.out.println("Array elements after changing: " + list2);
        Stream<Integer> s_int2 = list2.stream();
        List<Integer> list3 = s_int2.filter(num -> num > 4).collect(Collectors.toList());
        System.out.println("Array elements after filtering > 4: " + list3);
    }
}
