package main.java.lc.list;

import java.util.*;

//You are given an array of integers nums, there is a sliding window of size k
//which is moving from the very left of the array to the very right. You can only
//see the k numbers in the window. Each time the sliding window moves right by one
//position.
//
// Return the max sliding window.
//
//
// Example 1:
//
//
//Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//Output: [3,3,5,5,6,7]
//Explanation:
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//
//
// Example 2:
//
//
//Input: nums = [1], k = 1
//Output: [1]
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 10⁵
// -10⁴ <= nums[i] <= 10⁴
// 1 <= k <= nums.length
//
//
// Related Topics Array Queue Sliding Window Heap (Priority Queue) Monotonic
//Queue 👍 17962 👎 665

public class L239 {

    public static void main(String[] args) {
        int[] nums = main.java.lc.util.LUtil.inputNums();
        int k = main.java.lc.util.LUtil.inputNum();
        main.java.lc.util.LUtil.printNums(new L239().maxSlidingWindow(nums, k));
        main.java.lc.util.LUtil.printNums(new L239().maxSlidingWindow2(nums, k));
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = nums.length;
        int[] res = new int[l-k+1];
        TreeMap<Integer, Integer> treeMap = new TreeMap<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < l-k+1; i++) {
            if (i == 0) {
                int tmp = i;
                while (tmp < i+k) {
                    treeMap.putIfAbsent(nums[tmp], 0);
                    treeMap.put(nums[tmp], treeMap.get(nums[tmp])+1);
                    tmp++;
                }
            } else {
                treeMap.put(nums[i-1], treeMap.get(nums[i-1])-1);
                if (treeMap.get(nums[i-1]) == 0) {
                    treeMap.remove(nums[i-1]);
                }
                treeMap.putIfAbsent(nums[i+k-1], 0);
                treeMap.put(nums[i+k-1], treeMap.get(nums[i+k-1])+1);
            }
            res[i] = treeMap.firstKey();
        }
        return res;
    }


    public int[] maxSlidingWindow2(int[] nums, int k) {
        int l = nums.length;
        int[] res = new int[l-k+1];
        int[] treeMap = new int[2*10000+1];
        int low = -10000;
        int high = -10000;
        for (int i = 0; i < l-k+1; i++) {
            if (i == 0) {
                int tmp = i;
                while (tmp < i+k) {
                    treeMap[nums[tmp] - low] +=1;
                    if (nums[tmp] > high) {
                        high = nums[tmp];
                    }
                    tmp++;
                }
            } else {
                treeMap[nums[i-1]-low] -=1;
                treeMap[nums[i+k-1]-low] +=1;
                if (nums[i+k-1] > high) {
                    high = nums[i+k-1];
                }
            }
            int tmp = high;
            while (tmp >=0 && treeMap[tmp-low] == 0) {
                tmp--;
            }
            high = tmp;
            res[i] = high;
        }
        return res;
    }
}



class MyMapEntry<K, V> implements Map.Entry<K, V> {
    private K key;
    private V value;

    public MyMapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        V oldValue = this.value;
        this.value = value;
        return oldValue;
    }

    // 重写hashCode和equals方法，确保类的对象能够正确地被处理
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyMapEntry<?, ?> that = (MyMapEntry<?, ?>) o;

        if (key != null ? !key.equals(that.key) : that.key != null) return false;
        return value != null ? value.equals(that.value) : that.value == null;
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
