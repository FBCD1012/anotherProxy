package Test;


import lombok.SneakyThrows;

import java.util.logging.*;


public class theLoggerTest {
    @SneakyThrows
    public static void main(String[] args) {
        //获取当前类的类名操作
        //注意logger类中并没有出现任何可操作的构造方法，不能进行对象的创建
        Logger logger= Logger.getLogger(theLoggerTest.class.getName());
       //   private static final Level[] standardLevels = {
        //        OFF, SEVERE, WARNING, INFO, CONFIG, FINE, FINER, FINEST, ALL
        //    };


        //初始化继承操作，将前部继承操作关闭，禁用默认的父类日志输出器
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);

        //格式化操作器（自定义都是这里作文章）
        SimpleFormatter simpleFormatter=new SimpleFormatter();

        //终端解释器（终端处理器）这里关乎终端之间的操作理解，如何实现也是非常必要的
        ConsoleHandler consoleHandler=new ConsoleHandler();
        //日志所有权限的表达方法，这里需要对前面进行匹配
        consoleHandler.setLevel(Level.ALL);

        //这里千万注意formatter不能进行多个设置,格式化器只能单个进行操作实现，如何操作是非常必要的
        consoleHandler.setFormatter(new XMLFormatter());

        //TODO 联合上述操作进行理解
        FileHandler fileHandler=new FileHandler("fbcd.txt",true);
        fileHandler.setFormatter(simpleFormatter);

        //将终端处理器和基础的日志对象进行嵌合
        logger.addHandler(consoleHandler);
        logger.addHandler(fileHandler);

        logger.log(Level.OFF, "off?级别"); //禁用级别的日志输出
        logger.log(Level.SEVERE, "严重日志级别操作");
        logger.log(Level.WARNING,"警告日志级别操作");
        logger.log(Level.INFO,   "基本信息级别操作");
        //隔离尺度
        logger.log(Level.CONFIG, "构建级别日志输出");
        logger.log(Level.FINE, "Fine日志构建级别输出");
        logger.log(Level.FINEST, "FINEST级别的日志输出");
        logger.log(Level.ALL,"全级别的日志输出操作");

        System.out.println();
        //这种方式仅仅在前面进行操作理解，不包括外围理解，千万需要注意
        logger.warning("警告日志操作");
        logger.info("基础日志操作");
        logger.config("构建日志操作");
        logger.fine("详细日志操作");
        logger.finest("非常详细日志操作");
    }
}
