package main.java.lc.search;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2023/12/10
 **/
public class L74Ans {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int r = elementPresent(matrix , target);
            if(r == -1) {
                return false;
            }
            boolean isFound = binarySearch(matrix, r, target);
            return isFound;
        }
        public int elementPresent(int[][] matrix, int target) {
            int lo = 0;
            int hi = matrix.length-1;
            int lc = matrix[0].length-1;
            while(lo<=hi) {
                int mid = lo+(hi-lo)/2;
                if(matrix[mid][0]<= target && matrix[mid][lc] >= target) {
                    return mid;
                }else if(matrix[mid][0] < target) {
                    lo = mid+1;
                }else{
                    hi = mid-1;
                }
            }
            return -1;
        }
        public boolean binarySearch(int[][] matrix, int r, int target) {
            int lo=0;
            int hi = matrix[0].length-1;
            while(lo<=hi) {
                int mid = lo+(hi-lo)/2;
                if(matrix[r][mid] == target) {
                    return true;
                }else if(matrix[r][mid] < target) {
                    lo = mid+1;
                }else{
                    hi = mid-1;
                }
            }
            return false;
        }
    }
}
