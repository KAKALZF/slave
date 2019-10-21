package com.example.slave.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestFile {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("D://test//1.txt");
            fileWriter.write("123");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
