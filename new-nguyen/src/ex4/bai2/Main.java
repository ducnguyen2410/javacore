package ex4.bai2;

import ex4.bai2.classIdentify.Command;
import ex4.bai2.classIdentify.Phone;

import javax.naming.event.ObjectChangeListener;
import javax.swing.text.DateFormatter;
import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException{
        String pathInput = "C:\\Users\\Nguyen\\IdeaProjects\\new-nguyen\\src\\ex4\\FileResource\\messages.txt";
        String pathGetPhoneNumber = "C:\\Users\\Nguyen\\IdeaProjects\\new-nguyen\\src\\ex4\\FileResource\\msisdn.txt";
        String pathToWrite = "C:\\Users\\Nguyen\\IdeaProjects\\new-nguyen\\src\\ex4\\FileResource\\outputbai2.txt";
        File fileInput = new File(pathInput);
        File fileGetPhoneNumber = new File(pathGetPhoneNumber);
        ArrayList<Command> listCommand = new ArrayList<>();
        ArrayList<Phone> listPhone = new ArrayList<>();
        long lastModifiedInput = fileInput.lastModified(), lastModifiedPhone = fileGetPhoneNumber.lastModified();
        while(true)
        {
            while(!fileGetPhoneNumber.exists());
            readNewPhone(pathGetPhoneNumber);
            if(Phone.getList().size() > 0)
            {
                while (!fileInput.exists());
                listCommand = readNewValidCommands(pathInput, listPhone);
                processWithMoney(listCommand);
                writeToFile(pathToWrite);
                while (lastModifiedInput == fileInput.lastModified()) ;
                lastModifiedInput = fileInput.lastModified();
            }
        }
    }

    public static void writeToFile(String path) throws IOException
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        for(Phone i: Phone.getList())
        {
            bw.write(i.getSdt() + "|" + i.getSoDuTaiKhoan() + "|" + i.getLanCuoiSuaDoi());
            bw.newLine();
        }
        bw.close();
    }

    public static void processWithMoney(ArrayList<Command> listCommand)
    {
        for(Command command: listCommand)
        {
            if(command.getLenh().contains("add")) command.getSdtGoc().addTransaction(command);
            else if(command.getLenh().contains("minus")) command.getSdtGoc().minusTransaction(command);
            else
            {
                command.getSdtGoc().minusTransaction(command);
                command.getSdtChuyenDen().addTransaction(command);
            }
        }
    }

    public static void readNewPhone(String path) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while((line = br.readLine()) != null)
        {
            Phone tempPhone = filterPhone(line);
            if(tempPhone.isValid() &&!tempPhone.inList())
            {
                Phone.addToList(tempPhone);
            }
        }
    }

    public static Phone filterPhone(String line)
    {
        int firstSign = line.indexOf("|");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        int secondSign = line.indexOf("|", firstSign+1);
        String sdt = line.substring(0, firstSign);
        int soTien = Integer.parseInt(line.substring(firstSign+1, secondSign));
        LocalDateTime lastModified = LocalDateTime.parse(line.substring(secondSign+1), df);
        return new Phone(sdt,soTien,lastModified);
    }

    public static ArrayList<Command> readNewValidCommands(String path, ArrayList<Phone> listPhone) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(path));
        ArrayList<Command> listCommand = new ArrayList<>();
        String line;
        while((line = br.readLine()) != null)
        {
            Command tempCommand = filterCommand(line);
            if(tempCommand.isValid() && tempCommand.inList(Phone.getList()))
            {
                listCommand.add(tempCommand);
            }
        }
        return listCommand;
    }

    public static Command filterCommand(String line)
    {
        int firstSign = line.indexOf("|");
        int secondSign = line.indexOf("|", firstSign+1);
        int thirdSign = line.indexOf("|", secondSign+1);
        String lenh = line.substring(0, firstSign);
        if(lenh.contains("transfer"))
        {
            if(firstSign == -1 || secondSign == -1 || thirdSign == -1) return new Command(lenh,null,0,null, false);
            String sdtGoc = line.substring(firstSign, secondSign);
            Phone phoneSdtGoc = Phone.getPhoneNumberObject(sdtGoc);
            String sdtChuyenDen = line.substring(secondSign+1);
            Phone phoneSdtChuyenDen = Phone.getPhoneNumberObject(sdtChuyenDen);
            int soTienChuyen = Integer.parseInt(line.substring(secondSign+1));
            return new Command(lenh,phoneSdtGoc,soTienChuyen,phoneSdtChuyenDen, false);
        }else if(lenh.contains("add") || lenh.contains("minus"))
        {
            if(firstSign == -1 || secondSign == -1) return new Command(lenh,null,0,null, false);
            String sdtGoc = line.substring(firstSign+1, secondSign);
            Phone phoneSdtGoc = Phone.getPhoneNumberObject(sdtGoc);
            int soTienChuyen = Integer.parseInt(line.substring(secondSign+1));
            return new Command(lenh,phoneSdtGoc,soTienChuyen,null, false);
        }else return new Command(lenh,null,0,null, false);
    }
}
