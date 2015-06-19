import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;


public class CovertChannel {


	public CovertChannel() {

	}

	public static void main(String[] args) {
		File f;
		InputStream is = null;
		boolean verbose;
		SecureSystem sys;
		SecurityLevel high = SecurityLevel.HIGH;
		SecurityLevel low = SecurityLevel.LOW;

		if (args.length == 2) {
			verbose = true;
			f = new File(args[1]);
		} else {
			verbose = false;
			f = new File(args[0]);
		}
		sys = new SecureSystem();
		sys.getRef().setVerbose(verbose);
		sys.createSubject("Hal", high);
		sys.createSubject("Lyle", low);

		try {
			Scanner sc = new Scanner(f);
			FileOutputStream outfile = new FileOutputStream(f.getName() + ".out");
			is = new FileInputStream(f);
			FileOutputStream log = new FileOutputStream("log.txt");
			IOUtils.copy(is,log);
			while(sc.hasNextLine()) {

	 		}	
			try {
				outfile.close();
				log.close();
			} catch(IOException io) {
				io.printStackTrace();
			}
	 	} catch(FileNotFoundException e) {
	 		e.printStackTrace();
	 	}

	 	
	}

	
}