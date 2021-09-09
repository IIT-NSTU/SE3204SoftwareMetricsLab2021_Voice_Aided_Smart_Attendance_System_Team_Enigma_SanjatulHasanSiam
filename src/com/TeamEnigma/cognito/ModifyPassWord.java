package com.TeamEnigma.cognito;
import java.io.*;
public class ModifyPassWord {

    public static void modifyPassWord(String oldString, String newString) {
        File fileToBeModified = new File("ID.txt");

        String oldContent = oldString;
        BufferedReader reader = null;
        FileWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            //Reading all the lines of input text file into oldContent
            String line = reader.readLine();
            while (line != null) {
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();
            }
            //Replacing oldString with newString in the oldContent
            String newContent = oldContent.replaceAll(oldString, newString);
            //Rewriting the input text file with newContent
            writer = new FileWriter(fileToBeModified,false);
            writer.write(newContent);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //Closing the resources
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
       // ModifyPassWord m = new ModifyPassWord();
        modifyPassWord("Admin 54321","Admin 12345");
    }
}

