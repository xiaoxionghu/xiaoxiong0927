package com.xiaohu.logger;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Create with IntelliJ IDEA.
 * User: xiaohu
 * Date: 2017/9/13
 * Time: 11:24
 * To change this template use File | Settings | File Templates.
 */
public class LoggerTest {

    /**
     * level级别由低到高：trace，debug，info，warn，error，fatal
     *  设置level级别A 则A+以上的级别都会输出
     *
     * 在实际开发中是通过log4j。properties配置文件来代替：
     *      log4j日志配置三个部分： 记录器(rootLogger)、 输出源、 日志布局
     *          1，记录器：语法： 记录器= 日志级别, 输出源1, 输出源2 …
     *          2，输出源：语法： log4j.appender.输出源名称 = 实现类全名
     *              log4j.appender.stdout=org.apache.log4j.ConsoleAppender  控制台输出
     *              log4j.appender.file=org.apache.log4j.FileAppender       文件输出
     *          3，日志输出布局：语法： log4j.appender.输出源名称.layout = 布局实现类全名
     *              log4j.appender.stdout.layout=org.apache.log4j.PatternLayout 自定义布局
     *              如果使用自定义布局   还需要定义布局信息：
     *              log4j.appender.stdout.layout.ConversionPattern=%d{ABSOLUTE} %5p %c{1}:%L - %m%n
     */

    @Test
    public void run(){

        Logger logger = Logger.getLogger(LoggerTest.class);

        BasicConfigurator.configure();

        logger.setLevel(Level.DEBUG);

        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");
        logger.warn("warn");
        logger.error("error");
        logger.fatal("fatal");
    }
}
