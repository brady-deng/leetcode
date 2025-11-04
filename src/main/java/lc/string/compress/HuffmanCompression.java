package lc.string.compress;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class HuffmanNode implements Comparable<HuffmanNode> {
    char character;
    int frequency;
    HuffmanNode leftChild;
    HuffmanNode rightChild;

    public HuffmanNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }

    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    @Override
    public int compareTo(HuffmanNode other) {
        return this.frequency - other.frequency;
    }
}

public class HuffmanCompression {
    private static Map<Character, String> encodingTable;
    private static HuffmanNode root;

    public static String compress(String input) {
        // 计算字符频率
        Map<Character, Integer> frequencyMap = calculateFrequency(input);

        // 构建Huffman树
        buildHuffmanTree(frequencyMap);

        // 生成字符编码表
        encodingTable = new HashMap<>();
        buildEncodingTable(root, "");

        // 压缩输入字符串
        StringBuilder compressed = new StringBuilder();
        for (char c : input.toCharArray()) {
            compressed.append(encodingTable.get(c));
        }

        return compressed.toString();
    }

    public static String decompress(String compressed) {
        StringBuilder decompressed = new StringBuilder();
        HuffmanNode currentNode = root;

        // 解压缩字符串
        for (char bit : compressed.toCharArray()) {
            if (bit == '0') {
                currentNode = currentNode.leftChild;
            } else if (bit == '1') {
                currentNode = currentNode.rightChild;
            }

            if (currentNode.isLeaf()) {
                decompressed.append(currentNode.character);
                currentNode = root;
            }
        }

        return decompressed.toString();
    }

    private static Map<Character, Integer> calculateFrequency(String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        return frequencyMap;
    }

    private static void buildHuffmanTree(Map<Character, Integer> frequencyMap) {
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();

        // 创建叶节点
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            HuffmanNode node = new HuffmanNode(entry.getKey(), entry.getValue());
            priorityQueue.offer(node);
        }

        // 构建Huffman树
        while (priorityQueue.size() > 1) {
            HuffmanNode leftChild = priorityQueue.poll();
            HuffmanNode rightChild = priorityQueue.poll();

            HuffmanNode parentNode = new HuffmanNode('\0', leftChild.frequency + rightChild.frequency);
            parentNode.leftChild = leftChild;
            parentNode.rightChild = rightChild;

            priorityQueue.offer(parentNode);
        }

        // 设置根节点
        root = priorityQueue.poll();
    }

    private static void buildEncodingTable(HuffmanNode node, String code) {
        if (node.isLeaf()) {
            encodingTable.put(node.character, code);
            return;
        }

        buildEncodingTable(node.leftChild, code + "0");
        buildEncodingTable(node.rightChild, code + "1");
    }

    public static void main(String[] args) {
        String original = "HELLO, 不爱运动的跑者!";
        System.out.println("Original: " + original);

        String compressed = compress(original);
        System.out.println("Compressed: " + compressed);

        String decompressed = decompress(compressed);
        System.out.println("DECompressed: " + decompressed);
    }
}