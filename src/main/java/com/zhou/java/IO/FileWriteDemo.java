package com.zhou.java.IO;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 写数据--输出流--FileWriter
 */
public class FileWriteDemo {

    /**
     * FileWriter:
     * 		FileWriter(String fileName):传递一个文件名称
     *
     * 相对路径：相对当前项目而言的，在项目的根目录下(a.txt)
     * 绝对路径：以盘符开始的路径(d:\\a.txt)
     *
     * 输出流写数据的步骤：
     * 		A:创建输出流对象
     * 		B:调用输出流对象的写数据的方法
     * 		C:释放资源
     *
     * close()和flush()方法的区别：
     * 		flush():刷新缓冲区。流对象还可以继续使用。
     * 		close():先刷新缓冲区，然后通知系统释放资源。流对象不可以再被使用了。
     *
     * void write(String str):写一个字符串数据
     * void write(String str,int index,int len):写一个字符串中的一部分数据
     * void write(int ch):写一个字符数据,这里写int类型的好处是既可以写char类型的数据，也可以写char对应的int类型的值。'a',97
     * void write(char[] chs):写一个字符数组数据
     * void write(char[] chs,int index,int len):写一个字符数组的一部分数据
     *
     * 如何实现数据的换行?
     * 		\n可以实现换行，但是windows系统自带的记事本打开并没有换行，这是为什么呢?因为windows识别的换行不是\n，而是\r\n
     * 		windows:\r\n
     * 		linux:\n
     * 		mac:\r
     * 如何实现数据的追加写入?
     * 		FileWriter(String fileName, boolean append)
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("a.txt",true);   //表示追加写入，默认是false
        fw.write("1237");

        for(int x=0; x<10; x++) {
            fw.write("hello"+x);
            fw.write("\r\n");  // 换行符，由系统决定
        }

        //释放资源
        //通知系统释放和该文件相关的资源
        fw.close();
    }

}
