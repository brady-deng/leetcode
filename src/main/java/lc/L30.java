package main.java.lc;

import java.util.*;

/**
 * @author dengchenyang.brady@bytedance.com
 * @description
 * @date 2021/7/5
 **/
public class L30 {
    public static void main(String[] args) {
        System.out.println("Please input the String:");
        Scanner scanner = new Scanner(System.in);
        String tmp = scanner.nextLine();
        System.out.println("Please input the num of words:");
        int n = scanner.nextInt();
        String[] words = new String[n];
        scanner.nextLine();
        for (int i = 0;i<n;i++) {
            System.out.println("Please input the word");
            words[i] = scanner.nextLine();
        }

        System.out.println(findSubstring(tmp, words));

    }
    public static List<Integer> findSubstring(String s, String[] words) {
        int m = words.length;
        int n = words[0].length();
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> m1 = buildWordMap(words);
        int i = 0;
        StringBuilder prev = new StringBuilder("");
        while (i < s.length()-m*n+1){
            if (!(!res.isEmpty() && prev.toString().equals(s.substring(res.get(res.size()-1)+m*n,i+m*n)) && prev.length() == n)) {
                prev.append(s.charAt(i));
                String[] tmp = splitWords(s.substring(i, i+m*n), m, n);
                Map<String, Integer> m2 = buildWordMap(tmp);
                if (comparaWordMap(m1, m2)) {
                    res.add(i);
                    prev = new StringBuilder(s.substring(i,i+1));
                }
                i+=1;
            }
            else {
                res.add(i);
                i+=n;
                prev = new StringBuilder("");
            }
        }
        return res;
    }

    public static String[] splitWords(String tmp, int m, int n) {
        String[] res = new String[m];
        for (int i = 0;i<m;i++) {
            res[i] = tmp.substring(i*n,(i+1)*n);
        }
        return res;
    }

    public static Map<String, Integer> buildWordMap(String[] words) {
        Map<String, Integer> res = new HashMap<>();
        for (String word:words) {
            res.put(word, res.getOrDefault(word, 0)+1);
        }
        return res;
    }

    public static boolean comparaWordMap(Map<String, Integer> m1, Map<String, Integer> m2) {
        for (Map.Entry<String, Integer> entry:m1.entrySet()) {
            if (!m2.getOrDefault(entry.getKey(), 0).equals(entry.getValue())) {
                return false;
            }
        }
        return true;
    }


    public static boolean comparaWords(String[] w1, String[] w2) {
        Arrays.sort(w1);
        Arrays.sort(w2);
        for (int i = 0; i<w1.length;i++) {
            if (!w1[i].equals(w2[i])) {
                return false;
            }
        }
        return true;
    }
}
