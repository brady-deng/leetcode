package lc.string;

import java.util.Arrays;

public class L402 {


    public static void main(String[] args) {
        String s = lc.util.LUtil.inputString();
        int k = lc.util.LUtil.inputNum();
        System.out.println(new Solution().removeKdigits(s, k));
        System.out.println(new Solution().removeKdigits2(s, k));
    }
}

//Given string num representing a non-negative integer num, and an integer k,
//return the smallest possible integer after removing k digits from num.
//
//
// Example 1:
//
//
//Input: num = "1432219", k = 3
//Output: "1219"
//Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219
//which is the smallest.
//
//
// Example 2:
//
//
//Input: num = "10200", k = 1
//Output: "200"
//Explanation: Remove the leading 1 and the number is 200. Note that the output
//must not contain leading zeroes.
//
//
// Example 3:
//
//
//Input: num = "10", k = 2
//Output: "0"
//Explanation: Remove all the digits from the number and it is left with
//nothing which is 0.
//
//
//
// Constraints:
//
//
// 1 <= k <= num.length <= 10⁵
// num consists of only digits.
// num does not have any leading zeros except for the zero itself.
//
//
// Related Topics String Stack Greedy Monotonic Stack 👍 9984 👎 527


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeKdigits(String num, int k) {
        char[] chars = num.toCharArray();
        if (k >= num.length()) return "0";
        return appendDigits(chars, 0, num.length()-k, new StringBuilder(), String.valueOf(Integer.MAX_VALUE));
    }

    public String appendDigits(char[] num, int i, int k, StringBuilder ans, String r) {
        if (i == num.length && k != 0) {
            return r;
        }
        if (k == 0) {
            int i1 = Integer.parseInt(ans.toString());
            int i2 = Integer.parseInt(r);
            return i1 < i2 ? String.valueOf(i1) : String.valueOf(i2);
        }
        ans.append(num[i]);
        int i1 = Integer.parseInt(appendDigits(num, i + 1, k - 1, ans, r));
        ans.deleteCharAt(ans.length() - 1);
        int i2 = Integer.parseInt(appendDigits(num, i + 1, k, ans, r));
        return i1 < i2 ? String.valueOf(i1) : String.valueOf(i2);
    }

    public String removeKdigits2(String num, int k) {
        if (k >= num.length()) return "0";
        char[] chars = num.toCharArray();
        char[] stack = new char[num.length()];
        int top = -1;
        int index = 0;
        while (index < chars.length) {
            while (k > 0 && top >= 0 && chars[index] < stack[top]) {
                top--;
                k--;
            }
            stack[++top] = chars[index++];
        }
        while (k > 0) {
            top--;
            k--;
        }
        int i = 0;
        boolean leadingZero = true;
        StringBuilder ans = new StringBuilder();
        while (i <= top) {
            if (leadingZero && stack[i] == '0') {
                i++;
                continue;
            }
            leadingZero = false;
            ans.append(stack[i++]);
        }
        return ans.length() == 0 ? "0" : ans.toString();
    }


    public String removeDigits(char[] num, int i, int k, String ans) {
        if (i == num.length) {
            return Arrays.toString(num);
        }
        if (k == 0) {
            String tmp = Arrays.toString(num).replace("-", "");
            int r = Integer.parseInt(tmp);
            return r < Integer.parseInt(ans) ? tmp: ans;
        }
        char t = num[i];
        num[i] = '-';
        String tmp1 = removeDigits(num, i+1, k-1, ans);
        num[i] = t;
        String tmp2 = removeDigits(num, i+1, k, ans);
        int i1 = Integer.parseInt(tmp1);
        int i2 = Integer.parseInt(tmp2);
        return i1 < i2 ? tmp1: tmp2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

