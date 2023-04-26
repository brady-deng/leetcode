//package main.java.lc;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.TreeMap;
//
///**
// * @author dengchenyang.brady@bytedance.com
// * @date 2021/10/27
// **/
//public class LFUCache {
//    // value数组
//    private int[] nums = new int[10000];
//    // 使用标志
//    private boolean[] flag = new boolean[10000];
//    // 计数使用次数
//    private Map<Integer, List<Integer>> fre;
//    // 容量
//    private int capacity;
//    // 当前key数量
//    private int count;
//
//
//
//    public LFUCache(int capacity) {
//        this.capacity = capacity;
//        this.count = 0;
//        this.fre = new TreeMap<>();
//    }
//
//
//
//    public int get(int key) {
//        if (flag[key]) {
//            return nums[key];
//        }
//        else {
//            return -1;
//        }
//    }
//
//    public void put(int key, int value) {
//        if (!flag[key]) {
//            if (count < capacity) {
//                count+=1;
//                flag[key] = true;
//                nums[key] = value;
//            }
//            else {
//                fre.keySet().toArray();
//                flag[item] -=1;
//                while (flag[item] > 0) {
//                    flag[item] -= 1;
//                }
//
//                flag[key] = 1;
//                nums[key] = value;
//            }
//        }
//        else {
//            flag[key] +=1;
//            nums[key] = value;
//        }
//    }
//}
