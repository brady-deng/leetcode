package lc.string;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2024/6/14
 **/
public class XiaohongshuI1 {

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(XiaohongshuI1.solution(s));
        s = "2[abc]3[cd]ef";
        System.out.println(XiaohongshuI1.solution(s));

    }

    public static String solution(String s) {
        StringBuilder res = new StringBuilder();
        // num
        StringBuilder count = new StringBuilder();
        // [s]
        StringBuilder tmp = new StringBuilder();
        int c = 0;
        // false中括号外，true中括号里
        boolean tmpFlag = false;
        for(int i = 0; i < s.length(); i++) {
            if((s.charAt(i) >= '0' && s.charAt(i) <= '9') || (s.charAt(i) == ']')) {
                while(c>0) {
                    res.append(tmp.toString());
                    c--;
                }
                if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    count.append(s.charAt(i));
                }
            } else {
                if (!count.toString().isEmpty()) {
                    c = Integer.parseInt(count.toString());
                } else if(c == 0) {
                    c = 1;
                }
                count = new StringBuilder();
                if (s.charAt(i) != '[' && s.charAt(i) != ']') {
                    tmp.append(s.charAt(i));
                }
            }
        }
        while(c>0 && !tmp.toString().isEmpty()) {
            res.append(tmp.toString());
            c--;
        }
        return res.toString();
    }

}
