package main.java.lc.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ServiceLoader;

/**
 * @input 1, 2, 3, 54, 23, 22, 66, 34, 18
 * @author dengchenyang.brady@bytedance.com
 * @date 20230426
 **/

@Slf4j
public class SortMain {
    public static void main(String[] args) throws Exception {
        log.info("Please input the nums:");
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
        ServiceLoader<Sort> serviceLoader = ServiceLoader.load(Sort.class);
        for (Sort sort: serviceLoader) {
            int[] tmp = Arrays.copyOf(nums, nums.length);
            log.info("Original: {}, Sort Method start:{}", tmp, sort.getClass());
            tmp = sort.sort(tmp);
            log.info("Res: {}, Sort Method done:{} ", tmp, sort.getClass());
        }
    }

}
