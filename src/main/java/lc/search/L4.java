package main.java.lc.search;

/**
 * <p>
 *     Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 * </p>
 * <a href=https://leetcode.com/problems/median-of-two-sorted-arrays/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20231215
 **/
public class L4 {

    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            double left_max = 0;
            double right_min = 0;
            int [] t1,t2;
            if (m>n){
                t1 = nums2;
                t2 = nums1;
                int temp = m;
                m = n;
                n = temp;
            }
            else{
                t1 = nums1;
                t2 = nums2;
            }
            int imin=0,imax = m,half = (m+n+1)/2,i = 0,j = 0;
            while (imin<=imax){
                i = (imin+imax)/2;
                j = half - i;
                if(i > 0 && t1[i-1]>t2[j]){
                    imax = i-1;
                }
                else if(i < m && t1[i] < t2[j-1]){
                    imin = i+1;
                }
                else{
                    if(i == 0){left_max = t2[j-1];}
                    else if(j == 0){left_max = t1[i-1];}
                    else{left_max = Math.max(t1[i-1],t2[j-1]);}
                    if((m+n)%2 == 0){
                        if(i == m){right_min = t2[j];}
                        else if(j == n){right_min = t1[i];}
                        else{right_min = Math.min(t1[i],t2[j]);}
                        return (left_max+right_min)/2;
                    }
                    else{
                        return left_max;
                    }

                }

            }
            return 0;
        }
    }
}
