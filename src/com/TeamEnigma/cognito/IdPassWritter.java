package com.TeamEnigma.cognito;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class IdPassWritter {
    public static void idPassword(String id, String password) {
        FileWriter fw1;

        {
            try {
                fw1 = new FileWriter("ID.txt",true);
                PrintWriter pw1 = new PrintWriter(fw1);
                String IdPass=id+" "+password;
                pw1.println(IdPass);
                pw1.flush();
                pw1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


public static void main(String[]args){
        //idPassword("ASH19250","1234");
    idPassword("Admin","12345");
        }

}
