package com.zhou.java.Spring.AOP.jdkProxy.principle;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @Description 仿写Proxy
 * @Author xiaohu
 * @Date 2020/6/19 15:27
 */
public class XhProxy {

    private static final String ln ="\r\n";

    public static Object newProxyInstance(XhClassLoader classLoader,
                                          Class<?>[] interfaces,
                                          XhInvocationHandler h){

        try {
            //生成源代码
            String proxySrc = generateSrc(interfaces[0]);

            //将生成的源代码输出到磁盘，保存为.java文件
            String filePath = XhProxy.class.getResource("").getPath();
            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = null;
            fw = new FileWriter(f);
            fw.write(proxySrc);
            fw.flush();
            fw.close();

            // 编译源代码，并且生成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(f);

            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();

            // 将class文件中的内容，动态加载到JVM中来
            // 返回被代理后的代理对象
            Class proxyClass = classLoader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(XhInvocationHandler.class);
            f.delete();
            return c.newInstance(h);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return  null;
    }

    private static String generateSrc(Class<?> interfaces){
        StringBuffer sb = new StringBuffer();
        sb.append("package com.zhou.java.Spring.AOP.jdkProxy.principle;" + ln);
        sb.append("import java.lang.reflect.Method;"+ln);
        sb.append("import java.lang.reflect.Proxy;"+ln);
        sb.append("public final class $Proxy0 implements "+interfaces.getName()+ "{" + ln);

        sb.append("XhInvocationHandler h;" + ln);

        sb.append("public $Proxy0(XhInvocationHandler h) {" + ln);
        sb.append("this.h = h;" + ln);
        sb.append("}" + ln);


        //  获取接口方法
        for(Method method : interfaces.getMethods()){
            sb.append("public "+method.getReturnType().getName()+" "+method.getName()+ "(){" + ln);

            sb.append("try{" + ln);
            sb.append("Method m = " + interfaces.getName() + ".class.getMethod(\"" +method.getName()+"\",new Class[]{});" + ln);
            sb.append("this.h.invoke(this,m,null);" + ln);
            sb.append("}catch(Throwable e){e.printStackTrace();}" + ln);
            sb.append("}" + ln);
        }

        sb.append("}");

        return sb.toString();
    }

//    private String generateSrc2(Class<?>[] interfaces){
//        StringBuffer sb = new StringBuffer();
//
//        String path = XhProxy.class.getResource("").getPath();
//        path = path.replace("/",".");
//        path = path.substring(path.indexOf("com"),path.length()-1);
//        sb.append("package " + path + ";" + ln);
//        sb.append("import java.lang.reflect.InvocationHandler;"+ln);
//        sb.append("import java.lang.reflect.Method;"+ln);
//        sb.append("import java.lang.reflect.Proxy;"+ln);
//        sb.append("import java.lang.reflect.UndeclaredThrowableException;"+ln);
//        sb.append(""+ln);
//        String interfaceName = "";
//        for(Class<?> simpleInterface : interfaces){
//            interfaceName += simpleInterface.getName()+",";
//        }
//        interfaceName.substring(0,interfaceName.length()-1);
//        sb.append("public final class $Proxy0 extends Proxy implements "+interfaceName+ "{" + ln);
//        sb.append("private static Method m0;" + ln);
//        sb.append("private static Method m1;" + ln);
//        sb.append("private static Method m2;" + ln);
//
//
//        //  获取所有接口方法
//
//
//        sb.append("GPInvocationHandler h;" + ln);
//
//
//
//
//
//        return sb.toString();
//    }

}
