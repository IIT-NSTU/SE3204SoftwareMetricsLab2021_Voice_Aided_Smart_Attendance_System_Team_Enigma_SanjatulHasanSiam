package com.TeamEnigma.Gui;

import com.TeamEnigma.cognito.CheckAttendance;
import com.TeamEnigma.cognito.IdPassReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentLogIn extends Button_templete{
    private Font font;
    private JLabel usernamelabel, passwordlabel;
    private JButton backButton, submit;

    String courseCode;

    public StudentLogIn(String courseCode) {

        this.courseCode=courseCode;
        font = new Font("Arial", Font.BOLD, 18);
        super.frame();
        super.setTitle("Student LogIn");
        super.container();
        super.setBounds(250, 180, 600, 600);
        display.setText("    Student LogIn");
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


        backButton = new JButton("Back");
        backButton.setBounds(470, 80, 90, 45);
        container.add(backButton);

        submit = new JButton("Submit");
        submit.setBounds(260, 300, 90, 45);
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
                        new CheckAttendance().checkAttendance(courseCode,id);
                        JOptionPane.showMessageDialog(container, "Attendance Confirmed");
                    } else {
                        JOptionPane.showMessageDialog(container, "Invalid ID Password");
                    }

                } catch (Exception Exception) {
                    Exception.printStackTrace();
                }


            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TeacherPanel teacherPanel=new TeacherPanel();
                teacherPanel.setVisible(true);

                dispose();
            }
        });
    }




    public static void main(String[] args) {
       // StudentLogIn st=new StudentLogIn();
        //st.setVisible(true);
    }
}
