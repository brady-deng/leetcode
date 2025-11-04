package lc.search;

/**
 * <p>
 *     We can use the binary search approach to solve this problem. The intuition is to determine which part of the array is sorted, and then check if the target element lies in that sorted part. If it does, then continue the search in that part of the array. If not, then continue the search in the other part of the array.
 *
 * Approach:
 * Initialize the start and end indices to the first and last elements of the array, respectively.
 * Perform a binary search by repeatedly dividing the search space in half.
 * Calculate the middle index using the formula mid = start + (end - start) / 2.
 * Check if the target value is equal to the element at the middle index. If so, return true since the target is found.
 * Compare the element at the start index with the element at the middle index to determine if the left half is sorted or the right half is sorted.
 * If the left half is sorted, check if the target value lies within the range of the sorted left half (nums[start] <= target < nums[mid]). If it does, update the end index to mid - 1 to search in the left half; otherwise, update the start index to mid + 1 to search in the right half.
 * If the right half is sorted, check if the target value lies within the range of the sorted right half (nums[mid] < target <= nums[end]). If it does, update the start index to mid + 1 to search in the right half; otherwise, update the end index to mid - 1 to search in the left half.
 * If none of the above conditions are satisfied, it means there are duplicate elements at the start and middle indices. In this case, increment the start index by 1 and continue the search.
 * Repeat steps 3-6 until the start index is less than or equal to the end index.
 * If the target value is not found after the search, return false.
 * Complexity:
 * Time Complexity: The time complexity of the binary search algorithm is O(log N), where N is the number of elements in the array.
 * Space Complexity: The space complexity is O(1) since the algorithm uses a constant amount of additional space to store the indices and variables.
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20230629
 **/
public class L81Ans {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == nums[mid]) {
                return true;
            } else if (nums[start] < nums[mid]) {
                if (nums[start] <= target && nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (nums[mid] < nums[start]) {
                if (nums[end] >= target && nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                start += 1;
            }
        }

        return false;
    }
}
