package com.TeamEnigma.Gui;
import com.TeamEnigma.cognito.CheckAttendance;
import com.TeamEnigma.cognito.Tester;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Map;
public class MatchFrame extends Button_templete {
    Tester tester;
    CheckAttendance checkAttendance;
    JLabel ShowingResult ;
    Font font;
    String finalResult;

    MatchFrame(){
        font = new Font("Arial",Font.BOLD,18);
        super.frame();
        super.setTitle("Voice recognition");
        super.container();
        super.setBounds(250, 180, 600, 600);
        Button_Listener();
        checkAttendance=new CheckAttendance();

        ShowingResult = new JLabel("");
        ShowingResult.setBounds(230,250,300,100);
        ShowingResult.setFont(font);
        add(ShowingResult);

    }
    public void Button_Listener() {
        speak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usernamelabel.setVisible(false);
                passwordlabel.setVisible(false);
                Thread thread=new Thread(){
                    public void run() {
                        tester=new Tester();
                    }
                };
                thread.start();
                display.setText("Recording....");
               // jDialog.setVisible(true);
                try {
                    thread.join();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                jDialog.setVisible(false);
                //attendSheet.setVisible(false);
                login.setVisible(false);
                speak.setVisible(false);
                Map<String,Double> result=tester.getFeq();

                finalResult = tester.getResult();
                System.out.println(finalResult);
                ShowingResult.setVisible(true);
                ShowingResult.setText(finalResult);
                System.out.println("Final person is = "+finalResult);

                display.setText("Result....");
                resultToHome.setVisible(true);
                if(!finalResult.equals("No match")){
                  confirmAttendance.setVisible(true);
                }
            }
        });

        resultToHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                speak.setVisible(true);
                login.setVisible(true);
                display.setText("Welcome to Voice Recognition");
                UserName.setVisible(false);
                resultToHome.setVisible(false);
                ShowingResult.setVisible(false);
                confirmAttendance.setVisible(false);
            }
        });

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserName.setVisible(true);
                Password.setVisible(true);
                submit.setVisible(true);

                usernamelabel.setVisible(true);
                passwordlabel.setVisible(true);
            }
        });

        confirmAttendance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new CheckAttendance().checkAttendance(finalResult);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }



    public static void main(String[] args) {
        MatchFrame s = new MatchFrame();
        s.setVisible(true);
    }
}
