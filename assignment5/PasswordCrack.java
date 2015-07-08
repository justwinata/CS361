import java.io.File;

public class PasswordCrack {

	private static File dict;
	private static File toCrack;
	private static Scanner sc;

	pubic static void main (String[] args) {
		dict = new File(args[0]);
		toCrack = new File(args[1]);
		sc = new Scanner (toCrack);
	}
}