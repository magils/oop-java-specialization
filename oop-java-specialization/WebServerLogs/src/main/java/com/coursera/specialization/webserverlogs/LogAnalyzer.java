package com.coursera.specialization.webserverlogs;
/**
 * Write a description of class LogAnalyzer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import edu.duke.FileResource;
import edu.duke.LogEntry;
import edu.duke.WebLogParser;

import java.util.ArrayList;
import java.util.List;

public class LogAnalyzer {
    private ArrayList<LogEntry> records;

    public LogAnalyzer() {
        // complete constructor
        records = new ArrayList<>();
    }

    public void readFile(String filename) {

        FileResource fileResource = new FileResource(filename);

        for (String line : fileResource.lines()) {
            records.add(WebLogParser.parseEntry(line));
        }
    }

    public void printAll() {
        for (LogEntry le : records) {
            System.out.println(le);
        }
    }


    public int countUniqueIps() {

        List<String> ipAddresses = new ArrayList<String>();

        for (LogEntry logEntry : records) {
            if (!ipAddresses.contains(logEntry.getIpAddress())) {
                ipAddresses.add(logEntry.getIpAddress());

            }
        }

        return ipAddresses.size();

    }


    public void printAllHigherThanNum(int num) {

        for (LogEntry logEntry : records) {
            if (logEntry.getStatusCode() > num) {
                System.out.println(logEntry);
            }
        }
    }

    public List<ArrayList<LogEntry>> uniqueIPVisitsOnDay(String someday){

        return null;
    }


}
