import java.util.*;
import java.io.*;

public class HuffmanCode {
    // TODO: Your Code Here
    HuffmanNode huffmanTree;

    public HuffmanCode(int[] frequencies) {
        Queue<HuffmanNode> pq = new PriorityQueue<>();

        for(int i = 0; i < frequencies.length; i++) {
            pq.add(new HuffmanNode(i, frequencies[i]));
        }

        huffmanTree = buildNewTree(pq);
    }

    public HuffmanCode(Scanner input) {
        while(input.hasNextLine()) {
            int asciiValue = Integer.parseInt(input.nextLine());
            String code = input.nextLine();
            huffmanTree = buildExistTree(asciiValue, code, huffmanTree);
        }
    }

    public void save(PrintStream output) {
        save(output, huffmanTree, "");
    }

    private void save(PrintStream output, HuffmanNode root, String code) {
        if(root.left == null || root.right == null) {
            output.println(root.letterValue);
            output.println(code);
        } else {
            if(root.left != null) {
                save(output, root.left, code + "0");
            }
            if(root.right != null) {
                save(output, root.right, code + "1");
            }
        }
    }

    public void translate(Scanner input, PrintStream output) {
        translate(input, output, huffmanTree);
    }

    private void translate(Scanner input, PrintStream output, HuffmanNode root) {
        for(int i = 0; i < input.next().length(); i++) {
            if(root.left == null && root.right == null) {
                output.write((char)root.letterValue);
                root = huffmanTree;
            }
            if(input.next().charAt(i) == '0') {
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }




    private HuffmanNode buildExistTree(int asciiValue, String code, HuffmanNode root) {
        if(code.length() == 0) {
            root = new HuffmanNode(asciiValue, 0);
        } else {
            if(root == null) {
                root = new HuffmanNode(-1, 0);
            }

            if(code.charAt(0) == '0') {
                root.left = buildExistTree(asciiValue, code.substring(1), root.left);
            } else {
                root.right = buildExistTree(asciiValue, code.substring(1), root.right);
            }
        }
        return root;
    }


    private HuffmanNode buildNewTree(Queue<HuffmanNode> pq) {

        while(pq.size() > 1) {
            HuffmanNode first = pq.remove();
            HuffmanNode second = pq.remove();
            HuffmanNode sum =
                    new HuffmanNode(-1, first.frequency + second.frequency, first, second);

            pq.add(sum);
        }
        return pq.remove();
    }



    private static class HuffmanNode implements Comparable<HuffmanNode> {
        public int letterValue;
        public int frequency;
        public HuffmanNode left;
        public HuffmanNode right;

        public HuffmanNode(int letter, int frequency) {
            this(letter, frequency, null, null);
        }

        public HuffmanNode(int letter, int frequency, HuffmanNode left, HuffmanNode right) {
            this.letterValue = letter;
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }

        public int compareTo(HuffmanNode other) {
            return this.frequency - other.frequency;
        }
    }



}