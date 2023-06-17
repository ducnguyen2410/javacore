package ex3;

import ex3.model.CuPhap;
import ex3.model.Message;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) throws IOException
    {
        String pathCuPhap = "C:\\Users\\Nguyen\\IdeaProjects\\new-nguyen\\src\\ex3\\FileResource\\struct.txt";
        String pathMessage = "C:\\Users\\Nguyen\\IdeaProjects\\new-nguyen\\src\\ex3\\FileResource\\message.txt";
        String pathWrite = "C:\\Users\\Nguyen\\IdeaProjects\\new-nguyen\\src\\ex3\\FileResource\\output.txt";
        ArrayList<CuPhap> listCuPhap = readCuPhap(pathCuPhap);
        System.out.println("Cac cu phap loc duoc la: ");
        for (CuPhap i: listCuPhap)
        {
            System.out.println(i.cuPhap + ": " + i.noiDung);
        }
        ArrayList<Message> listMessage = readMessage(pathMessage, listCuPhap);
        System.out.println("Cac tin nhan loc duoc la: ");
        for (Message i: listMessage)
        {
            System.out.println(i.soDT + " | " + i.lenh +" | " + i.cuPhap);
        }
        sortListMessage(listMessage);
        listMessage = filterValidMessage(listMessage);
        System.out.println("Sau khi loc cac tin nhan phu hop, cac tin nhan con lai la: ");
        for (Message i: listMessage)
        {
            System.out.println(i.soDT + " | " + i.lenh +" | " + i.cuPhap +  " | " + i.dateTime);
        }
        writeBackValidFile(listMessage, pathWrite);
        System.out.println("Da viet vao file thanh cong!");
    }

    public static void writeBackValidFile(ArrayList<Message> listMessage, String path) throws IOException
    {
        FileWriter fw = new FileWriter(path);
        for(Message i: listMessage)
        {
            String eachLine = i.soDT + "(" +i.lenh + "|" + i.dateTime  +"|" + i.cuPhap + ")";
            fw.write(eachLine);
            fw.write("\n");
        }
        fw.close();
    }

    public static ArrayList<Message> filterValidMessage(ArrayList<Message> listMessage)
    {
        ArrayList<Message> processedMessage = new ArrayList<>();

        while(listMessage.size() > 0)
        {
            Message currentMessage = listMessage.get(0);
            listMessage.remove(currentMessage);
            if(currentMessage.status)
            {
                processedMessage.add(currentMessage);
            }else continue;

            LocalDateTime validDateUntil = currentMessage.dateTime.plusMonths(1);
            for (Message i : listMessage) {
                if (processedMessage.contains(i)) continue;
                if (currentMessage.soDT.compareTo(i.soDT) == 0 && i.cuPhap.contains(currentMessage.cuPhap)) {
                    if (i.dateTime.compareTo(validDateUntil) >= 0) {
                        processedMessage.add(i);
                        validDateUntil = i.dateTime.plusMonths(1);
                    }else
                    {
                        i.status = false;
                    }
                }
            }

            for(Message j: processedMessage)
            {
                listMessage.remove(j);
            }

        }
        return processedMessage;
    }

    public static void sortListMessage(ArrayList<Message> listMessage)
    {
        Collections.sort(listMessage, new Comparator<Message>() {
            @Override
            public int compare(Message o1, Message o2) {
                return o1.dateTime.compareTo(o2.dateTime);
            }
        });
    }
    public static ArrayList<Message> readMessage(String path, ArrayList<CuPhap> listCuPhap) throws IOException
    {
        BufferedReader bf = new BufferedReader(new FileReader(path));
        ArrayList<Message> listMessage = new ArrayList<>();
        String line;
        while ((line = bf.readLine()) != null)
        {
            Message tempMessage = filterMessage(line);
            if(tempMessage.inList(listCuPhap, tempMessage.cuPhap) && tempMessage.isValid(tempMessage))
            {
                listMessage.add(tempMessage);
            }
        }
        return listMessage;
    }

    public static Message filterMessage(String line)
    {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String soDT = line.substring(0, line.indexOf("("));
        String lenh = line.substring(line.indexOf("(")+1, line.indexOf("|"));
        String dateTimeString = line.substring(line.indexOf("|")+1, line.indexOf("|", line.indexOf("|")+1));
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, dt);
        String cuPhapNumber = line.substring(line.indexOf("|",line.indexOf("|")+1)+1, line.indexOf(")"));
        return new Message(soDT,lenh,dateTime, cuPhapNumber, true);
    }

    public static ArrayList<CuPhap> readCuPhap(String path) throws IOException
    {
        BufferedReader bf = new BufferedReader(new FileReader(path));
        ArrayList<CuPhap> listCuPhap = new ArrayList<>();
        String line = bf.readLine();
        while(line != null)
        {
            CuPhap tempCuPhap = filterCuPhap(line);
            listCuPhap.add(tempCuPhap);
            line = bf.readLine();
        }
        return listCuPhap;
    }

    public static CuPhap filterCuPhap(String line)
    {
        String [] temp = line.split(":", 2);
        if(temp.length == 2)
        {
            temp[0] = temp[0].replace("+", "").replace("\uFEFF", "").trim();
            temp[1] = temp[1].trim();
        }else
        {
            System.out.println("Cu phap: " + line + "is not valid. Check again.");
            return new CuPhap(null, null);
        }
        return new CuPhap(temp[0], temp[1]);
    }
}
