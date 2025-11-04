package lc.bit;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/22
 **/
public class L190 {
    public static int reverseBit(int num) {
        String s = Integer.toBinaryString(num);
        s = reverseString(s);
        return Integer.parseInt(s, 2);
    }

    public static int reverseBit2(int num) {
        StringBuilder s = new StringBuilder();
        while (num != 0) {
            s.append(num%2);
            num /=2;
        }
        while (s.length() < 32) {
            s.append("0");
        }
        return Integer.parseInt(s.toString(), 2);
    }


    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        int a = 0, b = chars.length-1;
        while (a < b) {
            char tmp = chars[a];
            chars[a] = chars[b];
            chars[b] = tmp;
            a++;
            b--;
        }
        StringBuilder tempS = new StringBuilder(new String(chars));
        while (tempS.length() < 32) {
            tempS.append("0");
        }
        return tempS.toString();
    }

    
}
