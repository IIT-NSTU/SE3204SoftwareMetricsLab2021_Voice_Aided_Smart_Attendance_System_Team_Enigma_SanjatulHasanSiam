package com.TeamEnigma.cognito;

import java.util.regex.Pattern;

public class IdCheck {
    public static boolean idCheck(String id){
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
    }
}
