import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class Encoder {

	private static char[] letters = new char[26];
	private static int[] frequencies = new int[26];

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
			}
		} catch(FileNotFoundException e) { 
			e.printStackTrace(); 
		}	
	}

	private static double calcEntropy(int[] freq) {
		double log2 = 0.0;
		double total = 0.0;
		for (int i = 0; i < freq.length; i++) {
			log2 = Math.log(freq[i]) / Math.log(2);
			total = total + ((1 / freq[i]) * log2);
		}
		return (-1 * total);
	}
}