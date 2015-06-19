import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class CovertChannel {


	public CovertChannel() {

	}

	public static void main(String[] args) {
		File f;
		boolean verbose;
		SecureSystem sys;
		if (args.length == 2) {
			verbose = true;
			f = new File(args[1]);
		} else {
			verbose = false;
			f = new File(args[0]);
		}
		sys = new SecureSystem();

		try {
			FileOutputStream outfile = new FileOutputStream(f.getName() + ".out");
	 		FileOutputStream log = new FileOutputStream("log.txt");
	 	} catch(FileNotFoundException e) {
	 		e.printStackTrace();
	 	}	
	}

	
}