package com.TeamEnigma.Gui;

import java.awt.*;

public class Alertframe extends Button_templete{
    Alertframe(){
        super.setTitle("Alert Frame");
        super.setBounds(250, 180, 600, 600);
        container = this.getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(128, 219, 219));
    }
    public static void main(String[] args) {
        Alertframe alertframe = new Alertframe();
        alertframe.setVisible(true);
    }
}
