package com.example.slave.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;
        try {
            Socket localhost = new Socket("127.0.0.1", 9999);
            String aaa = "hello";
            bufferedReader = new BufferedReader(new InputStreamReader(localhost.getInputStream()));
            printWriter = new PrintWriter(localhost.getOutputStream(), true);
            printWriter.print(aaa);
            System.out.println("=========================");
            while (true) {
                String s = bufferedReader.readLine();
                System.out.println("接收到的内容s:" + s);
            }
        } catch (IOException e) {


        } finally {
            try {
                printWriter.close();
                bufferedReader.close();
            } catch (IOException e) {

            }
        }
    }
}
