package com.example.slave.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    public static void main(String[] args) {
        try {
            ServerSocket localhost = new ServerSocket(8080);
            Socket accept = localhost.accept();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
            PrintWriter printWriter = new PrintWriter(accept.getOutputStream());
            String s = bufferedReader.readLine();
            System.out.println("收到消息" + s);
            printWriter.println("已接受到消息：" + s);
            printWriter.close();
            bufferedReader.close();
        } catch (IOException e) {


        }
    }
}
