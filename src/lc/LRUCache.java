package lc;

import java.util.*;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/29
 **/
class LRUCache {

    private int[] nums = new int[10000];
    private int[] flag = new int[10000];
    private int capacity;
    private int count;
    private LinkedList<Integer> keys = new LinkedList<>();


    public LRUCache(int capacity) {
        this.capacity = capacity;
    }



    public int get(int key) {
        if (flag[key] > 0) {
            keys.addLast(key);
            flag[key]+=1;
            return nums[key];
        }
        else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (flag[key] == 0) {
            if (count < capacity) {
                count+=1;
                flag[key] = 1;
                nums[key] = value;
//                usedCount.put(key, usedCount.getOrDefault(key, 0) +1);
//                List<Integer> tmp = map.getOrDefault(usedCount.get(key), new ArrayList<>());
//                tmp.add(key);
//                map.put(usedCount.get(key), tmp);
                keys.addLast(key);
            }
            else {
                Integer item = keys.removeFirst();
                flag[item] -=1;
                while (flag[item] > 0) {
                    item = keys.removeFirst();
                    flag[item] -= 1;
                }
//                for (Map.Entry<Integer, List<Integer>> entry:map.entrySet())
//                {
//
//                    if (null != entry.getValue() && !entry.getValue().isEmpty()) {
//                        int item = entry.getValue().get(0);
//                        entry.getValue().remove(0);
//                        usedCount.put(item,0);
//                        flag[item] = false;
//                        break;
//                    }
//                }
                flag[key] = 1;
                nums[key] = value;
                keys.addLast(key);
//                usedCount.put(key, usedCount.getOrDefault(key, 0) +1);
//                map.getOrDefault(usedCount.get(key), new ArrayList<>()).add(key);
            }
        }
        else {
            flag[key] +=1;
            nums[key] = value;
            keys.addLast(key);
        }
    }
}
