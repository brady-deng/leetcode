package lc.list;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * </p>
 * <a href=https://leetcode.com/problems/pascals-triangle-ii/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 * Example 2:
 *
 * Input: rowIndex = 0
 * Output: [1]
 * Example 3:
 *
 * Input: rowIndex = 1
 * Output: [1,1]
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20240102
 **/
public class L119 {
    public List<Integer> getRow(int rowIndex) {
        int i = 1;
        List<Integer> prev = new ArrayList<Integer>(){{add(1);}};
        while (i <= rowIndex) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int c = 0; c<prev.size()-1; c++) {
                cur.add(prev.get(c)+prev.get(c+1));
            }
            cur.add(1);
            prev = cur;
            i++;
        }
        return prev;
    }
}
