import java.util.ArrayList;
import java.util.List;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/29
 **/
public class test {
    public static void main(String[] args) {
        List<Integer> tmp = new ArrayList<>();
        testRef(tmp);
        System.out.println(tmp);
    }

    public static void testRef(List<Integer> tmp) {
        tmp.add(1);
    }
}
