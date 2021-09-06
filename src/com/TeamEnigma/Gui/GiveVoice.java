package com.TeamEnigma.Gui;

import com.TeamEnigma.cognito.CheckAttendance;
import com.TeamEnigma.cognito.CreatingAttendanceSheets;
import com.TeamEnigma.cognito.Record;
import com.TeamEnigma.cognito.Tester;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Pattern;

public class GiveVoice extends Button_templete{

    Button_templete button_templete;
    private JButton speak,home;
    Tester tester;
   // private JLabel id;
    //private JTextField jTextField;
    CreatingAttendanceSheets cas;

GiveVoice(){
    super.frame();
    super.setTitle("After login");
    //super.container();
    setBackground(new Color(128, 219, 219));
    super.setBounds(250, 180, 600, 600);

    speak = new JButton("Speak");
    speak .setBounds(430,20,100,50);
    setLayout(null);
    add(speak);
    speak.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Record record = new Record();
            File tmp;
            tmp = new File(record.getVoice());

        }
    });


    home = new JButton("Home");
    home.setBounds(170,300,300,50);
    setLayout(null);
    add(home);

    home.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            MatchFrame m = new MatchFrame();
            m.setVisible(true);
            dispose();
        }
    });
}



    public static void main(String[] args) {
        GiveVoice a = new GiveVoice();
        a.setVisible(true);
    }
}
