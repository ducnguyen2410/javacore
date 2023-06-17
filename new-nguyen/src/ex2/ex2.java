package ex2;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Scanner;

public class ex2 {

    public static void printUpper(String path_name) throws IOException
    {
        Scanner sc = new Scanner(new File(path_name));
        while(sc.hasNext())
        {
            char c = sc.next().charAt(0);
            if(Character.isUpperCase(c))
            {
                System.out.print(c + " ");
            }
        }
        sc.close();
        System.out.println();
    }

    public static void count_char(String path_name) throws IOException
    {
        int normal_char = 0;
        int diff_char = 0;
        Scanner sc = new Scanner(new File(path_name));
        while(sc.hasNext())
        {
            char c = sc.next().charAt(0);
            if(Character.isDigit(c) || Character.isLetter(c))
            {
                normal_char ++;
            }else
            {
                diff_char++;
            }
        }
        System.out.println("The number of normal character is: " + normal_char);
        System.out.println("The number of other character is: " + diff_char);
        System.out.println();
    }

    public static boolean check_contain(String str1, String str2)
    {
        int start1 = 0, start2 = 0;
        int end1 = str1.length(), end2 = str2.length();
        while(start1 < end1 && start2 < end2)
        {
            if (str1.charAt(start1) == ' ' || str1.charAt(start1) =='\t') start1++;
            else if (str2.charAt(start2) == ' ') start2++;
            else
            {
                if(str1.charAt(start1) == str2.charAt(start2))
                {
                    start1++;
                    start2++;

                }else
                {
                    start1++;
                    start2 = 0;
                }
            }
        }
        if(start2 == end2) return true;
        return false;
    }

    public static int[] get_index(String str1, String str2)
    {
        int start1 = 0, start2 = 0;
        boolean beginning = true;
        int set = 0;
        int end1 = str1.length(), end2 = str2.length();
        while(start1 < end1 && start2 < end2)
        {
            if(str1.charAt(start1) == ' ' || str1.charAt(start1) == '\t') start1++;
            else if(str2.charAt(start2) == ' ') start2++;
            else
            {
                if(str1.charAt(start1) == str2.charAt(start2))
                {
                    if(beginning) set = start1;
                    start1++;
                    start2++;
                    beginning = false;
                }else
                {
                    start1++;
                    beginning = true;
                }
            }
        }
        int []arr = {set, start1};
        return arr;
    }
    public static void replace_str(String path_name) throws IOException
    {
        Scanner sc = new Scanner(new File(path_name));
        while(sc.hasNext())
        {
            String str = sc.nextLine();
            if(check_contain(str, "Toi yeu ha noi pho"))
            {
                int[]indexes = get_index(str, "Toi yeu ha noi pho");
                Path pa = Paths.get(path_name);
                Charset cs = StandardCharsets.UTF_8;
                String content = new String(Files.readAllBytes(pa), cs);
                content = content.replace(str.substring(indexes[0], indexes[1]), "Toi yeu ha noi pho".toUpperCase());
                BufferedWriter bw = new BufferedWriter(new FileWriter(path_name));
                bw.write(content);
                bw.close();
            }
        }
        System.out.println("Replace thanh cong");
    }

    public static String delete_space_line(String str)
    {
        int str_length = str.length();
        int start = 0;
        while(start < str_length)
        {
            if(str.charAt(start) == '\t')
            {
                str = str.substring(0, start) + " " + str.substring(start+1);
            }
            else if(str.charAt(start) == ' ')
            {
                start++;
                if(start < str_length)
                {
                    while(str.charAt(start) == ' ' || str.charAt(start) == '\t')
                    {
                        str = str.substring(0, start) + "" + str.substring(start+1);
                        str_length--;
                        if(start == str_length-1) break;
                    }
                }
            }else start++;
        }
        return str;
    }

    public static void delete_space_all(String path_name) throws IOException
    {
        Path pa = Paths.get(path_name);
        Charset cs = StandardCharsets.UTF_8;
        boolean white_space_found = false;
        String content = new String(Files.readAllBytes(pa), cs);
        Scanner sc = new Scanner(content);
        while(sc.hasNext())
        {
            String temp_str = sc.nextLine();
            content = content.replace(temp_str, delete_space_line(temp_str));
        }
        FileWriter fw = new FileWriter(path_name, false);
        fw.write(content);
        fw.close();
        System.out.println("Xoa thanh cong cac ki tu trang khong can thiet");
    }

    public static void write_behind(char char_infront, String path_name) throws IOException {
        Path pa = Paths.get(path_name);
        Charset cs = StandardCharsets.UTF_8;
        String content = new String(Files.readAllBytes(pa), cs);
        Scanner sc = new Scanner(content);
        while (sc.hasNext()) {
            String temp = sc.nextLine();
            String temp2 = temp;
            if (temp.contains("$")) {
                int index = temp.indexOf('$');
                if (index == temp.length() - 1) {
                    System.out.print("OHH");
                    temp = temp + "o con ga cua toi";
                    content = content.replace(temp2, temp);
                } else {
                    temp = temp.substring(0, index) + "o con ga cua toi" + temp.substring(index + 1);
                }
            }
        }
        FileWriter fw = new FileWriter(path_name, false);
        fw.write(content);
        fw.close();
        System.out.println("Chen thanh cong doan text");
    }

    public static void replace2(char c, String rep, String path_name) throws IOException
    {
        String str = new String(Files.readAllBytes(Paths.get(path_name)), StandardCharsets.UTF_8);
        str = str.replace(c+ "", c+""+rep);
        FileWriter fw = new FileWriter(path_name, false);
        fw.write(str);
        fw.close();
    }

    public static void main(String[] args)  throws IOException {
        String path_name = "C:\\Users\\Nguyen\\Downloads\\bai2.txt";
        printUpper(path_name);
        count_char(path_name);
        replace_str(path_name);
        delete_space_all(path_name);
        write_behind('$', path_name);
        System.out.println("Thanh cong");
        replace2('$', "hello", path_name);
    }
}
