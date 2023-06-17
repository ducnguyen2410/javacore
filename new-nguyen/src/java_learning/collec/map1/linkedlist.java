package java_learning.collec.map1;

import java.util.LinkedList;

public class linkedlist {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<String>();
        ll.add("Nguyen");
        ll.add("Linh");
        ll.add("An");
        String top = ll.remove();
        String peek = ll.peek();
        System.out.println("Dequeued element: " + top);
        System.out.println("First element: " + peek);
    }
}
