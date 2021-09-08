package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/8
 **/
public class L57 {
    public static void main(String[] args) {
        System.out.println("Please input the interval length:");
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[][] intervals = new int[m][2];
        scanner.nextLine();
        for (int i = 0; i<m; i++) {
            System.out.println("Please input the interval:");
            intervals[i] = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        }
        int[] newInterval = new int[2];
        System.out.println("Please input the new interval:");
        newInterval = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[] start = new int[100001];
        int[] end = new int[100001];
        int max = 0;
        for(int[] interval: intervals){
            start[interval[0]]++;
            end[interval[1]]++;
            max = Math.max(max,interval[1]);
        }
        start[newInterval[0]]++;
        end[newInterval[0]]++;
        max = Math.max(max, newInterval[1]);
        List<int[]> list = new ArrayList();
        int sum = 0;
        for(int i = 0; i <= max; i++){
            if(start[i] > 0){
                int[] temp = new int[2];
                temp[0] = i;
                while(true){
                    sum += start[i];
                    sum -= end[i];
                    if(sum == 0)
                        break;
                    i++;
                }
                temp[1] = i;
                list.add(temp);
            }
        }
        int[][] res = new int[list.size()][2];
        for(int i = 0; i < res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
