package lc;



/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/9/9
 **/
public class L10000 {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < 10000; i++) {
            int a = i;
        }
        System.out.println(System.currentTimeMillis());
    }
}
