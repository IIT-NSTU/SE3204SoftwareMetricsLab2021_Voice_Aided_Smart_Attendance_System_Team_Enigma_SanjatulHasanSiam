package com.TeamEnigma.Gui;

import com.TeamEnigma.cognito.CheckAttendance;
import com.TeamEnigma.cognito.Tester;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class Main extends Button_templete{
    private  Font font;
    private JButton teacherLogin;



    public Main() {
        font = new Font("Arial", Font.BOLD, 18);
        super.frame();
        super.setTitle("Home");
        super.container();
        super.setBounds(250, 180, 600, 600);
        speak.setVisible(false);
        studentLogin.setVisible(false);

        login = new JButton("Admin LogIn");
        login.setBounds(390, 150, 120, 50);
        container.add(login);

        teacherLogin=new JButton();
        teacherLogin.setText("Teacher LogIn");
        teacherLogin.setBounds(140, 150, 120, 50);
        container.add(teacherLogin);

        teacherLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TeacherLogIn teacherLogIn=new TeacherLogIn();
                teacherLogIn.setVisible(true);
                dispose();
            }
        });



        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogIn logIn=new LogIn();
                logIn.setVisible(true);
                dispose();
            }
        });

    }

    public static void main(String[] args) {
        Main main=new Main();
        main.setVisible(true);
    }
}
