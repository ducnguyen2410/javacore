package java_learning.stream;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test_stream {
    public static void main(String[] args) {
//        Integer [] l = {1,2,3,4};
//        Stream<Integer> test_stream = Arrays.stream(l, 1,4);
//        test_stream.forEach(x -> System.out.print(x +" "));
//        Stream<Integer> stream_int = Stream.iterate(2, x -> x + 3).limit(2);
//        stream_int.forEach(x -> System.out.println(x +" "));
        ArrayList <String[]> twod_list = new ArrayList<String[]>();
        String [] new_string = {"Nguyen"};
        twod_list.add(new_string);
        System.out.println(twod_list.get(0)[0]);
    }
}
