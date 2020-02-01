package com.github.zhangxin.offer;

import org.junit.Test;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/1/16 11:28
 * @Description:
 */
public class Solution036 {
    public int InversePairs(int [] array) {
        if(array==null||array.length<=0)
            return -1;
        int[] copy = new int[array.length];
        for(int i =0;i<array.length;i++){
            copy[i]=array[i];
        }
        int count = InversePairsCore(array,copy,0,array.length-1);
        return count;
    }

    public int InversePairsCore(int[] array,int[] copy,int start,int end) {
        if (start == end) {
            copy[start] = array[start];
            return 0;
        }
        int length = (end - start) / 2;
        int left = InversePairsCore(array, copy, start, start + length) % 1000000007;
        int right = InversePairsCore(array, copy, start + length + 1, end) % 1000000007;
        int i = start + length;
        int j = end;
        int indexCopy = end;
        int count = 0;
        while (i >= start && j >= start + length + 1) {
            if (array[i] > array[j]) {
                copy[indexCopy--] = array[i--];
                count += j - (start + length + 1) + 1;
                if (count >= 1000000007)
                    count = count % 1000000007;
            } else {
                copy[indexCopy--] = array[j--];
            }
        }
        while (i >= start) {
            copy[indexCopy--] = array[i--];
        }
        while (j >= start + length + 1) {
            copy[indexCopy--] = array[j--];
        }
        for (int k = start; k <= end; k++) {
            array[k] = copy[k];
        }
        return (left + right + count) % 1000000007;
    }
    @Test
    public void test() {
        Solution036 solution = new Solution036();
        int[] a = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        int s = solution.InversePairs(a);
        System.out.println(s);
    }
}
