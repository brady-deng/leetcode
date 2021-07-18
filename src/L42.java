import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/18
 **/
public class L42 {
    public static void main(String[] args) {
        System.out.println("Please input the heights:");
        Scanner scanner = new Scanner(System.in);
        int[] height = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(trap(height));
    }
    public static int trap(int[] height) {
        if (height.length > 2) {
            List<Integer> peaks = getPeaks(height);

            return subTrap(height, peaks);
        }
        else return 0;
    }

    public static List<Integer> getPeaks(int[] height) {

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
