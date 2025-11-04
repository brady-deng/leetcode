package lc.list2;

/**
 * <p>
 *     You are given an m x n integer matrix mat and an integer target.
 *
 * Choose one integer from each row in the matrix such that the absolute difference between target and the sum of the chosen elements is minimized.
 *
 * Return the minimum absolute difference.
 *
 * The absolute difference between two numbers a and b is the absolute value of a - b.
 * </p>
 *
 * @author dengchenyang@tju.edu.cn
 * @date 20240216
 **/
public class L1981Ans {
    public int minimizeTheDifference(int[][] mat, int target) {
        Integer[][] dp = new Integer[mat.length][5001];
        return minDiff(mat, 0, target,0, dp);
    }

    /**
     *
     * dp[i+1] only depends on dp[i]
     * @param mat orgin matrix
     * @param index depth
     * @param target
     * @param val current val
     * @param dp dp[i][j] represents the abs of i depth sum of i depth val
     * @return
     */
    public int minDiff(int[][] mat,int index,int target, int val, Integer[][] dp){
        if(index == mat.length){
            return Math.abs(val - target);
        }
        if(dp[index][val] != null){
            return dp[index][val];
        }

        int res = Integer.MAX_VALUE;
        for(int i = 0; i < mat[0].length; i++){
            res = Math.min(res, minDiff(mat, index + 1, target, val + mat[index][i], dp));
        }

        return dp[index][val] = res;
    }
}
