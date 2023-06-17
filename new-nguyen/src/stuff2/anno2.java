package stuff2;
import java.io.*;

class anno2
{
    public static void main(String []args) throws IOException
    {
        BufferedWriter f_out = new BufferedWriter(new FileWriter("C:\\Users\\Nguyen\\IdeaProjects\\new-nguyen\\src\\stuff2\\debai.txt", true));
        f_out.write("ggg");
        f_out.close();

        BufferedReader f_in = new BufferedReader(new FileReader("C:\\Users\\Nguyen\\IdeaProjects\\new-nguyen\\src\\stuff2\\debai.txt"));
        String line;
        while((line = f_in.readLine()) != null )
        {
            System.out.println(line);
        }
        f_in.close();
    }
}