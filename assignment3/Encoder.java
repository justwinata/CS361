import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class Encoder {

	private static char[] letters = new char[26];
	private static int[] frequencies = new int[26];
	private static String[] letters2 = new String[676];
	private static int[] frequencies2 = new int[676];
	public static int denom = 0;
	public static HashMap<Character,String> chartocode;
	public static HashMap<String,Character> codetochar;
	public static HashMap<Character,String> chartocode2;
	public static HashMap<String,Character> codetochar2;


	public static void main(String[] args) {
		File f = new File(args[0]);
		int k = Integer.parseInt(args[1]);

		chartocode = new HashMap<Character,String>();
		codetochar = new HashMap<String,Character>();
		chartocode2 = new HashMap<Character,String>();
		codetochar2 = new HashMap<String,Character>();

		for (char i = 'A'; i <= 'Z'; i++) {
			letters[i-'A'] = i;
		}

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
		
        Huffman.execute(in.toString(), codetochar, chartocode);

        generateTestText(k, in.toString());

        encodeOne();

        decodeOne();

        int letters2idx = 0;
        for (char i = 'A'; i <= 'Z'; i++) {
        	for (char j = 'A'; j <= 'Z'; j++) {
				StringBuilder sb = new StringBuilder();
				sb.append(i);
				sb.append(j);
				letters2[letters2idx] = sb.toString();
				frequencies2[letters2idx] = frequencies[i - 'A'] * frequencies[j - 'A'];
if (frequencies2[letters2idx] != 0) {
System.out.println(letters2[letters2idx] + ": " + frequencies2[letters2idx]);
}
				letters2idx++;
			}
        }

        StringBuilder in2 = new StringBuilder();
		for (int i = 0; i < frequencies2.length; i++) {
			for (int j = 0; j < frequencies2[i]; j++) {
				in2.append(letters2[i]);
			}
		}
		System.out.println(in2);

        Huffman.execute(in2.toString(), codetochar2, chartocode2);
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

	private static void encodeOne () {
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
	private static void decodeOne () {
		StringBuilder dec1 = new StringBuilder();
		StringBuilder check = new StringBuilder();
		try {
			File f = new File("testText.enc1");
			Scanner sc = new Scanner (f);
			sc.useDelimiter("");
			while (sc.hasNext()) {
				check.append(sc.next());
				if (codetochar.containsKey(check.toString())){
					dec1.append(codetochar.get(check.toString()));
					check.delete(0, check.length());
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			PrintWriter w = new PrintWriter("testText.dec1", "UTF-8");
			w.print(dec1);
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