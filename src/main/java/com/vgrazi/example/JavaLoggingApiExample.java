package com.vgrazi.example;

import java.io.IOException;
import java.util.logging.*;

public class JavaLoggingApiExample {
    Logger logger=Logger.getLogger(JavaLoggingApiExample.class.getName());

    public static void main(String[] args) throws IOException {
        new JavaLoggingApiExample().configureLogging();
    }

    private void configureLogging() throws IOException {

        String PATTERN="" +
//                "%1$tY-%2$tm-%$td %1$tH:%1$tM:%1$tS.%1$tL %4$-7s [%3$s] %5$s %6$s " +
//                "%1$tc %2$s%n%4$s: %5$s%6$s%n" +
                "%1$tc%n " + // Tue Jul 05 20:59:21 EDT 2022-
//"%1$ts " + // 1657069724-
//"N%1$ts " + // epoch seconds since Jan 1, 1970 Midnight
                "Q:%1$tQ " + // 1657249071245 epoch milliseconds since Jan 1, 1970 Midnight
//"j%1$tj " + // Day of year (186)
//"N%1$tN " + //???
//"%1$tD " + // 07/05/22
//"%1$ta " + // 3 character day of week - Tue
//"%1$tA " + // fully spelled day of week - TUesday
//"%1$tz " + // Time zone relative to UTC - -0400
//"%1$tZ " + // Time Zone EDT
//"%1$tb " + // Jul-
//"%1$th"  + // Jul:
//"%1$tm"  + // 07-
//"%1$tY" + // 2022-
//"%1$-1td" + // 05-
//"r%1$tr " + // formatted Time 11:13:06 PM
                "H:%1$tH " + // 21: Hours 2 digit 00-23
                "I:%1$tI " + // Hours (01-12)
                "k:%1$tk " + // Hours 1 digit 0-23
                "l:%1$tl " + // Hours (1-12)
//"%1$tM:"  + // 03: 2 digit minutes
//"%1$tS."  + // 55. 2 digit seconds in the minute 00-59
                "R:%1$tR " + // hh:mm (24 hour clock)
//"%1$tL "  + // 294 3 digit millieseconds
                "N: %1$tN " + // 003832000 9 digit Nanoseconds
//"p%1$tp " + // am/pm
                "d:%1$td " + //
                "e:%1$te%n " + //
                "D:%1$tD%n " + //
                "F:%1$tF%n " + //
                "c :%1$tc%n " + //
                "R:%1$tR " + //
                "r:%1$tr " + //
                "T:%1$tT " + // formatted Time 23:13:06
                "%2$s " + // logger and method
                "%3$s " + // logger
                "x%4$-4.3sx " + // level xWARNING          x
//                "x%4$17sx " + // level x          WARNINGx
//                                "%n "     + // linefeed
                "%5$s" + // the message
//                                "%6$s- "  +
                "";
        System.setProperty("java.util.logging.SimpleFormatter.format", PATTERN);

//        logger.log(Level.WARNING, "Some message");
//        handleXML();
//        logger.logp(Level.INFO, JavaLoggingExample.class.getName(), "thisMethod",  "Some message");
        logger.log(Level.INFO, "Some message");
    }

    private void handleXML() throws IOException {
        XMLFormatter xmlFormatter=new XMLFormatter();

        // Setting level to Info
        LogRecord logRecord=new LogRecord(
                Level.INFO,
                "LogRecord message to be printed in xml file..");

        // We can see the output of LogRecord in
        // logrecordxml.xml file
        FileHandler fileHandler
                =new FileHandler("logrecordxml.xml");
        fileHandler.setFormatter(xmlFormatter);

        // Prepared data is displayed in the
        // logrecordxml.xml file
        fileHandler.publish(logRecord);

        // Lastly releasing out all the records
        // using the flush() method
        fileHandler.flush();

        String format=xmlFormatter.format(logRecord);
    }

}
