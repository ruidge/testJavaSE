package com.ruidge.test.jpct;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestReadFile {
    public static void main(String[] args) {
        try {
            FileReader fr = fr = new FileReader("file/test.txt");
            int ch = 0;
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
