

public class ReferenceMonitor {

	public ReferenceMonitor() {
		ObjectManager om = new ObjectManager();

	}

	class ObjectManager {

		public ObjectManager() {

		}
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


}