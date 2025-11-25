package com.student.is.Authentication;

import java.io.*;

public class Authentication {
    public static String currentUser;
    public static boolean authenticated;


    public boolean chekAuth(String login , String password) {

        try  {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/com/student/is/database/auth.bin"));
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
            br.close();
        }
        catch (IOException e){
            System.out.println("Error reading file!" + e);
        }


        String temp = DataBase_File_ogrenci(login);
        if (temp.equals(password)) {
            return true;
        } else return false;
    }

    public String DataBase_File_ogrenci(String ogr_no ){
        return "1234" ; // şifreyi return edecek
    }
}

