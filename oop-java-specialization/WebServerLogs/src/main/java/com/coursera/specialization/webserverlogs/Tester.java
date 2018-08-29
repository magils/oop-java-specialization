package com.coursera.specialization.webserverlogs;
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.LogEntry;

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        String filePath = getClass().getClassLoader().getResource("short-test_log").getFile();
        logAnalyzer.readFile(filePath);
        logAnalyzer.printAll();
    }


    public void testCountUniqueIPs() {

        LogAnalyzer logAnalyzer = new LogAnalyzer();
        String filePath = getClass().getClassLoader().getResource("short-test_log").getFile();
        logAnalyzer.readFile(filePath);
        int uniqueIps = logAnalyzer.countUniqueIps();

        System.out.println(uniqueIps);

    }

    public static void main(String []  args){
        Tester tester = new Tester();
        tester.testCountUniqueIPs();
    }
}
