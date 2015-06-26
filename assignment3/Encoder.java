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
	public static int denom2 = 0;
	public static HashMap<Character,String> chartocode;
	public static HashMap<String,Character> codetochar;
	public static HashMap<String,String> chartocode2;
	public static HashMap<String,String> codetochar2;
	public static HashMap<Character,String> chartopair;
	public static HashMap<String,Character> pairtochar;
	public static int bitcount = 0;
	public static int symcount = 0;
	public static int bitcount2 = 0;
	public static int symcount2 = 0;


	public static void main(String[] args) {
		File f = new File(args[0]);
		int k = Integer.parseInt(args[1]);

		chartocode = new HashMap<Character,String>();
		codetochar = new HashMap<String,Character>();
		chartocode2 = new HashMap<String,String>();
		codetochar2 = new HashMap<String,String>();
		chartopair = new HashMap<Character,String>();
		pairtochar = new HashMap<String,Character>();

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
				if (num != 0) {
					frequencies[index] = num;
					symcount++;
				}
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
        
        double entropy = calcOptimalEntropy(frequencies);
        System.out.println("Computed Optimal Entropy: " + entropy);
		
        bitcount = Huffman.execute(in.toString(), codetochar, chartocode);

        generateTestText(k, in.toString());

        encodeOne();

        decodeOne();

        double avg1 = calcAvgBit(symcount, bitcount);
        System.out.println("Average bits per symbol (1-symbol encoding): " + avg1);

        int letters2idx = 0;
        char ctp = '0';
        for (char i = 'A'; i <= 'Z'; i++) {
        	for (char j = 'A'; j <= 'Z'; j++) {
				StringBuilder sb = new StringBuilder();
				sb.append(i);
				sb.append(j);
				letters2[letters2idx] = sb.toString();
				frequencies2[letters2idx] = frequencies[i - 'A'] * frequencies[j - 'A'];
				if (frequencies2[letters2idx] != 0) {
					chartopair.put(ctp, letters2[letters2idx]);
					pairtochar.put(letters2[letters2idx], ctp);
					ctp++;
					symcount2++;
				}
				denom2 += frequencies2[letters2idx];
				letters2idx++;
			}
        }
        StringBuilder in2 = new StringBuilder();
		for (int i = 0; i < frequencies2.length; i++) {
			for (int j = 0; j < frequencies2[i]; j++) {
				in2.append(pairtochar.get(letters2[i]));
			}
		}
        bitcount2 = Huffman.execute2(in2.toString(), codetochar2, chartocode2, chartopair);

        encodeTwo();

        decodeTwo();

        double avg2 = calcAvgBit2(symcount2, bitcount2);
        System.out.println("Average bits per symbol (2-symbol encoding): " + avg2);
    }

	private static double calcOptimalEntropy(int[] freq) {
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

	private static double calcAvgBit (int symbols, int bits) {
		return (((double)bits) / symbols);
	}

	private static double calcAvgBit2 (int symbols, int bits) {
		return (((double)bits) / (2 * symbols));
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
	private static void encodeTwo () {
		StringBuilder enc2 = new StringBuilder();
		StringBuilder pair = new StringBuilder();
		try {
			File f = new File("testText");
			Scanner sc = new Scanner (f);
			sc.useDelimiter("");
			while (sc.hasNext()) {
				pair.append(sc.next());
				pair.append(sc.next());
				enc2.append(chartocode2.get(pair.toString()));
				pair.delete(0, pair.length());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			PrintWriter w = new PrintWriter("testText.enc2", "UTF-8");
			w.print(enc2);
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
	private static void decodeTwo () {
		StringBuilder dec2 = new StringBuilder();
		StringBuilder check = new StringBuilder();
		try {
			File f = new File("testText.enc2");
			Scanner sc = new Scanner (f);
			sc.useDelimiter("");
			while (sc.hasNext()) {
				check.append(sc.next());
				if (codetochar2.containsKey(check.toString())){
					dec2.append(codetochar2.get(check.toString()));
					check.delete(0, check.length());
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			PrintWriter w = new PrintWriter("testText.dec2", "UTF-8");
			w.print(dec2);
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