package com.TeamEnigma.cognito;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class CheckAttendance {


    public  void checkAttendance(String ID) throws IOException {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
        int monthNumber = LocalDate.now().getMonthValue();
        System.out.println(monthNumber);
        String monthnumber = String.valueOf(monthNumber);

        String filePath = "DataBase" + "/" + ID + "/" + ID + monthnumber + ".txt";
        System.out.println(filePath);

        //Checking Attendance
        String strDate1 = formatter.format(date) + " Present";
        String strDate2 = formatter.format(date) + " Absent";
        FileReader fr = new FileReader(filePath);
        System.out.println(strDate1);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while (line != null) {
            if (line.equals(strDate1)) {
                System.out.println("Present");
                break;
            } else if (line.equals(strDate2)) {
                //Absent-Wrong result-Have to modify it to present
                modifyAttendance(filePath, strDate2, strDate1);
                break;
            } else {
                line = br.readLine();
            }
        }
        br.close();
    }

    public static void modifyAttendance(String filePath, String oldString, String newString) {
        File fileToBeModified = new File(filePath);

        String oldContent = "";

        BufferedReader reader = null;

        FileWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));

            //Reading all the lines of input text file into oldContent

            String line = reader.readLine();

            while (line != null) {
                oldContent = oldContent + line + System.lineSeparator();

                line = reader.readLine();
            }

            //Replacing oldString with newString in the oldContent

            String newContent = oldContent.replaceAll(oldString, newString);

            //Rewriting the input text file with newContent

            writer = new FileWriter(fileToBeModified);

            writer.write(newContent);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //Closing the resources

                reader.close();

                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //checkAttendance("ASH1925023M");
        // checkAttendance("ASH1925025M");
        new CheckAttendance().checkAttendance("ASH1925024M");

    }
}
