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
        super(freq);
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
 
public class Huffman {
    public static int bitcount = 0;
    public static int bitcount2 = 0;
    // input is an array of frequencies, indexed by character code
    public static HuffmanTree buildTree(int[] charFreqs) {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<HuffmanTree>();
        // initially, we have a forest of leaves
        // one for each non-empty character
        for (int i = 0; i < charFreqs.length; i++)
            if (charFreqs[i] > 0)
                trees.offer(new HuffmanLeaf(charFreqs[i], (char)i));
 
        assert trees.size() > 0;
        // loop until there is only one tree left
        while (trees.size() > 1) {
            // two trees with least frequency
            HuffmanTree a = trees.poll();
            HuffmanTree b = trees.poll();
 
            // put into new node and re-insert into queue
            trees.offer(new HuffmanNode(a, b));
        }
        return trees.poll();
    }
 
    public static int printCodes(HuffmanTree tree, StringBuffer prefix, HashMap<String,Character> codetochar, HashMap<Character,String> chartocode) {
        assert tree != null;
        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf)tree;
            chartocode.put(leaf.value, prefix.toString());
            codetochar.put(prefix.toString(), leaf.value); 
            bitcount += prefix.length();
            // print out character, frequency, and code for this leaf (which is just the prefix)
            System.out.println(leaf.value + "\t" + leaf.frequency + "\t" + prefix);
 
        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode)tree;
 
            // traverse left
            prefix.append('0');
            printCodes(node.left, prefix, codetochar, chartocode);
            prefix.deleteCharAt(prefix.length()-1);
 
            // traverse right
            prefix.append('1');
            printCodes(node.right, prefix, codetochar, chartocode);
            prefix.deleteCharAt(prefix.length()-1);
        }
        return bitcount;
    }
 
    public static void main(String[] args) {

    }

    public static int execute(String in, HashMap<String,Character> codetochar, HashMap<Character,String> chartocode) {
        String test = in;
 
        // we will assume that all our characters will have
        // code less than 256, for simplicity
        int[] charFreqs = new int[256]; 
        // read each character and record the frequencies
        for (char c : test.toCharArray())
            charFreqs[c]++;
 
        // build tree
        HuffmanTree tree = buildTree(charFreqs);
        
        // print out results
        System.out.println("SYMBOL\tFREQ\tHUFFMAN CODE");
        return printCodes(tree, new StringBuffer(), codetochar, chartocode);
    }

    public static int execute2(String in, HashMap<String,String> codetochar, HashMap<String,String> chartocode, HashMap<Character,String> chartopair) {
        String test = in;
 
        // we will assume that all our characters will have
        // code less than 256, for simplicity
        int[] charFreqs = new int[1024]; 
        // read each character and record the frequencies
        for (char c : test.toCharArray())
            charFreqs[c]++;
 
        // build tree
        HuffmanTree tree = buildTree(charFreqs);
        // print out results
        System.out.println("SYMBOL\tFREQ\tHUFFMAN CODE");
        return printCodes2(tree, new StringBuffer(), codetochar, chartocode, chartopair);
    }

    public static int printCodes2(HuffmanTree tree, StringBuffer prefix, HashMap<String,String> codetochar, HashMap<String,String> chartocode, HashMap<Character,String> chartopair) {
        assert tree != null;
        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf)tree;
            chartocode.put(chartopair.get(leaf.value), prefix.toString());
            codetochar.put(prefix.toString(), chartopair.get(leaf.value)); 
            bitcount2 += prefix.length();
            // print out character, frequency, and code for this leaf (which is just the prefix)
            System.out.println(chartopair.get(leaf.value) + "\t" + leaf.frequency + "\t" + prefix);
 
        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode)tree;
 
            // traverse left
            prefix.append('0');
            printCodes2(node.left, prefix, codetochar, chartocode, chartopair);
            prefix.deleteCharAt(prefix.length()-1);
 
            // traverse right
            prefix.append('1');
            printCodes2(node.right, prefix, codetochar, chartocode, chartopair);
            prefix.deleteCharAt(prefix.length()-1);
        }
        return bitcount2;
    }

}