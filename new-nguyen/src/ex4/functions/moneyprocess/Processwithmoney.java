package ex4.functions.moneyprocess;

import ex4.bai2.classIdentify.Command;
import ex4.bai2.classIdentify.Phone;
import ex4.functions.filemethod.Writetofile;

import java.io.IOException;
import java.util.ArrayList;

public class Processwithmoney {
    public void processWithMoney(ArrayList<Command> listCommand, ArrayList<Phone> listPhone)
    {
        for(Command command: listCommand)
        {
            if(command.getLenh().contains("add")) command.getSdtGoc().addTransaction(command);
            else if(command.getLenh().contains("minus")) command.getSdtGoc().minusTransaction(command);
            else
            {
                command.getSdtGoc().minusTransaction(command);
                if(command.getSuccess()) {
                    command.getSdtChuyenDen().addTransaction(command);
                }
            }
        }
        Writetofile writeBack = new Writetofile();
        try
        {
            writeBack.writeBalanceToFile("C:\\Users\\Nguyen\\IdeaProjects\\javacore\\new-nguyen\\src\\ex4\\FileResource\\output\\balance.txt", listPhone);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
