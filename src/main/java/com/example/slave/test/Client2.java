package com.example.slave.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) {
        try {
            Socket localhost = new Socket("localhost", 8080);
            PrintWriter printWriter = new PrintWriter(localhost.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(localhost.getInputStream()));
            printWriter.println("my own test");
            printWriter.flush();
            String s = bufferedReader.readLine();
            System.out.println(s);
            printWriter.close();
            bufferedReader.close();
        } catch (IOException e) {


        }
        ;

    }
}
