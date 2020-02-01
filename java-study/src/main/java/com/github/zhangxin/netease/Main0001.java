package com.github.zhangxin.netease;

import java.util.Scanner;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/1/20 18:15
 * @Description: 牛牛找工作
 */
public class Main0001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[] array=new int[3];
        for (int i = 0; i < 3; i++) {
            array[i]=scanner.nextInt();
        }
        System.out.println(x);
        System.out.println(y);
        System.out.println(array);

    }
}
