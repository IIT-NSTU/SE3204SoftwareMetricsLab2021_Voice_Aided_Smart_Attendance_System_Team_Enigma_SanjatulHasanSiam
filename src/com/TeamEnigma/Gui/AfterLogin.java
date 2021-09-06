package com.TeamEnigma.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AfterLogin extends Button_templete{

    Button_templete button_templete;
    private JButton enroll,home,modify,sheet;

AfterLogin(){
    super.frame();
    super.setTitle("After login");
    //super.container();
    setBackground(new Color(128, 219, 219));
    super.setBounds(250, 180, 600, 600);

    enroll = new JButton("Enroll");
    enroll.setBounds(150,20,100,50);
    setLayout(null);
    add(enroll);

    enroll.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            AfterEnroll afterEnroll = new AfterEnroll();
            afterEnroll.setVisible(true);
            dispose();
        }
    });

    sheet = new JButton("Sheet");
    sheet.setBounds(260,20,100,50);
    setLayout(null);
    add(sheet);
    sheet.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Attendance a = new Attendance();
            a.setVisible(true);
            dispose();
        }
    });


    modify = new JButton("modify");
    modify.setBounds(380,20,100,50);
    setLayout(null);
    add(modify);

    home = new JButton("Home");
    home.setBounds(170,100,300,50);
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
        AfterLogin a = new AfterLogin();
        a.setVisible(true);
    }
}
