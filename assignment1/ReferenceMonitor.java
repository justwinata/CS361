

public class ReferenceMonitor {

	public ReferenceMonitor(InstructionObject io) {
		ObjectManager om = new ObjectManager();

	}





	class ObjectManager {

		public ObjectManager() {

		}
	}
	
}

public void printExecute (InstructionObject io) {
	if (io.getType().equals("bad")) {
		System.out.println("Bad Instruction");
	}
	else if (io.getType().equals("write")) {
		System.out.println(io.getSubject() + " writes value " + io.getValue())
	}
}

public void printState (InstructionObject io) {
	System.out.println("The current state is:");
	System.out.println("   " + ?.objname + "has value: " + ?.temp);
	System.out.println("   " + ?.objname + "has value: " + temp);
	System.out.println("   " + ?.subjname + "has recently read: " + ?.temp);
	System.out.println("   " + ?.subjname + "has recently read: " + ?.temp);
	System.out.println();
}