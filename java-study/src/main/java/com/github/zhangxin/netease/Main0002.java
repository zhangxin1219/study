package com.github.zhangxin.netease;

import java.util.Scanner;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/1/21 11:10
 * @Description: 被3整除
 */
public class Main0002 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        if(start>=end){
            System.out.println(-1);
            return;
        }
                int result = 0;

        // 传统思路,时间复杂度过高
//        StringBuilder first = new StringBuilder();
//        for(int i=1;i<start;i++){
//            first.append(i);
//        }
//        for(int i=start;i<=end;i++){
//            first.append(i);
//            String str = first.toString();
//            int sum = 0;
//            for(int j=0;j<str.length();j++){
//                sum+=str.charAt(j)-48;
//            }
//            if(sum%3==0){
//                result++;
//            }
//        }
        for(int i=start;i<=end;i++){
            if(i%3==0||i%3==2)
                result++;
        }
        System.out.println(result);
    }
}
