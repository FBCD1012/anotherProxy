package Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class theLoggerException {
    public static void main(String[] args) {

        Logger logger= Logger.getLogger(theLoggerException.class.getName());

        logger.log(Level.INFO,"基本的信息操作" ,new Exception("发生错误操作理解"));

    }
}
