package com.TeamEnigma.cognito;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IdPassReader {

    public static boolean idPassChecker(String id, String password) throws IOException {
        String filepath="ID.txt";
        FileReader fileReader=new FileReader(filepath);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String line=bufferedReader.readLine();
        while(line!=null)
        {
            String idPass;
            idPass = id+" "+password;
            if(line.equals(idPass)){
                return true;
            }
            line=bufferedReader.readLine();
        }
        bufferedReader.close();
        return false;
    }
    public static void main(String[] args) throws IOException{
        IdPassReader i = new IdPassReader();
        boolean re = i.idPassChecker("ASH","222");
        System.out.println(re);

    }
}
