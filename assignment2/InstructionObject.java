public class InstructionObject {
	
		private String instruction;
		private String subj;
		private String obj;
		private int val;


		public InstructionObject(String type, String subjname, String objname, int value) {
			instruction = type;
			subj = subjname;
			obj = objname;
			val = value;

		}

		public InstructionObject(String type, String subjname) {
			instruction = type;
			subj = subjname;
		}

		public InstructionObject(String type) {
			instruction = type;
		}

		public InstructionObject(String type, String subjname, String objname) {
			instruction = type;
			subj = subjname;
			obj = objname;
		}

		public String getType() {
			return instruction;
		}

		public String getSubject() {
			return subj;
		}

		public String getObject() {
			return obj;
		}

		public int getValue() {
			return val;
		}

}
