package com.TeamEnigma.Gui;

import com.TeamEnigma.cognito.IdPassReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn extends Button_templete {
    private Font font, font1;
    private JButton submit, home;

    LogIn() {
        font = new Font("Arial", Font.BOLD, 18);
        font1 = new Font("Arial", Font.BOLD, 14);
        super.frame();
        super.setTitle("Log In Frame");
        super.container();
        super.setBounds(250, 180, 600, 600);
        speak.setVisible(false);
        display.setText("Login Window");
        display.setBounds(220, 28, 500, 60);
        login.setVisible(false);

        initcomponent();
    }

    public void initcomponent() {

        usernamelabel = new JLabel("User ID : ");
        usernamelabel.setBounds(60, 170, 90, 45);
        usernamelabel.setFont(font);
        container.add(usernamelabel);

        UserName = new JTextField();
        UserName.setBounds(190, 170, 280, 45);
        UserName.setFont(font1);
        container.add(UserName);


        passwordlabel = new JLabel("Password : ");
        passwordlabel.setBounds(60, 235, 110, 45);
        passwordlabel.setFont(font);
        container.add(passwordlabel);


        Password = new JPasswordField();
        Password.setBounds(190, 235, 280, 45);
        Password.setText("");
        Password.setFont(font1);
        container.add(Password);


        home = new JButton("Home");
        home.setBounds(470, 80, 90, 45);
        container.add(home);

        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MatchFrame matchFrame = new MatchFrame();
                matchFrame.setVisible(true);
                dispose();
            }
        });

        submit = new JButton("Submit");
        submit.setBounds(240, 315, 100, 45);
        container.add(submit);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String id = UserName.getText();
                String password = Password.getText();
                System.out.println(id + " " + password);

                try {
                    boolean result = IdPassReader.idPassChecker(id, password);
                    System.out.println(result);
                    if (result) {
                        AfterLogin afterLogin = new AfterLogin();
                        afterLogin.setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(container, "Invalid ID Password");
                    }

                } catch (Exception Exception) {
                    Exception.printStackTrace();
                }

            }
        });
    }


    public static void main(String[] args) {
        LogIn logIn = new LogIn();
        logIn.setVisible(true);
    }
}
