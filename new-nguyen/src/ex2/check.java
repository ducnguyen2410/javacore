package ex2;

public class check {
    public static void main(String[] args) {
        String str = "Nguyen\td";
        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) == '\t') System.out.println("Damn");
            System.out.print(str.charAt(i));
        }
    }
}
