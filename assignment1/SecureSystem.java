import java.util.Scanner;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;

public class SecureSystem {
	// object and subject have mapping for name and their values
	private HashMap<String,Integer> objectValues;
	private HashMap<String,Integer> subjectValues;
	// object and subject mapping for name and security levels
	private HashMap<String, SecurityLevel> objectLevels;
	private HashMap<String, SecurityLevel> subjectLevels;

	public SecureSystem(){
		objectValues = new HashMap<String, Integer>();
	 	subjectValues = new HashMap<String, Integer>();
	 	objectLevels = new HashMap<String, SecurityLevel>();
	 	subjectLevels = new HashMap<String, SecurityLevel>();
	}

	public void createSubject(String name, SecurityLevel level) {
		subjectLevels.put(name,level);
	}
	 

	public static void main(String[] args) {

	 	SecureSystem sys = new SecureSystem();
	 	ReferenceMonitor ref = new ReferenceMonitor();

	 	SecurityLevel low  = SecurityLevel.LOW;
		SecurityLevel high = SecurityLevel.HIGH;

		sys.createSubject("Lyle", low);
		sys.createSubject("Hal", high);
	 	
		// we'll use Scanner nextLine() to read each individual line in the file 
		try {
			Scanner input = new Scanner(new File(args[0]));
		}
		catch(FileNotFoundException e){ e.printStackTrace();}	
	}

	class InstructionObject {

		public InstructionObject(String instruction) {}
	}

	public enum SecurityLevel {
			LOW(0),
			HIGH(1);

			public int num;

			private SecurityLevel(int value) {
				num = value;
			}

			public boolean dominates(SecurityLevel l) {
				if (this.num >= l.num)
					return true;
				else 
					return false;
			}
	}

}