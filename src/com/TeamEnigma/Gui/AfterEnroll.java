package com.TeamEnigma.Gui;
import com.TeamEnigma.cognito.CreatingAttendanceSheets;
import com.TeamEnigma.cognito.IdPassWritter;
import com.TeamEnigma.cognito.Record;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.regex.Pattern;

public class AfterEnroll extends Button_templete {

    Button_templete button_templete;
    private JButton home, submit, speak1;
    private JLabel id, password;
    private JTextField jTextField;
    private JPasswordField passwordFeild;
    CreatingAttendanceSheets cas;
    private int count;
    Font font;
    IdPassWritter idPassWritter;

    AfterEnroll() {
        count = 6;
        idPassWritter = new IdPassWritter();
        font = new Font("Arial", Font.BOLD, 18);
        count = 1;
        super.frame();
        super.setTitle("After login");
        super.container();
        super.setBackground(new Color(128, 219, 219));
        super.setBounds(250, 180, 600, 600);

        speak.setVisible(false);
        login.setVisible(false);
        display.setVisible(false);

        id = new JLabel("Enter Your ID : ");
        id.setLayout(null);
        id.setBounds(10, 20, 150, 50);
        id.setFont(font);
        add(id);


        password = new JLabel("Enter Password: ");
        password.setLayout(null);
        password.setFont(font);
        password.setBounds(10, 120, 150, 50);
        add(password);

        jTextField = new JTextField();
        jTextField.setLayout(null);
        jTextField.setFont(font);
        jTextField.setBounds(170, 20, 250, 50);
        add(jTextField);


        passwordFeild = new JPasswordField();
        passwordFeild.setLayout(null);
        passwordFeild.setFont(font);
        passwordFeild.setBounds(170, 120, 250, 50);
        add(passwordFeild);

        submit = new JButton("Submit");
        submit.setBounds(430, 120, 100, 50);
        setLayout(null);
        add(submit);


        speak1 = new JButton("Speak");
        speak1.setBounds(275, 190, 100, 50);
        setLayout(null);
        speak1.setVisible(false);
        add(speak1);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String id = jTextField.getText();
                boolean isIdOk = Pattern.matches("[A-Z]{3}[0-9]{7}[A-Z]{1}", id);
                String password = passwordFeild.getText();
                boolean isPassOk = Pattern.matches("[A-Z,0-9]{6}", password);
                System.out.println("ID is Correct = " + isIdOk);
                if (isIdOk && isPassOk) {
                    File file = new File("DataBase/" + id);
                    if (file.exists()) {
                        // speak1.setVisible(true);
                        JOptionPane.showMessageDialog(container, "ID found");
                    } else {
                        try {
                            cas.attSheet(id);
                            IdPassWritter.idPassword(id, password);
                            speak1.setVisible(true);
                            home.setVisible(false);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                    System.out.println("ID is Correct = " + isIdOk);

                } else {
                    JOptionPane.showMessageDialog(container, "Invalid ID or Password");
                }
            }
        });

        speak1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Record record = new Record();
                File tmp;
                tmp = new File(record.getVoice());
                File file = new File("sample/set" + count + "/");
                count++;
                file.mkdirs();
                try {
                    File file1 = new File(file.getPath() + "/" + jTextField.getText() + ".wav");
                    System.out.println(file1.getPath());
                    System.out.println(file1.createNewFile());
                    InputStream inputStream = new FileInputStream(tmp);
                    OutputStream outputStream = new FileOutputStream(file1);
                    int c;
                    while ((c = inputStream.read()) != -1) {
                        outputStream.write(c);
                    }
                    inputStream.close();
                    outputStream.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.out.println(tmp.getPath());

                if (count > 6) {
                    speak1.setVisible(false);
                    home.setVisible(true);
                }
            }
        });

        home = new JButton("Home");
        home.setBounds(170, 300, 300, 50);
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
