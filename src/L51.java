import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/16
 **/
public class L51 {
    public static void main(String[] args) {
        System.out.println("Please input the n:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
    }
    public List<List<String>> solveNQueens(int n) {
        if (n == 1) {
            List<String> tmp = new ArrayList<String>() {{
                add("Q");
            }};
            return new ArrayList<List<String>>() {{
                add(tmp);
            }};
        }
        else {

        }
    }
    public boolean[][] buildN(int n) {
        int c = n/2+1;
        int count = 0;
        boolean[][] tmp = new boolean[n][n];
        for (boolean[] item:tmp) {
            Arrays.fill(item, true);
        }
        for (int i = 0; i < c; i++) {
            for (int j = 0; j<c;j++) {
                if (tmp[i][j]) {
                    tmp[i][j] = true;
                    setQ(tmp, i, j);
                    count++;
                    break;
                }
            }
        }
        if (count == n) {
            return tmp;
        }
    }
    public void setQ(boolean[][] res, int i, int j) {

        int m = res.length;
        int n = res[0].length;
        res[i][j] = true;
        for (int a = 0; a<m; a++) {
            res[a][j] = false;
        }
        for (int a=0; a<n; a++) {
            res[i][a] = false;
        }


    }
}
