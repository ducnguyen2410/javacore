package java_learning.collec.map1;

import java.util.HashMap;
import java.util.Map;

public class hashmap {
    public static void main(String[] args) {
        HashMap<String, Integer> usthclass = new HashMap<>();
        usthclass.put("2.11", 2);
        usthclass.put("2.12", 3);
        usthclass.put("2.6", 5);
        for(Map.Entry<String, Integer> mp: usthclass.entrySet())
        {
            String class_name = mp.getKey();
            int class_sched = mp.getValue();
            System.out.println("Class " + class_name + " has schedule on day "+class_sched);
        }
        System.out.println(usthclass.get("2.11"));
        usthclass.put("2.4", 6);
    }
}
