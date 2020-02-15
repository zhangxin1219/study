package com.github.zhangxin.mianjing;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/2/15 13:44
 * @Description:
 */
interface A{
    default void move(){
        System.out.println("a move");
    }
}

class B implements A{
    @Override
    public void move() {
        System.out.println("b move");
    }

    public void eat(){
        System.out.println("b eat");
    }
}
public class ExtendClassTest {
    public static void main(String[] args) {
        A b= new B();
        b.move();
    }
}
