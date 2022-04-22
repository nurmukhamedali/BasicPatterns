package _lab11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PersonalScanner{
    static Scanner consoleInput = new Scanner(System.in);
    static Scanner fileScanner;
    public static Scanner getConsoleScanner(){
        return consoleInput;
    }
    public static Scanner getFileScanner(File file){
        try {
            return new Scanner(file);
        }
        catch(FileNotFoundException ex){
            System.out.println(ex);
            return null;
        }
    }
}

