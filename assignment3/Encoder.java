import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Encoder {

private static char[] letters = new char[26];
private static int[] frequencies = new int[26];
public static int denom = 0;


	public static void main(String[] args) {

		for (char i = 'A'; i <= 'Z'; i++) {
			letters[i-'A'] = i;
		}

		File f = new File(args[0]);
		try {
			Scanner sc = new Scanner(f);
			int index = -1;
			while (sc.hasNextInt()) {
				index++;
				int num;
				num = sc.nextInt();
				frequencies[index] = num;
				denom += num;
			}
		} catch(FileNotFoundException e) { 
			e.printStackTrace(); 
		}
		StringBuilder in = new StringBuilder();
		for (int i = 0; i < frequencies.length; i++) {
			for (int j = 0; j < frequencies[i]; j++) {
				in.append(letters[i]);
			}
		}
		System.out.println(in);
        Huffman.execute(in.toString());
        double entropy = calcEntropy(frequencies);
        System.out.println("Entropy: " + entropy);
        /*
		HuffmanTree one = Huffman.buildTree(frequencies);
		Huffman.printCodes(one, new StringBuffer());*/
	}

	private static double calcEntropy(int[] freq) {
		double log2 = 0.0;
		double total = 0.0;
		for (int i = 0; i < freq.length && freq[i] != 0; i++) {
			double prob = 0.0;
			prob = ((double) (freq[i]))/denom;
			log2 = Math.log(prob) / Math.log(2);
			total = total + (prob * log2);
		}
		return (-1 * total);
	}
}