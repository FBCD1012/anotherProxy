package Test;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class theDiyLogger {
    public static void main(String[] args) {
        Logger logger= Logger.getLogger(theDiyLogger.class.getName());
        ConsoleHandler consoleHandler=new ConsoleHandler(){
            {
                //输出流
                setOutputStream(System.out);
            }
        };
        consoleHandler.setFormatter(new Formatter() {
            //参数的属性
            /**1.时间
             * 2.日志级别
             * 3.线程信息
             * 4.线程id
             * 5.主类名称
             * 6.传入参数信息
             * */
            @Override
            public String format(LogRecord record) {
                SimpleDateFormat simpleDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                String time=simpleDate.format(new Date(record.getMillis()));
                String level=record.getLevel().getName();
                String thread=String.format("%10s",Thread.currentThread().getName());
                long threadId=record.getThreadID();
                String className=String.format("%20s",record.getSourceClassName());
                String msg=record.getMessage();
                //这里的超级终端字体，明天再来看一下
                return "\033 "+time+" \033[33m "+level+" \033[33m "+thread+" \033[35m"+threadId+" \033[32m"+className+" :\033[33m"+msg+"\n";
            }
        });
        logger.addHandler(consoleHandler);
        logger.info("基本测试diy操作");
        logger.warning("警告操作理解");
    }
}
