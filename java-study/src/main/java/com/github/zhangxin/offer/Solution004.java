package com.github.zhangxin.offer;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/2/3 11:01
 * @Description:
 */
public class Solution004 {
    public String replaceSpace(StringBuffer str) {
        char[] chars = str.toString().toCharArray();
        int spaceNum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                spaceNum++;
            }
        }
        char[] ans = new char[chars.length + spaceNum * 2];
        int i = chars.length - 1;
        int j = ans.length - 1;
        while (i >= 0 && j >= 0) {
            if(chars[i]!=' '){
                ans[j--]=chars[i--];
            }else{
                ans[j--]='0';
                ans[j--]='2';
                ans[j--]='%';
                i--;
            }
        }
        return new String(ans);

//        StringBuffer ans = new StringBuffer();
//        int length = str.length();
//        for(int i = 0;i<length;i++){
//            if(str.charAt(i)==' '){
//                ans.append("%20");
//            }else{
//                ans.append(str.charAt(i));
//            }
//        }
//        return ans.toString();
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("we are family!");
        Solution004 solution004 = new Solution004();
        String str = solution004.replaceSpace(sb);
        System.out.println(str);
    }
}
