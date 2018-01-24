package com.example.slave.activemq;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

import javax.swing.ImageIcon;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class try1 {

    public static void main(String[] a) {

        try1.createMark("D:\\20180125000315.png", "D:\\dd.jpg", "广州", null, 1, "", 30);
        // System.out.println(d.createMark("e8.jpg","e81.jpg","",null,
        // 1,"",16));
    }


    public static void createMark(String souchFilePath, String targetFilePath,
                                  String markContent, Color markContentColor, float qualNum,
                                  String fontType, int fontSize) {

        markContentColor = Color.red;
        ImageIcon imgIcon = new ImageIcon(souchFilePath);
        Image theImg = imgIcon.getImage();
        // Image可以获得 输入图片的信息
        int width = theImg.getWidth(null);
        int height = theImg.getHeight(null);

        // 800 800 为画出图片的大小
        BufferedImage bimage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        // 2d 画笔
        Graphics2D g = bimage.createGraphics();
        g.setColor(markContentColor);
        g.setBackground(Color.white);

        // 画出图片-----------------------------------
        g.drawImage(theImg, 0, 0, null);
        // 画出图片-----------------------------------

        // --------对要显示的文字进行处理--------------
        AttributedString ats = new AttributedString(markContent);
        Font f = new Font(fontType, Font.BOLD, fontSize);
        ats.addAttribute(TextAttribute.FONT, f, 0, markContent.length());
        AttributedCharacterIterator iter = ats.getIterator();
        // ----------------------

        g.drawString(iter, width-230,
                height - 400);
        // 添加水印的文字和设置水印文字出现的内容 ----位置
        g.dispose();// 画笔结束
        try {
            // 输出 文件 到指定的路径
            FileOutputStream out = new FileOutputStream(targetFilePath);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);

            JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bimage);

            param.setQuality(qualNum, true);
            encoder.encode(bimage, param);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}