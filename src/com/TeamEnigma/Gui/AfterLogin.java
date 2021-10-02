package com.TeamEnigma.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AfterLogin extends Button_templete {

    Button_templete button_templete;
    private JButton enroll, home, reset, sheet, teacherEnroll;

    AfterLogin() {
        super.frame();
        super.setTitle("Admin Panel");

        super.container();
        setBackground(new Color(128, 219, 219));
        super.setBounds(250, 180, 600, 600);
        speak.setVisible(false);
        display.setVisible(false);
      //  login.setVisible(false);
        studentLogin.setVisible(false);

        initcomponent();


    }

    public void initcomponent() {

        teacherEnroll = new JButton("Teacher Enroll");
        teacherEnroll.setBounds(160, 130, 300, 50);
        setLayout(null);
        add(teacherEnroll);



        enroll = new JButton("Enroll");
        enroll.setBounds(135, 220, 100, 50);
        setLayout(null);
        add(enroll);


        teacherEnroll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TeacherEnroll teacherEnroll=new TeacherEnroll();
                teacherEnroll.setVisible(true);
                dispose();
            }
        });

        enroll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AfterEnroll afterEnroll = new AfterEnroll();
                afterEnroll.setVisible(true);
                dispose();
            }
        });

        sheet = new JButton("Sheet");
        sheet.setBounds(250, 220, 100, 50);
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

        reset = new JButton("Reset");
        reset.setBounds(370, 220, 100, 50);
        setLayout(null);
        add(reset);


        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IdPassModifier idPassModifier = new IdPassModifier();
                idPassModifier.setVisible(true);
                dispose();
            }
        });

        home = new JButton("Home");
        home.setBounds(160, 320, 300, 50);
        setLayout(null);
        add(home);

        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main=new Main();
                main.setVisible(true);
                dispose();
            }
        });
    }


    public static void main(String[] args) {
        AfterLogin a = new AfterLogin();
        a.setVisible(true);
    }
}
