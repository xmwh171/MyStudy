package com.zhou.base.Exception;

/**
 * throws是用来声明一个方法可能抛出的所有异常信息，throws是将异常声明但是不处理，而是将异常往上传，谁调用我就交给谁处理。而throw则是指抛出的一个具体的异常类型。
 * throw一旦进入被执行，程序立即会转入异常处理阶段，后面的语句就不再执行，而且所在的方法不再返回有意义的值！如果抛出（throw）的是编译时异常，那么方法也要抛出（throws）异常
 *
 * @Description
 * @Author xiaohu
 * @Date 2019/6/24 11:22
 */
public class ThrowTest {

    /**
     * 编译时异常(检查时异常)才会提示处理
     * @param args
     */
    public static void main(String[] args) {
        throwException(1);

        try {
            System.out.println(throwException2(1));
        } catch (Exception e) {
            e.printStackTrace();
        }

        throwRuntimeException(1);

        throwRuntimeException2(1);

        try {
            throwMyException(1);
        } catch (MyException e) {
            e.printStackTrace();
        }

        throwMyRuntimeException(1);
    }

    public static void throwException(int a){
        if(a>0){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static int throwException2(int a) throws Exception {
        if(a>0){
            throw new Exception();
        }
        return a;
    }

    public static void throwRuntimeException(int a){
        if(a>0){
            throw new RuntimeException();
        }
    }

    public static void throwRuntimeException2(int a) throws RuntimeException{
        if(a>0){
            throw new RuntimeException();
        }
    }

    public static void throwMyException(int a) throws MyException {
        if(a>0){
            throw new MyException("我的异常");
        }
    }

    public static void throwMyRuntimeException(int a){
        if(a>0){
            throw new MyRuntimeException("我的运行时异常");
        }
    }

}
