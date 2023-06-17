package java_learning.logger;

import java.io.IOException;
import java.util.logging.*;

public class test_log2 {
    Logger logger = Logger.getLogger(test_logger.class.getName());
    public test_log2()
    {
        try {
            LogManager logman = LogManager.getLogManager();
            String name = Logger.GLOBAL_LOGGER_NAME;
            logman.getLogger(name);
            FileHandler filehandler = new FileHandler("C:\\Users\\Nguyen\\IdeaProjects\\new-nguyen\\src\\java_learning\\logger\\log%g.log", 1000, 10);
            filehandler.setLevel(Level.INFO);
            logger.addHandler(filehandler);
            filehandler.setFormatter(new SimpleFormatter());
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void testlog()
    {
        for(int i = 0; i < 10; i++)
        {
            logger.log(Level.INFO, "INFO: Message");
        }
    }

    public static void main(String[] args) throws IOException {
        test_log2 t2 = new test_log2();
        t2.testlog();
    }
}
