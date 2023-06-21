package ex4.functions.filemethod;

import ex4.bai2.classIdentify.Command;
import ex4.bai2.classIdentify.Phone;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writetofile {
    public void writeBalanceToFile(String path, ArrayList<Phone> listPhone) throws IOException
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        for(Phone i: listPhone)
        {
            bw.write(i.getSdt() + "|" + i.getSoDuTaiKhoan() + "|" + i.getLanCuoiSuaDoi());
            bw.newLine();
        }
        bw.close();
    }

    public void writeLogCommand(ArrayList<Command> listCommand, String path) throws IOException
    {
        File file = new File(path);
        if(!file.exists())
        {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file, true);
        for(Command i: listCommand)
        {
            String line = i.getLenh()+"|"+i.getSdtGoc().getSdt()+"|"+i.getSoTienChuyen()+"|"+i.getSuccess();
            fw.write(line+"\n");
        }
        fw.close();
    }
}
