import java.util.*;

abstract class HuffmanTree implements Comparable<HuffmanTree> {
    public final int frequency; // the frequency of this tree
    public HuffmanTree(int freq) { frequency = freq; }
    
    // compares on the frequency
    public int compareTo(HuffmanTree tree) {
        return frequency - tree.frequency;
    }
}

class HuffmanLeaf extends HuffmanTree {
    public final char value; // the character this leaf represents
    
    public HuffmanLeaf(int freq, char val) {
        super(freq); //super calls a constructor of the superclass, which is HuffmanTree.
        value = val;
    }
}

class HuffmanNode extends HuffmanTree {
    public final HuffmanTree left, right; // subtrees
    
    public HuffmanNode(HuffmanTree l, HuffmanTree r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }
}

public class HuffmanCode {
    // input is an array of frequencies, indexed by character code
    public static HuffmanTree buildTree(int[] charFreqs) {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<HuffmanTree>();
        // initially, we have a forest of leaves
        // one for each non-empty character
        for (int i = 0; i < charFreqs.length; i++) {
            if (charFreqs[i] > 0) {
//changed            	System.out.println("charFreqs[i] = " + charFreqs[i]);
//changed            	System.out.println("i = " + i);
//changed            	System.out.println("(char) i = " + (char)i);
                trees.offer(new HuffmanLeaf(charFreqs[i], (char)i));
            }
        }
        assert trees.size() > 0;
        // loop until there is only one tree left
        while (trees.size() > 1) {
//changed            System.out.println("trees.size() = " + trees.size());
            // two trees with least frequency
//changed            System.out.println("***");
            HuffmanTree a = trees.poll();
            HuffmanTree b = trees.poll();
//changed            //HuffmanLeaf la = (HuffmanLeaf)a;
//changed            //HuffmanLeaf lb = (HuffmanLeaf)b;
//changed            //System.out.println("a.value = " + la.value);
//changed            //System.out.println("b.value = " + lb.value);
//changed            //System.out.println("a.frequency = " + a.frequency);
//changed            //System.out.println("b.frequency = " + b.frequency);
            // put into new node and re-insert into queue
            trees.offer(new HuffmanNode(a, b));
        }
        return trees.poll();
    }
    
    public static void printCodes(HuffmanTree tree, StringBuffer prefix) {
        assert tree != null;
        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf)tree;
            
            // print out character, frequency, and code for this leaf (which is just the prefix)
            System.out.println(leaf.value + "\t" + leaf.frequency + "\t" + prefix);

        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode)tree;
            
            // traverse left
            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length()-1);
            
            // traverse right
            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }
    
    public static void main(String[] args) {
//changed        //String test = "this is an example for huffman encoding";
//changed        String test = "aabbcd"; // ehrt
        
        // we will assume that all our characters will have
        // code less than 256, for simplicity
        int[] charFreqs = new int[256];
        // read each character and record the frequencies
        for (char c : test.toCharArray()) {
//changed            System.out.println("c = " + c );
            charFreqs[c]++;
//changed            System.out.println("carFreqs = " + Arrays.toString(charFreqs));
        }
        
        // build tree
        HuffmanTree tree = buildTree(charFreqs);

        // print out results
        System.out.println("SYMBOL\tWEIGHT\tHUFFMAN CODE");
        printCodes(tree, new StringBuffer());
    }
}