package ex4.bai1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String pathName = "C:\\Users\\Nguyen\\IdeaProjects\\new-nguyen\\src\\ex4\\FileResource\\input.txt";
        String pathNameOutput = "C:\\Users\\Nguyen\\IdeaProjects\\new-nguyen\\src\\ex4\\FileResource\\output.txt";
        File file = new File(pathName);
        String line;
        long timeModified = file.lastModified();
        while(true)
        {
            while(timeModified == file.lastModified());
            timeModified = file.lastModified();
            String content = new String(Files.readAllBytes(Paths.get(pathName)), StandardCharsets.UTF_8);
            BufferedWriter bw = new BufferedWriter(new FileWriter(pathNameOutput));
            bw.write(content);
            bw.close();
        }
    }

}
