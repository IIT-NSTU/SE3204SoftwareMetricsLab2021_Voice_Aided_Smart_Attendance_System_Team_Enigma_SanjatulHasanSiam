package com.TeamEnigma.Gui;

import com.TeamEnigma.cognito.DisplayAttendance;
import com.TeamEnigma.cognito.IdCheck;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeMap;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

public class Attendance extends JFrame {

    private Container c;
    private JLabel id, attendance;
    private Font f;
    private JTextField jTextField;
    private JComboBox month;
    private JButton submit, home;
    private JTextArea textArea;
    IdCheck idCheck;
    DisplayAttendance displayAttendance;
    String monthNumber;
    JTable jTable;
    String[] colName;
    String[][] data;
    String filePath;
    File file;
    String studentID;//="ASH1925023M";
    String selectedMonthNumber;// = "1";

    Attendance() {
        super.setTitle("Attendance Sheet Frame");
        super.setBounds(250, 180, 600, 600);
        change();
    }

    public void change() {
        f = new Font("Arial", Font.BOLD, 15);
        c = this.getContentPane();
        c.setBackground(new Color(128, 219, 219));
        c.setLayout(null);

        id = new JLabel();
        id.setText("Enter Your ID : ");
        id.setBounds(30, 10, 120, 50);
        id.setFont(f);
        c.add(id);

        jTextField = new JTextField();
        jTextField.setBounds(180, 10, 200, 50);
        jTextField.setFont(f);
        c.add(jTextField);

        HashMap map = new HashMap();
        map.put("1", "January");
        map.put("2", "February");
        map.put("3", "March");
        map.put("4", "April");
        map.put("5", "May");
        map.put("6", "June");
        map.put("7", "July");
        map.put("8", "August");
        map.put("9", "September");
        map.put("10", "October");
        map.put("11", "November");
        map.put("12", "December");

        String s1[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December"};

        month = new JComboBox(s1);
        month.setBounds(400, 10, 150, 50);
        c.add(month);

        submit = new JButton();
        submit.setBounds(180, 80, 200, 40);
        submit.setText("Submit");
        c.add(submit);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentID = jTextField.getText();
                System.out.println("ID is = " + studentID);
                String item = month.getSelectedItem().toString();
                Iterator itr = map.entrySet().iterator();
                while (itr.hasNext()) {
                    //Converting to Map.Entry so that we can get key and value separately
                    Map.Entry entry = (Map.Entry) itr.next();
                    if (item == entry.getValue()) {
                        selectedMonthNumber = (String) entry.getKey();
                        System.out.println("Month Number is = " + selectedMonthNumber);
                    }
                }

                /* --------------------------Checking ID is Correct or not---------------*/
                boolean isIdOk = Pattern.matches("[A-Z]{3}[0-9]{7}[A-Z]{1}", studentID);
                System.out.println("ID is Correct = " + isIdOk);
                if (isIdOk) {
                    System.out.println("ID is Correct = " + isIdOk);
                } else {
                    JOptionPane.showMessageDialog(c, "Invalid ID");
                }

                /* ------------Opening The Text File in Editor-----------------*/
                try {
                    String Sheet = studentID + selectedMonthNumber;
                    String filePath = Sheet + ".txt";
                    System.out.println(filePath);
                    File file = new File("DataBase" + "\\" + studentID + "\\" + filePath);
                    System.out.println(file);
                    if (!Desktop.isDesktopSupported()) {
                        System.out.println("not supported");
                        return;
                    }
                    Desktop desktop = Desktop.getDesktop();
                    if (file.exists())
                        desktop.open(file);
                    else {
                        System.out.println("File not Found");
                        JOptionPane.showMessageDialog(c, "ID not Found");
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        home = new JButton();
        home.setBounds(400, 80, 150, 40);
        home.setText("Home");
        c.add(home);
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MatchFrame m = new MatchFrame();
                m.setVisible(true);
                dispose();
            }
        });

        attendance = new JLabel("Fill Information Correctly then Press  the Submit Button");
        attendance.setBounds(80, 160, 450, 60);
        attendance.setFont(f);
        c.add(attendance);

        /*textArea = new JTextArea();
        textArea.setBounds(30,170,520,380);
        textArea.setEditable(false);
        c.add(textArea);*/
    }

    public static void main(String[] args) {
        Attendance a = new Attendance();
        a.setVisible(true);
    }
}
