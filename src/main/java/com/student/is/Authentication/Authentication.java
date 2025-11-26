package com.student.is.Authentication;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

public class Authentication {
    public static String currentUser;
    public static boolean authenticated;

    public static void main(String[] args){
        currentUser = "cengiz.hark@inonu.edu.tr";
        changePassword("rashid");
    }



    public static boolean checkStudentAuth(String login , String password) {
        try  {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/com/student/is/database/auth.bin"));
            String line;
            while ((line = br.readLine()) != null){
                if (line.equals("personnelend"))
                        break;
            }
            while ((line = br.readLine()) != null){
                String loginTemp = line.split(" ")[0];
                if (loginTemp.equals(login)) {
                    if (line.split(" ")[1].equals(Encryption.encryptString(password))){
                        currentUser = loginTemp;
                        authenticated = true;
                        return true;
                    }
                    return false;
                }
            }
            br.close();
        }
        catch (IOException e){
            System.out.println("Error reading file!" + e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public static boolean checkPersonnelAuth(String login , String password) {
        try  {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/com/student/is/database/auth.bin"));
            String line;
            while ((line = br.readLine()) != null){
                if (line.equals("personnelend"))
                    break;
                String loginTemp = line.split(" ")[0];
                if (loginTemp.equals(login)) {
                    if (line.split(" ")[1].equals(Encryption.encryptString(password))){
                        currentUser = loginTemp;
                        authenticated = true;
                        return true;
                    }
                    return false;
                }
            }
            br.close();
        }
        catch (IOException e){
            System.out.println("Error reading file!" + e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public static void changePassword(String password) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/com/student/is/database/auth.bin"));
            BufferedWriter wr = new BufferedWriter(new FileWriter("src/main/resources/com/student/is/database/auth_2.bin"));
            String line;
            while ((line = br.readLine()) != null) {
                String loginTemp = line.split(" ")[0];
                if (loginTemp.equals(currentUser)) {
                    line = loginTemp + " " + Encryption.encryptString(password);
                    wr.write(line + "\n");
                    continue;
                }
                wr.write(line + "\n");
            }
            br.close();
            wr.close();
            File f1 = new File("src/main/resources/com/student/is/database/auth.bin");
            f1.delete();
            File f2 = new File("src/main/resources/com/student/is/database/auth_2.bin");
            f2.renameTo(new File("src/main/resources/com/student/is/database/auth.bin"));
        } catch (IOException e) {
            System.out.println("Error reading file!" + e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }
    public static void changePassword(String login,String password) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/com/student/is/database/auth.bin"));
            BufferedWriter wr = new BufferedWriter(new FileWriter("src/main/resources/com/student/is/database/auth_2.bin"));
            String line;
            while ((line = br.readLine()) != null) {
                String loginTemp = line.split(" ")[0];
                if (loginTemp.equals(login)) {
                    line = loginTemp + " " + Encryption.encryptString(password);
                    wr.write(line + "\n");
                    continue;
                }
                wr.write(line + "\n");
            }
            br.close();
            wr.close();
            File f1 = new File("src/main/resources/com/student/is/database/auth.bin");
            f1.delete();
            File f2 = new File("src/main/resources/com/student/is/database/auth_2.bin");
            f2.renameTo(new File("src/main/resources/com/student/is/database/auth.bin"));
        } catch (IOException e) {
            System.out.println("Error reading file!" + e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}

