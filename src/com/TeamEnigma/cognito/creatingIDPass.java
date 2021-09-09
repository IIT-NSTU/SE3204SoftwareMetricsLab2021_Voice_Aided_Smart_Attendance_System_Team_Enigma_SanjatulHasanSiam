package com.TeamEnigma.cognito;

import java.io.*;

public class creatingIDPass {
    //For storing Id and password in a file
    public static void idPass(String id, String pass) throws IOException
    {   String filepath="IdPass.txt";
        String Combination=id+" "+pass;
        String oldContent = "";

        FileReader fileReader=new FileReader(filepath);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String line=bufferedReader.readLine();
        while (line != null)
        {
            oldContent = oldContent + line + System.lineSeparator();

            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        boolean check=oldContent.contains(Combination);
        if(check){
            System.out.println("Already exists");
        }
        else
        {
            FileWriter fw = new FileWriter(filepath,true);
            PrintWriter pw=new PrintWriter(fw);

            pw.println(Combination);
            pw.flush();
            pw.close();
        }

    }
    //For Modifying Id and password in a file
    public static void idPassModify(String id, String pass, String newPass) throws IOException
    {
        String newString=id+" "+newPass;
        String oldString=id+" "+pass;
        String filePath="IdPass.txt";
        File fileToBeModified = new File(filePath);
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            //Reading all the lines of input text file into oldContent
            String line = reader.readLine();
            while (line != null)
            {
                oldContent = oldContent + line + System.lineSeparator();

                line = reader.readLine();
            }

            //Replacing oldString with newString in the oldContent

            String newContent = oldContent.replaceAll(oldString, newString);

            //Rewriting the input text file with newContent

            writer = new FileWriter(fileToBeModified);

            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources

                reader.close();

                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws IOException{
        String id="Sanjatul";
        String pass="1234";
        String newPass="568464";
        idPass(id,pass);
        idPassModify(id,pass,newPass);

    }

}
