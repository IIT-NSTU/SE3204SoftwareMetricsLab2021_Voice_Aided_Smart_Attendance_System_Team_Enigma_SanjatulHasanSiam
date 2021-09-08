package com.TeamEnigma.Gui;

import com.TeamEnigma.cognito.CreatingAttendanceSheets;
import com.TeamEnigma.cognito.Record;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.regex.Pattern;

public class AfterEnroll extends Button_templete{

    Button_templete button_templete;
    private JButton home,check,speak1;
    private JLabel id;
    private JTextField jTextField;
    CreatingAttendanceSheets cas;
    private int count;

AfterEnroll(){
    count=1;
    super.frame();
    super.setTitle("After login");
    //super.container();
    setBackground(new Color(128, 219, 219));
    super.setBounds(250, 180, 600, 600);

    id = new JLabel("Enter Your ID : ");
    id.setLayout(null);
    id.setBounds(10,20,150,50);
    add(id);

    jTextField = new JTextField();
    jTextField.setLayout(null);
    jTextField.setBounds(170,20,250,50);
    add(jTextField);

    check = new JButton("Submit");
    check .setBounds(430,20,100,50);
    setLayout(null);
    add(check );


    speak1 = new JButton("Speak");
    speak1.setBounds(300,90,100,50);
    setLayout(null);
    speak1.setVisible(false);
    add(speak1);

    check.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = jTextField.getText();
            boolean isIdOk = Pattern.matches("[A-Z]{3}[0-9]{7}[A-Z]{1}", id);
            System.out.println("ID is Correct = " + isIdOk);
            if (isIdOk) {
                File file=new File("DataBase/"+id);
                if(file.exists()){
                     speak1.setVisible(true);
                    JOptionPane.showMessageDialog(container, "ID found");
                }else{
                    try {
                        cas.attSheet(id);
                        speak1.setVisible(true);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                System.out.println("ID is Correct = " + isIdOk);

            } else {
                JOptionPane.showMessageDialog(container, "Invalid ID");
            }
        }
    });

    speak1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Record record = new Record();
            File tmp;
            tmp = new File(record.getVoice());
            File file=new File("sample/set"+count+"/");
            count++;
            file.mkdirs();
            try {
                File file1=new File(file.getPath()+"/"+ jTextField.getText() + ".wav");
                System.out.println(file1.getPath());
                System.out.println(file1.createNewFile());
                InputStream inputStream=new FileInputStream(tmp);
                OutputStream outputStream=new FileOutputStream(file1);
                int c;
                while ((c=inputStream.read())!=-1){
                    outputStream.write(c);
                }
                inputStream.close();
                outputStream.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            System.out.println(tmp.getPath());

            if(count>10){
                speak1.setVisible(false);
            }

        }
    });

    home = new JButton("Home");
    home.setBounds(170,300,300,50);
    setLayout(null);
    add(home);

    home.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            MatchFrame m = new MatchFrame();
            m.setVisible(true);
            dispose();
        }
    });
}



    public static void main(String[] args) {
        AfterEnroll a = new AfterEnroll();
        a.setVisible(true);
    }
}
