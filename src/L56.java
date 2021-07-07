import java.util.Arrays;
import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/7
 **/
public class L56 {
    public static void main(String[] args) {
        System.out.println("Please input the m:");
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println("Please input the n:");
        int n = scanner.nextInt();

    }

    public int[][] merge(int[][] intervals) {
        for (int i = 0; i<intervals.length; i++) {
            if (intervals[i] != null && intervals[i].length>0) {
                for (int j = i; j<intervals.length; j++) {
                    if (intervals[j] != null && intervals[j].length>0) {
                        if (intervals[j][0] <= intervals[i][1] || intervals[j][1] <= intervals[i][0]) {
                            intervals[i] = merge2Int(intervals[i], intervals[j]);
                            intervals[j] = null;
                        }
                    }
                }
            }
        }
        long c = Arrays.stream(intervals).filter(item->item!=null).count();
        int[][] res = new int[(int) c][2];
        for ()
    }

    public int[] merge2Int(int[] i1, int[] i2) {
        int[] res = new int[2][;
        if (i1[1] <= i2[0]) {
            res[0] = i1[0];
            res[1] = i2[1];
        }
        else if (i1[0]>=i2[1]) {
            res[0] = i2[0];
            res[1] = i1[1];
        }
        return res;
    }
//    public int[][] sortInter(int[][] tmp) {
//        int m = tmp.length;
//        int n = tmp[0].length;
//        int[][] res = new int[m][n];
//    }
}
