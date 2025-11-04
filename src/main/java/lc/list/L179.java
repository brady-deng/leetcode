package lc.list;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 *     Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 *
 * Since the result may be very large, so you need to return a string instead of an integer.
 * </p>
 * <a href=https://leetcode.com/problems/largest-number/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: nums = [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 * </p>
 * <p>
 *     Medium
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date
 **/
public class L179 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ob = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(new L179().largestNumber(ob));
    }

    public String largestNumber(int[] nums) {
        List<Integer> tmp = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Comparator compara = (Comparator<Integer>) (o1, o2) -> {
            char[] sa = (String.valueOf(o1) + o2).toCharArray();
            char[] sb = (String.valueOf(o2) + o1).toCharArray();
            int i=0, j=0;
            while (i < sa.length && j < sb.length) {
                if (sa[i] == sb[j]) {
                    i++;
                    j++;
                } else {
                    return sa[i] > sb[j]? -1:1;
                }
            }
            return -1;

        };
        tmp.sort(compara);
        StringBuilder res = new StringBuilder();
        tmp.stream().forEach(item->{
            res.append(item);
        });
        if (res.charAt(0) == '0') {
            return "0";
        }
        return res.toString();

    }
}
