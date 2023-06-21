package ex4.functions.processfilewithtype;

import ex4.bai2.classIdentify.Command;
import ex4.bai2.classIdentify.Phone;
import ex4.functions.commandmethod.Readvalidcommands;
import ex4.functions.filemethod.Writetofile;
import ex4.functions.moneyprocess.Processwithmoney;
import ex4.functions.phonemethod.ReadnewPhone;

import java.io.IOException;
import java.util.ArrayList;

public class Processfilewithtype {
    public void processFileWithType(String fileIn, String type, String fileOut, ArrayList<Phone> listPhone) {
        Writetofile writeBack = new Writetofile();
        if (type.contains("Phone")) {
            ReadnewPhone readPhone = new ReadnewPhone();
            try {
                readPhone.readNewPhone(fileIn, listPhone);
                writeBack.writeBalanceToFile(fileOut, listPhone);
            } catch (IOException e) {
                System.out.println("Cannot read phone file in processFileWithType, type: PHONE");
            }
        } else if (type.contains("Command")) {
            if (listPhone.size() == 0) System.out.println("List phone is empty to load commands.");
            else {
                Readvalidcommands commandRead = new Readvalidcommands();
                try {
                    ArrayList<Command> listCommand = commandRead.readNewValidCommands(fileIn, listPhone);
                    Processwithmoney moneyChange = new Processwithmoney();
                    moneyChange.processWithMoney(listCommand, listPhone);
                    writeBack.writeLogCommand(listCommand, fileOut);
                } catch (IOException e) {
                    System.out.println("cannot read command file in processFileWithType, type: COMMAND");
                }
            }
        }
    }
}
