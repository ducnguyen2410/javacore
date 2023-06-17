package java_learning.logger;

import java.io.IOException;
import java.util.logging.*;

public class logger_handler {
    Logger thelogger;
    public logger_handler() throws IOException
    {
        try {
            LogManager logman = LogManager.getLogManager();
            String lname = Logger.GLOBAL_LOGGER_NAME;
            thelogger = logman.getLogger(lname);
            thelogger.setLevel(Level.ALL);
            FileHandler filehandler = new FileHandler("C:\\Users\\Nguyen\\IdeaProjects\\new-nguyen\\src\\java_learning\\logger\\Thelog_%g.log", 1000, 10);
            filehandler.setLevel(Level.WARNING);
            thelogger.addHandler(filehandler);
            filehandler.setFormatter(new SimpleFormatter());

        }catch (IOException e)
        {
            Logger.getLogger(logger_handler.class.getName()).log(Level.SEVERE, null, e);
        }catch (SecurityException ex)
        {
            Logger.getLogger(test_logger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void TestLogs()
    {
        for(int i = 0; i < 100; i++)
        {
            thelogger.log(Level.SEVERE, "Fatal error 17: Message");
            thelogger.log(Level.WARNING, "Warning 1: Warning message");
            thelogger.log(Level.WARNING, "Warning 2: Warning message");
            thelogger.log(Level.INFO, "Info 1: The message");
        }
    }

    public static void main(String[] args) throws  IOException{
        logger_handler obj = new logger_handler();
        obj.TestLogs();
    }
}
