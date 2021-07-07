import java.util.*;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/7
 **/
public class L39 {
    public static void main(String[] args) {
        System.out.println("Please input the nums:");
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Please input the target:");
        int target = scanner.nextInt();
        System.out.println(combinationSum(nums, target));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combine(candidates, target, res, new ArrayList<>(), 0);
        return res;

    }
    public static void combine(int[] candidates, int target, List<List<Integer>> res, List<Integer> tmp, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        else if (target < candidates[start]){
            return;
        }
        else {
            for (int i = start; i<candidates.length; i++) {
                if (candidates[i] <= target) {
                    tmp.add(candidates[i]);
                    target-=candidates[i];
                    combine(candidates, target, res, tmp, i);
                    target+=candidates[i];
                    tmp.remove(tmp.size()-1);
                }
                else {
                    return;
                }
            }
        }
    }
}
