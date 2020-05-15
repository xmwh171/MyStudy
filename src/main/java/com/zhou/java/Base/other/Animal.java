package com.zhou.java.Base.other;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/5/15 11:35
 */

public class Animal{
    public void move(){
        System.out.println("动物可以移动");
    }

    public static void move2(){
        System.out.println("static");
    }

    private void move3(){
        System.out.println("private");
    }

    public final void move4(){
        System.out.println("final");
    }

    public void move5() throws RuntimeException{
        System.out.println("RuntimeException");
    }


}

class Dog extends Animal{
    @Override
    public void move(){
        System.out.println("狗可以跑和走");
    }

    //  访问权限不能比父类的低
//    @Override
//    protected void move(){
//        System.out.println("狗可以跑和走");
//    }


    // 声明为static的方法不能被重写
//    @Override
//    public static void move2(){
//        System.out.println("static");
//    }

    // 声明为private的方法不能被重写
//    @Override
//    private void move3(){
//        System.out.println("private");
//    }

    // 声明为final的方法不能被重写
//    public final void move4(){
//        System.out.println("final");
//    }

     // 异常不能比父类的更高
//    @Override
//    public void move5() throws Exception{
//        System.out.println("RuntimeException");
//    }

    @Override
    public void move5() throws ArithmeticException{
        System.out.println("ArithmeticException");
    }
}

 class TestDog{
    public static void main(String args[]){
        Animal b = new Dog(); // Dog 对象
        b.move(); //执行 Dog类的方法
    }
}
