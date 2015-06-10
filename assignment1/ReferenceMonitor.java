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

	public ReferenceMonitor() {
		ObjectManager om = new ObjectManager();
		objectValues = new HashMap<String, Integer>();
	 	subjectValues = new HashMap<String, Integer>();
	 	objectLevels = new HashMap<String, SecurityLevel>();
	 	subjectLevels = new HashMap<String, SecurityLevel>();
	}

	
	public void addInstruction(InstructionObject io) {

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

	}

	public void createObject(String s, SecurityLevel l) {
		
	}

	class ObjectManager {

			public ObjectManager() {

			}
	}

}