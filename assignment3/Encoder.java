import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class Encoder {

	private static char[] letters = new char[26];
	private static int[] frequencies = new int[26];
	public static int denom = 0;
	public static HashMap<Character,String> chartocode;
	public static HashMap<String,Character> codetochar;


	public static void main(String[] args) {

	chartocode = new HashMap<Character,String>();
	codetochar = new HashMap<String,Character>();

		for (char i = 'A'; i <= 'Z'; i++) {
			letters[i-'A'] = i;
		}

		File f = new File(args[0]);
		int k = Integer.parseInt(args[1]);
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
        double entropy = calcEntropy(frequencies);
        System.out.println("Computed Optimal Entropy: " + entropy);
		System.out.println(in);
        Huffman.execute(in.toString(), codetochar, chartocode);
        generateTestText(k, in.toString());
        generateEncodingOne();
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

	private static void generateTestText(int k, String in) {
		StringBuilder testfile = new StringBuilder();
		char[] dartboard = in.toCharArray();
		while (testfile.length() < k) {
			int rand = (int) (Math.random() * in.length());
			testfile.append(dartboard[rand]);
		}
		try {
			PrintWriter w = new PrintWriter("testText", "UTF-8");
			w.print(testfile);
			try {
				w.close();
			} catch(NullPointerException npe) {
				npe.printStackTrace();
			}
	 	} catch(FileNotFoundException e) {
	 		e.printStackTrace();
	 	} catch(UnsupportedEncodingException uee) {
	 		uee.printStackTrace();
	 	}
	}

	private static void generateEncodingOne () {
		StringBuilder enc1 = new StringBuilder();
		try {
			File f = new File("testText");
			Scanner sc = new Scanner (f);
			sc.useDelimiter("");
			while (sc.hasNext()) {
				String next = sc.next();
				char c = next.charAt(0);
				enc1.append(chartocode.get(c));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			PrintWriter w = new PrintWriter("testText.enc1", "UTF-8");
			w.print(enc1);
			try {
				w.close();
			} catch (NullPointerException npe) {
				npe.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException uee) {
			uee.printStackTrace();
		}
	}
}