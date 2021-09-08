package lc;

import java.util.Scanner;

public class L69 {
    private static long threshold = 0;

    public static void main(String[] args) {
        System.out.println("Please input the x:");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println(mySqrt(x));
    }

    public static int mySqrt(int x) {
        if(x < 2) return x;

        return (int)BinarySearch(x, 1, x);
    }

    public static long BinarySearch(long target, long start, long end)
    {
        if(start <= end)
        {
            long mid = start + (end - start) / 2;

            if(mid*mid == target)return mid;
            else if(mid == threshold) return threshold -1;

            threshold = mid;
            return((mid*mid > target) ?
                    BinarySearch(target, start, mid) :
                    BinarySearch(target, mid + 1, end));
        }

        return -1;
    }
}
