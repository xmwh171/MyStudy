package com.zhou.java.IO;

import java.io.FileReader;
import java.io.IOException;

/**
 * 读数据--输入流--FileReader
 */
public class FileReaderDemo {


    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("a.txt");

        // int read():一次读取一个字符,如果读取数据的返回值是-1的时候，就说明没有数据了
        int ch ;
        while((ch=fr.read())!=-1){
           System.out.print((char)ch);
        }
        fr.close();

        System.out.println("另一种读取方式");

        //int read(char[] cbuf)：一次读取一个字符数组的数据，返回的是实际读取的字符个数
        FileReader fr2 = new FileReader("a.txt");
        char[] chs = new char[1024]; //这里可以是1024及其整数倍
        int len ;
        while((len=fr2.read(chs))!=-1) {
            System.out.print(new String(chs,0,len));
        }

        fr2.close();
    }

}
