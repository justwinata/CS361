import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Encoder {

	public static void main(String[] args) {
		File f = new File(args[0]);
		try {
			Scanner sc = new Scanner(f);
			while (sc.hasNextInt()) {
				int k;
				k = sc.nextInt();
				
			}
		} catch(FileNotFoundException e) { 
			e.printStackTrace(); 
		}	
	}
}