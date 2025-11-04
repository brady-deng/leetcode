package lc.string.compress;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LZWCompression {
    public static String compress(String input) {
        Map<String, Integer> dictionary = new HashMap<>();

        // 初始化字典
        for (int i = 0; i < 256; i++) {
            dictionary.put(String.valueOf((char) i), i);
        }

        StringBuilder compressed = new StringBuilder();
        String current = "";
        for (char c : input.toCharArray()) {
            String currentPlusC = current + c;
            if (dictionary.containsKey(currentPlusC)) {
                current = currentPlusC;
            } else {
                compressed.append(dictionary.get(current)).append(" ");
                dictionary.put(currentPlusC, dictionary.size());
                current = String.valueOf(c);
            }
        }

        if (!current.equals("")) {
            compressed.append(dictionary.get(current)).append(" ");
        }

        return compressed.toString();
    }

    public static String decompress(String input) {
        Map<Integer, String> dictionary = new HashMap<>();

        // 初始化字典
        for (int i = 0; i < 256; i++) {
            dictionary.put(i, String.valueOf((char) i));
        }

        String[] compressedArray = input.trim().split(" ");
        List<String> compressedList = new ArrayList<>();
        for (String s : compressedArray) {
            compressedList.add(s);
        }

        StringBuilder decompressed = new StringBuilder();
        int previousCode = Integer.parseInt(compressedList.get(0));
        decompressed.append(dictionary.get(previousCode));
        String current = dictionary.get(previousCode);
        for (int i = 1; i < compressedList.size(); i++) {
            int currentCode = Integer.parseInt(compressedList.get(i));
            String entry;
            if (dictionary.containsKey(currentCode)) {
                entry = dictionary.get(currentCode);
            } else if (currentCode == dictionary.size()) {
                entry = current + current.charAt(0);
            } else {
                throw new IllegalArgumentException("Invalid compressed input");
            }

            decompressed.append(entry);
            dictionary.put(dictionary.size(), current + entry.charAt(0));
            current = entry;
        }

        return decompressed.toString();
    }

    public static void main(String[] args) {
        String original = "TOBEORNOTTOBEORTOBEORNOT2121";
        System.out.println("Original: " + original);

        String compressed = compress(original);
        System.out.println("Compressed: " + compressed);

        String decompressed = decompress(compressed);
        System.out.println("Decompressed: " + decompressed);
    }
}