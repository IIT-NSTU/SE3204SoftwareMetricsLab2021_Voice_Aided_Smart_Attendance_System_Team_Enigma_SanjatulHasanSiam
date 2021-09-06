package com.TeamEnigma.cognito;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeMap;

public class DisplayAttendance {
//For accessing attendance Sheet
    public static void attendanceSheet(String id, String monthnumber)throws IOException

    {/* int monthNumber = LocalDate.now().getMonthValue();
        System.out.println(monthNumber);
        String monthnumber = String.valueOf(monthNumber);*/

        String filepath="DataBase"+"/"+id+"/"+id+monthnumber+".txt";
        FileReader fileReader=new FileReader(filepath);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String line=bufferedReader.readLine();
        System.out.println("Attandance Sheet of ID=\""+id+"\"");
        while(line!=null)
        {
            System.out.println(line);
            line=bufferedReader.readLine();

        }
        bufferedReader.close();

    }

    public static void main(String[] args) throws IOException{

        attendanceSheet("ASH1925023M","1");

    }
}
