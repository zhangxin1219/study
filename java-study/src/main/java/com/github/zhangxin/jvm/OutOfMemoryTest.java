package com.github.zhangxin.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/1/28 20:37
 * @Description:
 */
public class OutOfMemoryTest {
    public static void main(String[] args) {
        List<ArrayList> list = new ArrayList<>();
        int i =0;
        while(true){
            ArrayList<Integer> a = new ArrayList<>(i++);
            list.add(a);
        }
    }
}
