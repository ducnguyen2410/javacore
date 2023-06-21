package ex4.functions.commandmethod;

import ex4.bai2.classIdentify.Command;
import ex4.bai2.classIdentify.Phone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Readvalidcommands {
    public ArrayList<Command> readNewValidCommands(String path, ArrayList<Phone> listPhone) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(path));
        ArrayList<Command> listCommand = new ArrayList<>();
        String line;
        while((line = br.readLine()) != null)
        {
            Command tempCommand = filterCommand(line, listPhone);
            if(tempCommand.isValid() && tempCommand.inList(listPhone))
            {
                listCommand.add(tempCommand);
            }
        }
        br.close();
        return listCommand;
    }

    public Command filterCommand(String line, ArrayList<Phone> listPhone)
    {
        int firstSign = line.indexOf("|");
        int secondSign = line.indexOf("|", firstSign+1);
        int thirdSign = line.indexOf("|", secondSign+1);
        String lenh = line.substring(0, firstSign);
        if(lenh.contains("transfer"))
        {
            if(firstSign == -1 || secondSign == -1 || thirdSign == -1) return new Command(lenh,null,0,null, false);
            String sdtGoc = line.substring(firstSign+1, secondSign);
            Phone phoneSdtGoc = getObjectPhone(listPhone, sdtGoc);
            String sdtChuyenDen = line.substring(secondSign+1, thirdSign);
            Phone phoneSdtChuyenDen = getObjectPhone(listPhone, sdtChuyenDen);
            int soTienChuyen = Integer.parseInt(line.substring(thirdSign+1));
            return new Command(lenh,phoneSdtGoc,soTienChuyen,phoneSdtChuyenDen, false);
        }else if(lenh.contains("add") || lenh.contains("minus"))
        {
            if(firstSign == -1 || secondSign == -1) return new Command(lenh,null,0,null, false);
            String sdtGoc = line.substring(firstSign+1, secondSign);
            Phone phoneSdtGoc = getObjectPhone(listPhone, sdtGoc);
            int soTienChuyen = Integer.parseInt(line.substring(secondSign+1));
            return new Command(lenh,phoneSdtGoc,soTienChuyen,null, false);
        }else return new Command(lenh,null,0,null, false);
    }

    public Phone getObjectPhone(ArrayList<Phone> listPhone, String sdt)
    {
        for(Phone i: listPhone)
        {
            if(i.getSdt().contains(sdt)) return i;
        }
        return null;
    }
}
