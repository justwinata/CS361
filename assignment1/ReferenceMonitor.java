import java.util.Scanner;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;

public class ReferenceMonitor {
	// object and subject have mapping for name and their values
	private HashMap<String,Integer> objectValues;
	private HashMap<String,Integer> subjectValues;
	// object and subject mapping for name and security levels
	private HashMap<String, SecurityLevel> objectLevels;
	private HashMap<String, SecurityLevel> subjectLevels;
	private InstructionObject inObj;

	public ReferenceMonitor() {
		ObjectManager om = new ObjectManager();
		objectValues = new HashMap<String, Integer>();
	 	subjectValues = new HashMap<String, Integer>();
	 	objectLevels = new HashMap<String, SecurityLevel>();
	 	subjectLevels = new HashMap<String, SecurityLevel>();
	}

	
	public void addInstruction(InstructionObject io) {
		this.inObj = io;
		SecurityLevel one = subjectLevels.get(inObj.getSubject());
		SecurityLevel two = objectLevels.get(inObj.getObject());
		if (inObj.getType().equals("read")) {
			String s = inObj.getSubject();
			int v = objectValues.get(inObj.getObject());
			if (one.dominates(two)) {
				subjectValues.put(s,v);
			} else {
				subjectValues.put(s,0);
			}
			printExecute(inObj);
		} else if (inObj.getType().equals("write")) {
			String s = inObj.getObject();
			int v = inObj.getValue();
			if (!one.dominates(two)|| one.equals(two)) {
				objectValues.put(s,v);
			}
			printExecute(inObj);
		} else {
			printExecute(inObj);
		}
			
	}

	public void printExecute (InstructionObject io) {
		
		if (io.getType().equals("read")) {
			System.out.println(io.getSubject() + " reads " + io.getObject());
		}
		else if (io.getType().equals("write")) {
			System.out.println(io.getSubject() + " writes value " + io.getValue() + " to " + io.getObject());
		}
		else  { 
			System.out.println("Bad Instruction");
		}
		printState();
	}

	
	public void printState () {
		System.out.println("The current state is:");
		System.out.println("   " + "LObj" + " has value: " + objectValues.get("LObj".toLowerCase()));
		System.out.println("   " + "HObj" + " has value: " + objectValues.get("HObj"));
		System.out.println("   " + "Lyle" + " has recently read: " + subjectValues.get("Lyle"));
		System.out.println("   " + "Hal" + " has recently read: " + subjectValues.get("Hal"));
		System.out.println();
	}
	
	
	public void createSubject(String s, SecurityLevel l) {
		s = s.toLowerCase();
		subjectLevels.put(s,l);
	}

	public void createObject(String s, SecurityLevel l) {
		s = s.toLowerCase();
		objectLevels.put(s,l);
	}

	class ObjectManager {
		
		public ObjectManager() {

		}
	}

}