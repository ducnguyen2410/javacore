package java_learning.collec.map1;

import java.util.ArrayList;

public class handle_ex {
    public static void main(String[] args) {
        ArrayList<Integer> a_int = new ArrayList<>();
        a_int.add(1);
        a_int.add(2);
        a_int.add(3);
        try
        {
        for(int i = 4; i < 10; i++)
        {
            System.out.println(a_int.get(i));
        }
        }catch (Exception e)
        {
            System.out.println("Please check your index: " + e.getMessage());
        }
    }
}
