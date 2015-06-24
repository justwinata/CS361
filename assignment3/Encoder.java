import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Encoder {

	public static void main(String[] args) {

		private char[] letters = new char[26];
		private int[] frequencies = new int[26];

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
}