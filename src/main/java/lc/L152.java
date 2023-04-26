//import java.util.Arrays;
//import java.util.Scanner;
//
///**
// * @author dengchenyang.brady@bytedance.com
// * @date 2021/8/24
// **/
//public class L152 {
//    public static void main(String[] args) {
//        System.out.println("Please input the nums");
//        Scanner scanner = new Scanner(System.in);
//        int[] nums = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
//
//    }
//    public int maxProduct(int[] nums) {
//        int max = 1;
//        int tmpMax = 0;
//        boolean flag = false;
//        for (int i = 0; i < nums.length; i++) {
//            if (i > 0){
//                if (nums[i] == nums[i-1]+1 && !flag) {
//                    int tmpMax = nums[i]*nums[i-1];
//
//                }
//            }
//        }
//    }
//}
