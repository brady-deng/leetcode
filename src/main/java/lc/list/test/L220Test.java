package main.java.lc.list.test;

import main.java.lc.list.L220;

import java.util.HashMap;
import java.util.Map;

public class L220Test extends L220 {

    @Override
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedValue = Long.valueOf(nums[i]) - Integer.MIN_VALUE;
            long bucket = remappedValue/(valueDiff + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket-1) && (remappedValue - map.get(bucket-1)) <= valueDiff)
                    || (map.containsKey(bucket+1) && (map.get(bucket+1) - remappedValue) <= valueDiff)
            ) {
                return true;
            }
            if (map.size() >= indexDiff) {
                long removeValue = Long.valueOf(nums[i-indexDiff]) - Integer.MIN_VALUE;
                long removeBucket = removeValue/(valueDiff+1);
                map.remove(removeBucket);
            }
            map.put(bucket, remappedValue);
        }
        return false;
    }
}
