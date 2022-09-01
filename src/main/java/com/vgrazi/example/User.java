package com.vgrazi.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.logging.*;

public class User {
    private int userID;
    private double age;
    private static int x;
    private String name;
    private final List<String> friends=List.of("William", "Alok", "Heather");
    private String address;

    public User(int userID, String name, String address) {
        this.userID=userID;
        this.name=name;
        this.address=address;
    }
    public User() {

    }


    public static void main(String[] args) {
        User user=new User();
//        user.configureSystemPropertyLogging();
        user.configureFileLogging();
    }

    private void logit(Logger logger) {
        logger.info("Post call");
    }

    private void configureSystemPropertyLogging() {
//        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(User.class.getName());
        Logger logger=null;
        try {

            // Programmatic configuration
            String PATTERN="" +
//                "%1$tY-%2$tm-%$td %1$tH:%1$tM:%1$tS.%1$tL %4$-7s [%3$s] %5$s %6$s%n"
//                        "%1$tc %2$s%n%4$s: %5$s%6$s%n" +
                    "%1$tY-%1$tm-%1$-1td %1$tH:%1$tM:%1$tS.%1$tL " +
                    "[%2$s] " + // logger and method
                    "[%3$s] " + // logger
                    "%4$-7s " + // level
//                                "%n "     + // linefeed
                    "%5$- " + // the message
//                                "%6$s- "  +
                    "";
            System.setProperty("java.util.logging.SimpleFormatter.format", PATTERN);
            logger=Logger.getLogger(User.class.getName());


            final ConsoleHandler consoleHandler=new ConsoleHandler();
            consoleHandler.setLevel(Level.FINEST);
            consoleHandler.setFormatter(new SimpleFormatter());

//                final Logger app = Logger.getLogger("app");
//                app.setLevel(Level.FINEST);
//                app.addHandler(consoleHandler);
        } catch(Exception e) {
            e.printStackTrace();
        }
        logger.log(Level.INFO, "Some message");
//        logger.log(Level.INFO, "Some message", new RuntimeException("don't worry"));

    }

    private void configureFileLogging() {
//        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(User.class.getName());
        Logger logger=null;

        String path=User.class
                .getClassLoader()
                .getResource("logging.properties")
                .getFile();
//            path="C:\\Users\\vgraz\\IdeaProjects\\ecosystem\\target\\classes\\logging.properties";
//            path="/target/classes/logging.properties";//no good
//            path=null;
        System.setProperty("java.util.logging.config.file", path);
//            System.setProperty(".level", "WARNING");
//            System.setProperty("java.util.logging.ConsoleHandler.level", "TRACE");
        logger=Logger.getLogger(User.class.getName());
        System.setProperty("com.vgrazi.study.ecosystem.level", "WARNING");
        logger.setLevel(Level.WARNING);

//            logger.setLevel(Level.WARNING);
        // Load a properties file from class path java.util.logging.config.file
        logger.log(Level.INFO, "Some info message");
        logger.info("Some info message");

        logger.warning("Some warning message");
//        logger.log(Level.INFO, "Some message", new RuntimeException("don't worry"));

    }

    public static void mainx1(String[] args) throws IOException {
//        System.setProperty("java.util.logging.SimpleFormatter.format", "%4$s: %5$s [%1$tc]%n");
//        System.setProperty("java.util.logging.SimpleFormatter.format", "'%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS %4$s %2$s %5$s%6$s%n'");

        FileInputStream fis=new FileInputStream("C:\\Users\\vgraz\\IdeaProjects\\ecosystem\\src\\main\\resources\\logging.properties");
//        fis.readAllBytes();
//        fis.close();

        LogManager logManager=LogManager.getLogManager();
        URL configURL=User.class.getResource("/logger.properties");


        try(InputStream is=configURL.openStream()) {
            logManager.readConfiguration(is);
        }
//        LogManager.getLogManager().readConfiguration(fis);
        User user=new User(123, "John Jones", "123 Main");
        user.someMethod();
//        logger.log(Level.INFO, "Some Message");
//        logger.info("User:" + user);
//        logger.info(Logger.ROOT_LOGGER_NAME, "User:" + user);
    }

    public static void mainx(String[] args) {
        System.out.println("args = " + Arrays.deepToString(args));
        System.out.println();
    }

    /**
     * Some method
     */


    public void someMethod() {
        double val=Math.random();
    }


}

