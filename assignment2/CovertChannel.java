import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.PrintWriter;


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
		sys.createSubject("Hal", high);
		sys.createSubject("Lyle", low);
		try {
			Scanner sc = new Scanner(f);
			FileOutputStream outfile = new FileOutputStream(f.getName() + ".out");
			is = new FileInputStream(f);
<<<<<<< HEAD
			FileOutputStream log = new FileOutputStream("log.txt");
			IOUtils.copy(is,log);
			while(sc.hasNextLine()) {
=======
			PrintWriter log = new PrintWriter ("log.txt");
			sys.getRef().setVerbose(verbose, log);
		//	while(sc.hasNextLine()) {
>>>>>>> 2acc28a709a31a6a0e09eb7c22b63679f365f074

	 	//	}	
			try {
				outfile.close();
				log.close();
			} catch(IOException io) {
				io.printStackTrace();
			}
	 	} catch(FileNotFoundException e) {
	 		e.printStackTrace();
	 	}
	 	//sys.getRef().addInstruction()
	 	System.exit(1);
	}

	
}