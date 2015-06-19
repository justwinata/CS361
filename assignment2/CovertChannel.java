import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class CovertChannel {

	private boolean verbose;
	private SecureSystem sys;
	private FileOutputStream outfile;
	private FileOutputStream log;

	public CovertChannel() {

	}
	
	public static void main(String[] args) {
		File f;
		if (args.length == 2) {
			verbose = true;
			f = new File(args[1]);
			log = new FileOutputStream("log.txt");
		} else {
			verbose = false;
			f = new File(args[0]);
		}
		outfile = new FileOutputStream(f.getName() + ".out");
		sys = new SecureSystem();

	}

	
}