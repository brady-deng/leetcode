package main.java.lc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/29
 **/
public class test {
    public static void main(String[] args) {
        List<Integer> tmp = new ArrayList<>();
        testRef(tmp);
        System.out.println(tmp);
        System.out.println(UUID.randomUUID());
    }

    public static void testRef(List<Integer> tmp) {
        tmp.add(1);
    }
}
