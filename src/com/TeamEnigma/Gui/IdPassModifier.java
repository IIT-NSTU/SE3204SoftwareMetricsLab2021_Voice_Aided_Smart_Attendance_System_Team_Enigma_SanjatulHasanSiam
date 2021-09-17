package com.TeamEnigma.Gui;
import com.TeamEnigma.cognito.IdCheck;
import com.TeamEnigma.cognito.ModifyPassWord;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.regex.Pattern;

public class IdPassModifier extends Button_templete {
    Font font;
    private JLabel userIdLabel, passWordLabel, newPassWordLabel;
    private JTextField userIdFeild;
    private JPasswordField passWordFeild, newPassWordFeild;
    private JButton submit, modify, gotoAfterLogin;
    ModifyPassWord modifyPassWord;
    IdCheck idCheck;
    String oldPassWord, OldIdPass;

    IdPassModifier() {
        modifyPassWord = new ModifyPassWord();
        idCheck = new IdCheck();
        font = new Font("Arial", Font.BOLD, 18);
        super.setTitle("Voice recognition");
        super.container();
        super.setBounds(250, 180, 600, 600);
        speak.setVisible(false);
        login.setVisible(false);
        setResizable(false);
        display.setText("ID Password Modifier");

        initcompo();
    }
    public void initcompo() {
        userIdLabel = new JLabel("User ID  ");
        userIdLabel.setFont(font);
        userIdLabel.setBounds(80, 130, 110, 80);
        add(userIdLabel);


        userIdFeild = new JTextField();
        userIdFeild.setFont(font);
        userIdFeild.setBounds(220, 150, 200, 45);
        add(userIdFeild);


        passwordlabel = new JLabel("Password  ");
        passwordlabel.setFont(font);
        passwordlabel.setBounds(80, 200, 250, 80);
        add(passwordlabel);


        passWordFeild = new JPasswordField();
        passWordFeild.setFont(font);
        passWordFeild.setBounds(220, 220, 200, 45);
        add(passWordFeild);


        newPassWordLabel = new JLabel("New Password  ");
        newPassWordLabel.setFont(font);
        newPassWordLabel.setBounds(80, 290, 200, 45);
        newPassWordLabel.setVisible(false);
        add(newPassWordLabel);


        newPassWordFeild = new JPasswordField();
        newPassWordFeild.setFont(font);
        newPassWordFeild.setVisible(false);
        newPassWordFeild.setBounds(220, 290, 200, 45);
        add(newPassWordFeild);

        submit = new JButton("Submit");
        submit.setFont(font);
        submit.setBounds(270, 390, 100, 40);
        add(submit);

        modify = new JButton("Submit");
        modify.setFont(font);
        modify.setBounds(270, 390, 100, 40);
        setVisible(false);
        add(modify);

        modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id, newPassWord, newIdPass;
                id = userIdFeild.getText();
                newPassWord = newPassWordFeild.getText();
                //OldIdPass;
                boolean isPassOk = Pattern.matches("[A-Z,0-9]{6}", newPassWord);
                if (isPassOk) {
                    newIdPass = id + " " + newPassWord;
                    modifyPassWord.modifyPassWord(OldIdPass, newIdPass);
                    JOptionPane.showMessageDialog(container, "Password changed");
                }
                else {
                    JOptionPane.showMessageDialog(container, "At least 6 digit or letter");
                }
            }
        });

        gotoAfterLogin = new JButton("<--");
        gotoAfterLogin.setFont(font);
        gotoAfterLogin.setBounds(270, 440, 100, 40);
        setVisible(false);
        add(gotoAfterLogin);

        gotoAfterLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AfterLogin a = new AfterLogin();
                a.setVisible(true);
                dispose();
            }
        });


        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userId;
                userId = userIdFeild.getText();
                oldPassWord = passWordFeild.getText();
                OldIdPass = userId + " " + oldPassWord;

                System.out.println(OldIdPass);

                try {
                    boolean idPassMatch = idCheck.checkOldIdPass(userId, oldPassWord);
                    System.out.println("IdPassMatch = " + idPassMatch);
                    if (idPassMatch) {
                        System.out.println("Id pass match");
                        newPassWordLabel.setVisible(true);
                        newPassWordFeild.setVisible(true);
                        passwordlabel.setVisible(false);
                        passWordFeild.setVisible(false);
                        modify.setVisible(true);
                        submit.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(container, "Incorrect Id Password");
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        IdPassModifier idPassModifier = new IdPassModifier();
        idPassModifier.setVisible(true);
    }
}
