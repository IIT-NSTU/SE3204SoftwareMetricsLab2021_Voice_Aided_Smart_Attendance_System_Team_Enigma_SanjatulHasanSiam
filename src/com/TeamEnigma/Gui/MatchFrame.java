package com.TeamEnigma.Gui;
import com.TeamEnigma.cognito.CheckAttendance;
import com.TeamEnigma.cognito.Tester;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Map;
public class MatchFrame extends Button_templete {
    Tester tester;
    CheckAttendance checkAttendance;

    MatchFrame(){
        super.frame();
        super.setTitle("Voice recognition");
        super.container();
        super.setBounds(250, 180, 600, 600);
        Button_Listener();

    }
    public void Button_Listener() {
        speak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread thread=new Thread(){
                    public void run() {
                        tester=new Tester();
                    }
                };
                thread.start();
                display.setText("Recording....");
                jDialog.setVisible(true);
                try {
                    thread.join();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                jDialog.setVisible(false);
                attendSheet.setVisible(false);
                login.setVisible(false);
                speak.setVisible(false);
                Map<String,Double> result=tester.getFeq();
                UserName.setText(tester.getResult());
                String finalResult = tester.getResult();
                System.out.println(finalResult);
                if(!finalResult.equals("No match")){
                    try {
                        new CheckAttendance().checkAttendance(finalResult);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }


                UserName.setVisible(true);
                display.setText("Result....");

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
    }

    public static void main(String[] args) {
        MatchFrame s = new MatchFrame();
         s.setVisible(true);
    }
}
