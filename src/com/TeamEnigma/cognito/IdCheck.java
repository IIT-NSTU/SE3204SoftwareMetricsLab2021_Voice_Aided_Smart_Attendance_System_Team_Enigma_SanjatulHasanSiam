package com.TeamEnigma.cognito;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Pattern;

public class IdCheck {
  /*  public static boolean idCheck(String id){
        boolean checked = Pattern.matches("[A-Z]{3}[0-9]{7}[A-Z]{1}", id);
        if (checked){
            //System.out.println("Correct Id");
            return true;
        }
        else
        {
            //System.out.println("Please insert Id again");
            return false;
        }
    }*/


    public  boolean checkOldIdPass(String Id,String passWord) throws IOException {
        String filePath = "ID.txt";
        String oldIdPass = Id+" "+passWord;
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while (line != null) {
            if (line.equals(oldIdPass)) {
                return true;
            }
            else{
                line = br.readLine();
            }
        }
        br.close();
        return false;
    }
   /* public static void main(String[] args) throws IOException{
        IdCheck idCheck = new IdCheck();
       boolean result = idCheck.checkOldIdPass("Admin","1234");
        System.out.println("R "+result);
    }*/
}
