package com.TeamEnigma.Gui;

import com.TeamEnigma.cognito.IdPassReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Button_templete extends JFrame {
    public JButton speak, attendSheet, login,studentLogin, submit, resultToHome,confirmAttendance;
    public JTextField UserName;
    public Container container;
    public JLabel display, usernamelabel, passwordlabel;
    private Font font, displayFont;
    public JPasswordField Password;
    public JDialog jDialog;


    public void frame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(450, 280, 435, 355);
        this.setResizable(false);
    }

    public void container() {
        container = this.getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(128, 219, 219));
        Button_Method();
    }

    public void Button_Method() {
        jDialog = new JDialog();
        jDialog.setTitle("DialogBox");
        JLabel l = new JLabel("this is a dialog box");

        jDialog.add(l);
        jDialog.setSize(100, 100);
        jDialog.add(l);
        container.add(l);

        displayFont = new Font("Arial", Font.BOLD, 22);
        display = new JLabel();
        display.setBounds(80, 28, 500, 60);
        display.setText("Voice Aided Smart Attendance System");
        container.add(display);
        display.setFont(displayFont);

        speak = new JButton("Speak");
        speak.setBounds(100, 150, 93, 50);
        container.add(speak);

        /*login = new JButton("Admin LogIn");
        login.setBounds(390, 150, 120, 50);
        container.add(login);*/


        studentLogin = new JButton("Student LogIn");
        studentLogin.setBounds(220, 150, 140, 50);
        container.add(studentLogin);

        resultToHome = new JButton("Home");
        resultToHome.setBounds(450, 50, 100, 40);
        resultToHome.setVisible(false);
        container.add(resultToHome);


        confirmAttendance = new JButton("Confirm");
        confirmAttendance.setBounds(240, 450, 100, 40);
        confirmAttendance.setVisible(false);
        container.add(confirmAttendance);

        submit = new JButton("Submit");
        submit.setBounds(250, 480, 99, 51);

        submit.setVisible(false);
        container.add(submit);



    }


}
