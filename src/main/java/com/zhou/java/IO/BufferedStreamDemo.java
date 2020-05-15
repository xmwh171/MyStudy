package com.zhou.java.IO;

import java.io.*;

/*
 * 缓冲流的特殊功能：
 * BufferedWriter
 * 		void newLine():写一个换行符，这个换行符由系统决定
 * BufferedReader
 * 		String readLine():一次读取一行数据，但是不读取换行符
 */
public class BufferedStreamDemo {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("b.txt"));
        bw.write("hello");
        bw.newLine();
        bw.write("world");
        bw.close();

        BufferedReader br = new BufferedReader(new FileReader("b.txt"));
        String line ;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }
        br.close();
    }

}
