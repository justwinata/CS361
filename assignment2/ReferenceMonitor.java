import java.util.Scanner;
import java.util.HashMap;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class ReferenceMonitor {
	// object and subject have mapping for name and their values
	private HashMap<String,Integer> objectValues;
	private HashMap<String,Integer> subjectValues;
	// object and subject mapping for name and security levels
	private HashMap<String, SecurityLevel> objectLevels;
	private HashMap<String, SecurityLevel> subjectLevels;
	private InstructionObject inObj;
	private boolean verbose;
	private PrintWriter writer;

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
			if (verbose) {
				printExecute(inObj);
			}
		} else if (inObj.getType().toLowerCase().equals("write")) {
			String s = inObj.getObject();
			int v = inObj.getValue();
			if (!one.dominates(two)|| one.equals(two)) {
				objectValues.put(s,v);
			}
			if (verbose) {
				printExecute(inObj);
			}
		} else if (inObj.getType().toLowerCase().equals("destroy")) {
			String s = inObj.getObject();
			int v = inObj.getValue();
			if (objectValues.containsKey(s) && (!one.dominates(two)|| one.equals(two))) {
				objectValues.remove(s);
			}
			if (verbose) {
				printExecute(inObj);
			}
		} else if (inObj.getType().toLowerCase().equals("create")) {
			String s = inObj.getObject();
			if (! (objectValues.containsKey(s) ) ) {
				createObject(s, one);
			}
			if (verbose) {
				printExecute(inObj);
			}
		} else if (inObj.getType().toLowerCase().equals("run")) {
			/*String s = inObj.getObject();
			int v = inObj.getValue();
			if (!one.dominates(two)|| one.equals(two)) {
				objectValues.put(s,v);
			}*/
			if (verbose) {
				printExecute(inObj);
			}
		} else {
			if (verbose) {
				printExecute(inObj);
			}
		}
			
	}

	public void printExecute (InstructionObject io) {
		
		if (io.getType().toLowerCase().equals("read")) {
			writer.println("READ " + io.getSubject().toUpperCase() + " " + io.getObject().toUpperCase());
		}
		else if (io.getType().toLowerCase().equals("create")) {
			writer.println("CREATE " + io.getSubject().toUpperCase() + " " + io.getObject().toUpperCase());
		}
		else if (io.getType().toLowerCase().equals("destroy")) {
			writer.println("DESTROY " + io.getSubject().toUpperCase() + " " + io.getObject().toUpperCase());
		}
		else if (io.getType().toLowerCase().equals("write")) {
			writer.println("WRITE " + io.getSubject().toUpperCase() + " " + io.getObject().toUpperCase() + " " + io.getValue() );
		}
		else if (io.getType().toLowerCase().equals("run")) {
			writer.println("RUN " + io.getSubject().toUpperCase());
		}
		else  { 
			writer.println("Bad Instruction");
		}
	}

	public void createSubject(String s, SecurityLevel l) {
		subjectLevels.put(s,l);
		subjectValues.put(s, 0);
	}

	public void createObject(String s, SecurityLevel l) {
		objectLevels.put(s,l);
		objectValues.put(s,0);
	}

	public void setVerbose(boolean v, PrintWriter pw) {
		verbose = v;
		writer = pw;
	}

	class ObjectManager {
		
		public ObjectManager() {

		}
	}

}