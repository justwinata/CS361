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