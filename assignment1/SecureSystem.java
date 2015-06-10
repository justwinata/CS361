import java.util.Scanner;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;

public class SecureSystem {
	
	public SecureSystem(){
		
	}

	public static void main(String[] args) {

	 	SecureSystem sys = new SecureSystem();
	 	ReferenceMonitor ref = new ReferenceMonitor();

	 	SecurityLevel low  = SecurityLevel.LOW;
		SecurityLevel high = SecurityLevel.HIGH;

		ref.createSubject("Lyle", low);
		ref.createSubject("Hal", high);
		ref.createObject("LObj",low);
		ref.createObject("HObj", high);
	 	
		// we'll use Scanner nextLine() to read each individual line in the file 
		try {
			Scanner input = new Scanner(new File(args[0]));
			while (input.hasNextLine()) {
				String line = input.nextLine().toLowerCase();
				String[] params = line.split("\\s+");
				InstructionObject io;
				if (checkRead(params)) {
					io = new InstructionObject(params[0], params[1], params[2]);
				} else if (checkWrite(params)) {
					int value = Integer.parseInt(params[3]);
					 io = new InstructionObject(params[0], params[1], params[2], value);
					
				} else {
					String b = "bad";
					io = new InstructionObject(b);
				}
				ref.addInstruction(io);
			}
		} catch(FileNotFoundException e) { 
			e.printStackTrace(); 
		}	
	}


	public static boolean checkRead(String[] params) {
		if (params[0].equals("read")) {
			if (params.length == 3) {
				return true;
			} 
		} 
		return false;	
	}

	public static boolean checkWrite(String[] params) {
		if (params[0].equals("write")) {
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