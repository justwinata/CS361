import java.util.Scanner;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;

public class SecureSystem {
	private ReferenceMonitor ref;

	public SecureSystem(){
		ref = new ReferenceMonitor();
	}

	public ReferenceMonitor getRef() {
		return ref;
	}

	public static void main(String[] args) {

	 	SecureSystem sys = new SecureSystem();
	 	SecurityLevel low  = SecurityLevel.LOW;
		SecurityLevel high = SecurityLevel.HIGH;

		sys.getRef().createSubject("Lyle", low);
		sys.getRef().createSubject("Hal", high);
		sys.getRef().createObject("LObj",low);
		sys.getRef().createObject("HObj", high);
	 	
		// we'll use Scanner nextLine() to read each individual line in the file 
		try {
			Scanner input = new Scanner(new File(args[0]));
			System.out.println("\nReading from file: " + args[0]+ "\n");

			while (input.hasNextLine()) {
				String line = input.nextLine();
				String[] params = line.split("\\s+");
				InstructionObject io;
				if (checkRead(params) || checkCreate(params) || checkDestroy) {
					io = new InstructionObject(params[0], params[1], params[2]);
				} else if (checkWrite(params)) {
					int value = Integer.parseInt(params[3]);
					 io = new InstructionObject(params[0], params[1], params[2], value);
					
				} else if (checkRead(params)){
					io = new InstructionObject(params[0], params[1]);
				} else {
					String b = "bad";
					io = new InstructionObject(b);
				}
				sys.getRef().addInstruction(io);
			}
		} catch(FileNotFoundException e) { 
			e.printStackTrace(); 
		}	
	}

	public void createSubject(String s, SecurityLevel l) {
		getRef().createSubject(s,l);
	}

	public static boolean checkRun(String[] params) {
		if (params[0].toLowerCase().equals("run")) {
			if (params.length == 2) {
				return true;
			} 
		} 
		return false;	
	}

	public static boolean checkDestroy(String[] params) {
		if (params[0].toLowerCase().equals("destroy")) {
			if (params.length == 3) {
				return true;
			} 
		} 
		return false;	
	}

	public static boolean checkCreate(String[] params) {
		if (params[0].toLowerCase().equals("create")) {
			if (params.length == 3) {
				return true;
			} 
		} 
		return false;	
	}

	public static boolean checkRead(String[] params) {
		if (params[0].toLowerCase().equals("read")) {
			if (params.length == 3) {
				return true;
			} 
		} 
		return false;	
	}

	public static boolean checkWrite(String[] params) {
		if (params[0].toLowerCase().equals("write")) {
			if (params.length == 4) {
				try {
					int value = Integer.parseInt(params[3]);
				} catch (NumberFormatException n) {
					return false;
				}
				return true;
			} 
		} 
		return false;
	}

}