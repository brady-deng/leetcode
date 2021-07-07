import java.util.Arrays;
import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/7
 **/
public class L55 {
    public static void main(String[] args) {
        System.out.println("Please input the nums:");
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int max = nums[0];
        for (int i = 0;i<nums.length-1;i++) {
            if (max >= i) {
                max = Math.max(max, nums[i]+i);
                if (max >= nums.length-1) return true;
            }
            else return false;
        }
        return max>=nums.length-1;
    }
}
