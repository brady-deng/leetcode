package lc.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * <p>
 *     Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 * </p>
 * <a href = https://leetcode.com/problems/trapping-rain-water/>ref</a>
 * <p>
 *     [0,1,0,2,1,0,1,3,2,1,2,1] 6
 * [4,2,0,3,2,5] 9
 * </p>
 * <p>
 *     hard
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/18
 **/
public class L42 {
    public static void main(String[] args) {
        System.out.println("Please input the heights:");
        Scanner scanner = new Scanner(System.in);
        int[] height = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(new L42().trap(height));
    }
    public int trap(int[] height) {
        if (height.length > 2) {
            List<Integer> peaks = getPeaks(height);

            return subTrap(height, peaks);
        }
        else return 0;
    }

    /**
     * extract peaks
     * @param height original height array
     * @return the index of peak
     */
    public List<Integer> getPeaks(int[] height) {

        List<Integer> r = new ArrayList<>();
        if (height[0] > height[1]) r.add(0);
        for (int i = 1; i<height.length-1; i++) {

            if (height[i] >= height[i-1] && height[i] >= height[i+1]) {
                r.add(i);
            }
        }
        if (height[height.length-1] > height[height.length-2]) {
            r.add(height.length-1);
        }
        return r;
    }

    public static int subTrap(int[] height, List<Integer> peaks) {
        if (peaks.size() < 2) return 0;
        else {
            int res = 0;
            int cur = peaks.remove(peaks.size()-1);
            int tmp = height[peaks.get(0)];
            int pre = peaks.get(0);
            int start = 0;
            for (int i = peaks.size()-1; i>-1; i--) {
                if (height[peaks.get(i)] >= height[cur]) {
                    tmp = height[peaks.get(i)];
                    pre = peaks.get(i);
                    start = i;
                    break;
                }
                else if (height[peaks.get(i)] < height[cur] && height[peaks.get(i)] > tmp) {
                    tmp = height[peaks.get(i)];
                    pre = peaks.get(i);
                    start = i;
                }
            }

            int thre = Math.min(tmp, height[cur]);
            for (int j = pre+1; j < cur; j++) {
                if (thre > height[j]) {
                    res+=(thre-height[j]);
                }
            }

            res+=subTrap(height, peaks.subList(0, start+1));
            return res;
        }
    }
}
