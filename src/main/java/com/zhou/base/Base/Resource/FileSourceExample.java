package com.zhou.base.Base.Resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/8/8 15:21
 */
public class FileSourceExample {

    public static void main(String[] args) throws IOException {
        String filePath = "E:/study/MyStudy/src/main/resource/test/test_resource.xml";

        // 使用系统文件路径方式加载文件
        WritableResource res1 = new PathResource(filePath);

        // 使用类路径方式加载文件
        Resource res2 = new ClassPathResource("test/test_resource.xml");

        // 使用WritableResource接口写资源文件
        OutputStream outputStream = res1.getOutputStream();
        outputStream.write("测试".getBytes());
        outputStream.close();

        // 使用Resource接口读取资源
        InputStream ins1 = res1.getInputStream();
        InputStream ins2 = res2.getInputStream();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int i ;
        while((i=ins1.read())!=-1){
            baos.write(i);
        }
        System.out.println(baos.toString());

        System.out.println("res1："+res1.getFilename());
        System.out.println("res2："+res2.getFilename());

    }
}
