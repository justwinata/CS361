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
		if (inObj.getType().toLowerCase().equals("read")) {
			String s = inObj.getSubject();
			int v = objectValues.get(inObj.getObject());
			if (one.dominates(two)) {
				subjectValues.put(s,v);
			} else {
				subjectValues.put(s,0);
			}
			printExecute(inObj);
		} else if (inObj.getType().toLowerCase().equals("write")) {
			String s = inObj.getObject();
			int v = inObj.getValue();
			if (!one.dominates(two)|| one.equals(two)) {
				objectValues.put(s,v);
			}
			printExecute(inObj);
		} else if (inObj.getType().toLowerCase().equals("destroy")) {
			/*String s = inObj.getObject();
			int v = inObj.getValue();
			if (!one.dominates(two)|| one.equals(two)) {
				objectValues.put(s,v);
			}*/
			printExecute(inObj);
		} else if (inObj.getType().toLowerCase().equals("create")) {
			String s = inObj.getObject();
			if (! (subjectValues.containsKey(s) || objectValues.containsKey(s) ) ) {
				createObject(s, one)
			}
			printExecute(inObj);
		} else if (inObj.getType().toLowerCase().equals("run")) {
			/*String s = inObj.getObject();
			int v = inObj.getValue();
			if (!one.dominates(two)|| one.equals(two)) {
				objectValues.put(s,v);
			}*/
			printExecute(inObj);
		} else {
			printExecute(inObj);
		}
			
	}

	public void printExecute (InstructionObject io) {
		
		if (io.getType().toLowerCase().equals("read")) {
			System.out.println("READ " + io.getSubject().toUpperCase() + " " + io.getObject().toUpperCase());
		}
		else if (io.getType().toLowerCase().equals("create")) {
			System.out.println("CREATE " + io.getSubject().toUpperCase() + " " + io.getObject().toUpperCase());
		}
		else if (io.getType().toLowerCase().equals("destroy")) {
			System.out.println("DESTROY " + io.getSubject().toUpperCase() + " " + io.getObject().toUpperCase());
		}
		else if (io.getType().toLowerCase().equals("write")) {
			System.out.println("WRITE " + io.getSubject().toUpperCase() + " " + io.getObject().toUpperCase() + " " + io.getValue() );
		}
		else if (io.getType().toLowerCase().equals("run")) {
			System.out.println("RUN " + io.getSubject().toUpperCase());
		}
		else  { 
			System.out.println("Bad Instruction");
		}
		printState();
	}

	public void createSubject(String s, SecurityLevel l) {
		subjectLevels.put(s,l);
		subjectValues.put(s, 0);
	}

	public void createObject(String s, SecurityLevel l) {
		objectLevels.put(s,l);
		objectValues.put(s,0);
	}

	class ObjectManager {
		
		public ObjectManager() {

		}
	}

}