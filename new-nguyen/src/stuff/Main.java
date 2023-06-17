package stuff;
import java.lang.Math;
import java.util.Scanner;

class Main
{
    public static void main(String[]args)
    {
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        String b = scan.nextLine();
        int a_int, b_int;
        while((!isint(a) || !isint(b))) {
            while (!isint(a) || !isint(b)) {
                if (!isint(a)) {
                    System.out.println("So a khong hop le. Nhap lai: ");
                    a = scan.nextLine();
                }
                if (!isint(b)) {
                    System.out.println("So b khong hop le. Nhap lai: ");
                    b = scan.nextLine();
                }
            }
                a_int = Integer.parseInt(a);
                b_int = Integer.parseInt(b);
                while (a_int < 0 || b_int <= 0) {
                    if (a_int < 0) {
                        System.out.println("Nhap lai so a: ");
                        a = scan.nextLine();
                    }
                    if (b_int <= 0) {
                        System.out.println("Nhap lai so b: ");
                        b = scan.nextLine();
                    }
                    if (isint(a) && isint(b)) {
                        a_int = Integer.parseInt(a);
                        b_int = Integer.parseInt(b);
                    }
                }

        }

        a_int = Integer.parseInt(a);
        b_int = Integer.parseInt(b);
        while(a_int < 0 || b_int <= 0) {
            if (a_int < 0) {
                System.out.println("Nhap lai so a: ");
                a = scan.nextLine();
            }
            if (b_int <= 0) {
                System.out.println("Nhap lai so b:? ");
                b = scan.nextLine();
            }
            if (isint(a) && isint(b)) {
                a_int = Integer.parseInt(a);
                b_int = Integer.parseInt(b);
            }
        }

        float d = (float) a_int/b_int;
        System.out.println("The answer is: " + d);
    }

    public static boolean isint(String a)
    {
        try
        {
            int b = Integer.parseInt(a);
            return true;
        }catch (NumberFormatException e)
        {
            return false;
        }
    }
}