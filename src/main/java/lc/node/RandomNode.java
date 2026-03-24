package main.java.lc.node;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/22
 **/
public class RandomNode {
    int val;
    RandomNode next;
    RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public RandomNode(int val, RandomNode next) {
        this.val = val;
        this.next = next;
        this.random = null;
    }
}
