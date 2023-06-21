package java_learning.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class teststream2 {
    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>(){{
            add(new int[]{1,20});
            add(new int[]{2,30});
            add(new int[]{3,40});
        }};

        list = list.stream().sorted(Comparator.comparingInt(i->i[1])).collect(Collectors.toList());
        list.stream().forEach(i -> System.out.println(i[1]));
    }
}
