package java_learning.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class test_logger {
    Logger logger = Logger.getLogger("Log Tester");
    public test_logger()
    {
        this.logger.setLevel(Level.ALL);
    }

    public void MethodSev()
    {
        this.logger.severe("Severe error!");
    }

    public void MethodWarn()
    {
        this.logger.warning("Warning message!");
    }

    public void MethodInfo()
    {
        this.logger.info("Info message!");
    }

    public static void main(String[] args) {
        test_logger tl = new test_logger();
        tl.MethodSev();
        tl.MethodWarn();
        tl.MethodInfo();
    }
}
