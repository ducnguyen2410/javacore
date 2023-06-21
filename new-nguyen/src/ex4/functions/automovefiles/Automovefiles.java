package ex4.functions.automovefiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Automovefiles {
    public void autoMoveFiles(String pathInput, String pathOutput)
    {
        File folderInput = new File(pathInput);
        File folderOutput = new File(pathOutput);
        if(!folderInput.isDirectory() || !folderOutput.isDirectory()) {System.out.println("Input and Output folders are not directory!");}
        try {
            for (String i : folderInput.list()) {
                Files.move(Paths.get(pathInput + "\\" + i), Paths.get(pathOutput + "\\" + i));
                File tempFile = new File(pathInput + "\\" + i);
                boolean check = tempFile.delete();
                if (!check) {
                    System.out.printf("Successfully cut file %s from folder input to folder output", i);
                } else {
                    System.out.println("Not succeed");
                }

            }
        }catch (IOException e)
        {
            System.out.println("The Input folder does not have any files to move.");
            return;
        }
    }
}
