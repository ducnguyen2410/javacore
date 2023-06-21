package ex4.functions.phonemethod;

import ex4.bai2.classIdentify.Phone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ReadnewPhone {
    public void readNewPhone(String path, ArrayList<Phone> listPhone) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while((line = br.readLine()) != null)
        {
            Phone tempPhone = filterPhone(line);
            if(tempPhone.isValid() &&!tempPhone.inList(listPhone))
            {
                listPhone.add(tempPhone);
            }
        }
        br.close();
    }

    public Phone filterPhone(String line)
    {
        int firstSign = line.indexOf("|");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        int secondSign = line.indexOf("|", firstSign+1);
        String sdt = line.substring(0, firstSign);
        int soTien = Integer.parseInt(line.substring(firstSign+1, secondSign));
        LocalDateTime lastModified = LocalDateTime.parse(line.substring(secondSign+1), df);
        return new Phone(sdt,soTien,lastModified);
    }
}
