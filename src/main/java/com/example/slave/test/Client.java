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
            Socket localhost = new Socket("127.0.0.1", 8080);
            String aaa = "hello";
            String bbb = "bbb";
            printWriter = new PrintWriter(localhost.getOutputStream());
            printWriter.println(aaa);
            printWriter.println(bbb);
            printWriter.flush();
            bufferedReader = new BufferedReader(new InputStreamReader(localhost.getInputStream()));
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println("接收到的内容s:" + s);
            }
        } catch (IOException e) {


        } finally {
            try {
                if (null!=printWriter) printWriter.close();
                if (null!=bufferedReader)bufferedReader.close();
            } catch (IOException e) {

            }
        }
    }


    public static void main2(String[] args) {
        try {
            //创建Socket用来发起请求，设置请求IP为本机，端口号为8080
            Socket socket = new Socket("127.0.0.1", 8080);
            //通过Socket的流对象创建PrintWriter用于发送请求数据，创建BufferedReader用于接收服务端响应数据
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //发送数据
            String requestData = "客户端请求数据";
            printWriter.println(requestData);
            printWriter.flush();
            //接收服务端响应数据
            String responseData = bufferedReader.readLine();
            System.out.println("接收到服务端的响应数据为：" + responseData);
            //关闭资源
            printWriter.close();
            bufferedReader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
