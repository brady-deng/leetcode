package lc.math;
//Given the coordinates of two rectilinear rectangles in a 2D plane, return the
//total area covered by the two rectangles.
//
// The first rectangle is defined by its bottom-left corner (ax1, ay1) and its
//top-right corner (ax2, ay2).
//
// The second rectangle is defined by its bottom-left corner (bx1, by1) and its
//top-right corner (bx2, by2).
//
//
// Example 1:
//
//
//Input: ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 =
//2
//Output: 45
//
//
// Example 2:
//
//
//Input: ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2
//= 2
//Output: 16
//
//
//
// Constraints:
//
//
// -10⁴ <= ax1 <= ax2 <= 10⁴
// -10⁴ <= ay1 <= ay2 <= 10⁴
// -10⁴ <= bx1 <= bx2 <= 10⁴
// -10⁴ <= by1 <= by2 <= 10⁴
//
//
// Related Topics Math Geometry 👍 2042 👎 1654


//leetcode submit region begin(Prohibit modification and deletion)
class L223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int ax = ax2-ax1;
        int ay = ay2-ay1;
        int bx = bx2-bx1;
        int by = by2-by1;
        int area = (ax*ay)+(bx*by);
        int x = 0, y = 0;
        if (!(bx2 < ax1 || ax2 < bx1)) {
            x = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        }
        if (!(by2 < ay1 || ay2 < by1)) {
            y = Math.min(ay2, by2) - Math.max(ay1, by1);
        }
        return area - x*y;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

