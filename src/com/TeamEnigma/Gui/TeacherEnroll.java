package com.TeamEnigma.Gui;

import com.TeamEnigma.cognito.IdPassReader;
import com.TeamEnigma.cognito.IdPassWritter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class TeacherEnroll extends Button_templete{
    private JButton submit, back;
    private Font font;
    IdPassWritter idPassWritter;


    public TeacherEnroll() {
        font = new Font("Arial", Font.BOLD, 18);
        super.frame();
        super.setTitle("Teacher Enrollment");
        super.container();
        super.setBounds(250, 180, 600, 600);
        speak.setVisible(false);
        studentLogin.setVisible(false);
        display.setVisible(false);

        idPassWritter = new IdPassWritter();

        initcomponent();

    }

    public void initcomponent() {


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


        back = new JButton("Back");
        back.setBounds(470, 80, 90, 45);
        container.add(back);
        studentLogin.setVisible(false);


        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             AfterLogin afterLogin=new AfterLogin();
                afterLogin.setVisible(true);
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
                    boolean b3 = Pattern.matches("[A-Z]{3}[0-9]{7}[A-Z]{1}", id);
                    if (!b3){
                        boolean result = IdPassReader.idPassChecker(id, password);

                        System.out.println(result);
                        if (result) {
                            JOptionPane.showMessageDialog(container, "ID Exists");
                        } else {

                            IdPassWritter.idPassword(id, password);
                            JOptionPane.showMessageDialog(container, "Enrollment successful");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(container, "Student Id not allowed");
                    }


                } catch (Exception Exception) {
                    Exception.printStackTrace();
                }

            }
        });
    }

    public static void main(String[] args) {
        TeacherEnroll te=new TeacherEnroll();
        te.setVisible(true);
    }
}
