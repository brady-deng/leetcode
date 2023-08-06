package main.java.lc.list;

/**
 * count number of jumps needed to reach the end
 * end farthest index that can be reached with the current number of jumps
 * maxFar farthest index that can be reached from the current index
 * @author dengchenyang@tju.edu.cn
 * @date 20230625
 **/
public class L45Ans {

    public int jump(int[] nums) {
        int count = 0, end = 0, maxFar = nums[0];
        for ( int index = 0; index + 1 < nums.length; ++index ) {
            maxFar = Math.max(index + nums[index], maxFar);
            if ( index == end ) {
                ++count;
                end = maxFar;
            }
        }
        return count;
    }

}
