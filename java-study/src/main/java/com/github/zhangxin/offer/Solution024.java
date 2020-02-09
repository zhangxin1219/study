package com.github.zhangxin.offer;

import java.util.ArrayList;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/2/9 19:57
 * @Description:
 */
public class Solution024 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length==0){
            return false;
        }
        return VerifySquenceOfBST(sequence,0,sequence.length-1);
    }

    public boolean VerifySquenceOfBST(int [] sequence,int start,int end){
        int root=sequence[end];
        int i=0;
        for(i=start;i<end;i++){
            if(sequence[i]>root){
                break;
            }
        }
        int j=i;
        for(;j<end;j++){
            if(sequence[j]<root){
                return false;
            }
        }
        boolean left=true;
        if(i>start){
            left = VerifySquenceOfBST(sequence,start,i-1);
        }
        boolean right = true;
        if(i<end){
            right = VerifySquenceOfBST(sequence,i,end-1);
        }
        return left&&right;
    }

    public static void main(String[] args) {
        Solution024 solution024=new Solution024();
        int[] x = {5,7,6,9,11,10,8};
        boolean bst = solution024.VerifySquenceOfBST(x);
        System.out.println(bst);
    }
}
