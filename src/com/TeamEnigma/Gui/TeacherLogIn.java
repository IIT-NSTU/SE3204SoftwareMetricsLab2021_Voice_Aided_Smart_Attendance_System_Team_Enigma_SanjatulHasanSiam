package com.TeamEnigma.Gui;

import com.TeamEnigma.cognito.IdPassReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class TeacherLogIn extends Button_templete{
    private Font font;
    private JLabel usernamelabel, passwordlabel;
    private  JButton home, submit;


    public TeacherLogIn() {
        font = new Font("Arial", Font.BOLD, 18);
        super.frame();
        super.setTitle("Teachers LogIn");
        super.container();
        super.setBounds(250, 180, 600, 600);
        display.setText(" Teachers LogIn");
        speak.setVisible(false);
        studentLogin.setVisible(false);
        //login.setVisible(false);


        usernamelabel = new JLabel("User ID : ");
        usernamelabel.setBounds(60, 170, 90, 45);
        usernamelabel.setFont(font);
        container.add(usernamelabel);

        UserName = new JTextField();
        UserName.setBounds(190, 170, 280, 45);
        UserName.setFont(font);
        container.add(UserName);


        passwordlabel = new JLabel("Password : ");
        passwordlabel.setBounds(60, 235, 110, 45);
        passwordlabel.setFont(font);
        container.add(passwordlabel);


        Password = new JPasswordField();
        Password.setBounds(190, 235, 280, 45);
        Password.setText("");
        Password.setFont(font);
        container.add(Password);


        home = new JButton("Home");
        home.setBounds(470, 80, 90, 45);
        container.add(home);

        submit = new JButton("Submit");
        submit.setBounds(260, 300, 90, 45);
        container.add(submit);

        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main=new Main();
                main.setVisible(true);
                dispose();
            }
        });


        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String id = UserName.getText();
                String password = Password.getText();
                System.out.println(id + " " + password);

                try {
                    boolean b3 = Pattern.matches("[A-Z]{3}[0-9]{7}[A-Z]{1}", id);
                    if (!b3){
                        boolean result = IdPassReader.idPassChecker(id, password);

                        System.out.println(result);
                        if (result) {
                            TeacherPanel teacherPanel = new TeacherPanel();
                            teacherPanel.setVisible(true);
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(container, "Invalid ID Password");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(container, "Invalid ID Password");
                    }


                } catch (Exception Exception) {
                    Exception.printStackTrace();
                }

            }
        });




    }

    public static void main(String[] args) {
        TeacherLogIn t=new TeacherLogIn();
        t.setVisible(true);
    }
}
