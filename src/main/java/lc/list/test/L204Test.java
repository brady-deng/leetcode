package lc.list.test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class L204Test extends main.java.lc.list.L204 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n > 0) {
            System.out.println(new L204Test().countPrimes(n));
            n = sc.nextInt();
        }
    }


    public int countPrimes(int n) {
        if(n <= 1) return 0;
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i*i < n; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j < n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}
