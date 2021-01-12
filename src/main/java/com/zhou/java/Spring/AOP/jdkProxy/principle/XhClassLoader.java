package com.zhou.java.Spring.AOP.jdkProxy.principle;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Description 仿写ClassLoader
 * 代码生成、编译、重新动态load到JVM
 * @Author xiaohu
 * @Date 2020/6/19 15:28
 */
public class XhClassLoader extends ClassLoader{

    private File baseDir;

    public XhClassLoader(){
        String basePath = XhClassLoader.class.getResource("").getPath();
        this.baseDir = new java.io.File(basePath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = XhClassLoader.class.getPackage().getName() + "." + name;

        if(baseDir != null){
            File classFile = new File(baseDir,name.replaceAll("\\.", "/") + ".class");
            if(classFile.exists()){    // target/classes/com/zhou/java/Spring/AOP/jdkProxy/principle/$Proxy0.java
                FileInputStream in = null;
                ByteArrayOutputStream out = null;
                try{
                    in = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte [] buff = new byte[1024];
                    int len;
                    while ((len = in.read(buff)) != -1) {
                        out.write(buff, 0, len);
                    }
                    //  defineClass(): 把字节码转化为Class
                    return defineClass(className, out.toByteArray(), 0,out.size());

                }catch (Exception e) {
                    e.printStackTrace();
                }finally{
                    if(null != in){
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if(null != out){
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    classFile.delete();
                }
            }
        }

        return null;
    }
}
