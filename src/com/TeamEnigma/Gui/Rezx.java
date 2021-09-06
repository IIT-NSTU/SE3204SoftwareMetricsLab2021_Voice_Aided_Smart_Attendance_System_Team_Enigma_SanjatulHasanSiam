package com.TeamEnigma.Gui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rezx {
    public static void main(String args[]){
//1st way
       // Pattern p = Pattern.compile(".s");//. represents single character
      //  Matcher m = p.matcher("as");
       // boolean b = ((Matcher) m).matches();

//2nd way
        //boolean b2=Pattern.compile(".s").matcher("as").matches();

//3rd way
        boolean b3 = Pattern.matches("[A-Z]{3}[0-9]{7}[A-Z]{1}", "ASH1925012M");
        System.out.println(b3);
    }}