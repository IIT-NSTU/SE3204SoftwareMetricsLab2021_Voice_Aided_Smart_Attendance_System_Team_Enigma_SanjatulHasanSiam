package com.TeamEnigma.Gui;

import com.TeamEnigma.cognito.CheckAttendance;
import com.TeamEnigma.cognito.Tester;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

public class TeacherPanel extends Button_templete {
    private Font font;
    private JComboBox<String> course;
    private JButton start, close, home, confirmAttendance, backButton;
    private String courseCode;
    Tester tester;
    //CheckAttendance checkAttendance;
    JLabel ShowingResult, instructionLabel;
    String dateCourse;

    String courses[] = {"CSE 2101", "CSE 2102", "CSE 2103", "CSE 2104"};


    public TeacherPanel() {
        font = new Font("Arial", Font.BOLD, 18);
        super.frame();
        super.setTitle("Teacher's Panel");
        super.container();
        super.setBounds(250, 180, 600, 600);
        display.setText("Teacher's Panel");
        speak.setVisible(false);
        studentLogin.setVisible(false);
       // login.setVisible(false);

        start = new JButton();
        start = new JButton("Start");
        start.setBounds(90, 250, 93, 50);
        container.add(start);

        backButton = new JButton();
        backButton = new JButton("Back");
        backButton.setBounds(450, 50, 100, 40);
        backButton.setVisible(false);
        container.add(backButton);

        ShowingResult = new JLabel();
        ShowingResult.setBounds(200, 330, 150, 50);
        ShowingResult.setFont(font);
        container.add(ShowingResult);
        ShowingResult.setVisible(false);

        instructionLabel = new JLabel("Use Student LogIn if Voice identification fails");
        instructionLabel.setBounds(70, 450, 500, 50);

        instructionLabel.setFont(font);
        container.add(instructionLabel);
        instructionLabel.setVisible(false);


        home = new JButton("Home");
        home.setBounds(250, 250, 93, 50);
        container.add(home);

        confirmAttendance = new JButton("Confirm");
        confirmAttendance.setBounds(200, 400, 150, 50);
        container.add(confirmAttendance);
        confirmAttendance.setVisible(false);

        close = new JButton();
        close = new JButton("Close");
        close.setBounds(410, 250, 93, 50);
        close.setVisible(false);
        container.add(close);


        course = new JComboBox<>(courses);
        course.setBounds(390, 150, 120, 50);
        container.add(course);


        speak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                Thread thread = new Thread() {
                    public void run() {
                        tester = new Tester();
                    }
                };
                thread.start();
                display.setText("Recording....");
                try {
                    thread.join();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                start.setVisible(false);
                home.setVisible(false);
                close.setVisible(false);
                speak.setVisible(false);
                course.setVisible(false);
                studentLogin.setVisible(false);
                instructionLabel.setVisible(false);
                Map<String, Double> result = tester.getFeq();
                String finalResult = tester.getResult();
                System.out.println(finalResult);
                ShowingResult.setText(finalResult);

                display.setText("Result....");
                resultToHome.setVisible(true);
                ShowingResult.setVisible(true);
                if (!finalResult.equals("No match")) {
                    resultToHome.setVisible(false);
                    confirmAttendance.setVisible(true);
                    backButton.setVisible(true);

                } else {
                    resultToHome.setVisible(false);
                    backButton.setVisible(true);
                }

            }
        });

        studentLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentLogIn studentLogIn = new StudentLogIn(courseCode);
                studentLogIn.setVisible(true);
                instructionLabel.setVisible(false);
                dispose();
            }
        });

        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main();
                main.setVisible(true);
                dispose();
            }
        });


        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                start.setVisible(false);
                speak.setVisible(true);
                courseCode = course.getSelectedItem().toString();
                LocalDate localDate = LocalDate.now();
                dateCourse = String.valueOf(localDate) + "\t Course: " + courseCode;
                System.out.println(dateCourse);
                display.setText(dateCourse);
                System.out.println("Course : " + courseCode);
                studentLogin.setVisible(true);
                close.setVisible(true);
                home.setVisible(false);
                course.setVisible(false);
                instructionLabel.setVisible(true);


            }
        });


        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start.setVisible(true);
                course.setVisible(true);
                home.setVisible(true);
                speak.setVisible(false);
                studentLogin.setVisible(false);
                close.setVisible(false);
                instructionLabel.setVisible(false);
                display.setText("Teacher's Panel");
            }
        });


        confirmAttendance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map<String, Double> result = tester.getFeq();
                String finalResult = tester.getResult();
                try {
                    new CheckAttendance().checkAttendance(courseCode, finalResult);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                close.setVisible(true);
                speak.setVisible(true);
                studentLogin.setVisible(true);
                display.setText(dateCourse);
                ShowingResult.setVisible(false);
                confirmAttendance.setVisible(false);
                resultToHome.setVisible(false);
                backButton.setVisible(false);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close.setVisible(true);
                speak.setVisible(true);
                studentLogin.setVisible(true);
                display.setText(dateCourse);
                ShowingResult.setVisible(false);
                confirmAttendance.setVisible(false);
                backButton.setVisible(false);
            }
        });


    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public static void main(String[] args) {
        TeacherPanel tp = new TeacherPanel();
        tp.setVisible(true);
    }
}
