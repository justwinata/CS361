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
		if (inObj.getType().equals("read")) {
			SecurityLevel one = subjectLevels.get(inObj.getSubject());
			SecurityLevel two = objectLevels.get(inObj.getObject());
			String s = inObj.getSubject();
			int v = objectValues.get(inObj.getObject());
			if (one.dominates(two)) {
				subjectValues.put(s,v);
			} else {
				subjectValues.put(s,0);
			}
			
		}
			
	}

	public void printExecute (InstructionObject io) {
		if (io.getType().equals("bad")) {
			System.out.println("Bad Instruction");
		}
		else if (io.getType().equals("write")) {
			System.out.println(io.getSubject() + " writes value " + io.getValue() + " to " + io.getObject());
		}
		else if(io.getType().equals("read")) {
			System.out.println(io.getSubject() + " reads " + io.getObject());
		}
	}

	/*
	public void printState (InstructionObject io) {
		System.out.println("The current state is:");
		System.out.println("   " + ?.objname + "has value: " + ?.temp);
		System.out.println("   " + ?.objname + "has value: " + temp);
		System.out.println("   " + ?.subjname + "has recently read: " + ?.temp);
		System.out.println("   " + ?.subjname + "has recently read: " + ?.temp);
		System.out.println();
	}
	*/
	
	public void createSubject(String s, SecurityLevel l) {
		subjectLevels.put(s,l);
	}

	public void createObject(String s, SecurityLevel l) {
		objectLevels.put(s,l);
	}

	class ObjectManager {
		
		public ObjectManager() {

		}
	}

}