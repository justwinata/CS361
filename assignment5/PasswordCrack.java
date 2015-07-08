import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class PasswordCrack {

	private static File dictionary;
	private static File toCrack;
	private static Scanner sc;
	private static Scanner dictsc;


	public static void main (String[] args) {
		try {
			dictionary = new File(args[0]);
			toCrack = new File(args[1]);
			sc = new Scanner (toCrack);
			dictsc = new Scanner(dictionary);
			while (sc.hasNextLine()) {
				boolean match = false;
				String in = sc.nextLine();
				String crypt = in.substring(in.indexOf(":") + 1, in.indexOf(":") + 14);
				String salt = crypt.substring(0,2);
				String[] temp = in.split(" ");
				String fn = temp[0].substring(temp[0].lastIndexOf(":") + 1).toLowerCase();
				match = check(fn, salt, crypt);
				if (match) {
					System.out.println(fn);
				}
				else {
					String ln = temp[1].substring(0,temp[1].indexOf(":")).toLowerCase();
					match = check(ln, salt, crypt);
					System.out.println(match);
					if (match) {
						System.out.println(ln);
					}
					else {
						ArrayList<String> lnattempts = mangle(ln);
						for (int i = 0; i < lnattempts.size() && !match; i++) {
							match = check(lnattempts.get(i), salt, crypt);	
							if (match) {
								System.out.println(lnattempts.get(i));
							}
						}
						
					}
				}
				//ArrayList<String> lnattempts = mangle(ln);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static ArrayList<String> mangle (String in) {
		ArrayList<String> attempts =  new ArrayList<String>();
		String test = in.toLowerCase();
		attempts.addAll(prepend(test));
		attempts.addAll(append(test));
		attempts.add(deleteFirst(test));
		attempts.add(deleteLast(test));
		attempts.add(reverse(test));
		attempts.add(duplicate(test));
		attempts.add(reflectfb(test));
		attempts.add(reflectbf(test));
		attempts.add(uppercase(test));
		attempts.add(lowercase(test));
		attempts.add(capitalize(test));
		attempts.add(ncapitalize(test));
		attempts.add(toggleCase1(test));	
		attempts.add(toggleCase2(test));	
		return attempts;
	}

	private static void mangledict (String in) {
		while (dictsc.hasNextLine()) {
			ArrayList<String> dictattempt = mangle(dictsc.nextLine());
		}
	}



	private static boolean check (String in, String salt, String crypt) {
		String check = jcrypt.crypt(salt, in);
		System.out.println("post: " +check);
		System.out.println("pw: " +crypt);
		if (check.equals(crypt)) {
			return true;
		}
		return false;
	}

	private static ArrayList<String> prepend (String in) {
		ArrayList<String> outarray =  new ArrayList<String>();
		for (char c = 32; c < 127; c++) {
			StringBuilder out = new StringBuilder();
			out.append(Character.toString(c) + in);
			outarray.add(out.toString());
		}
		return outarray;
	}

	private static ArrayList<String> append (String in) {
		ArrayList<String> outarray =  new ArrayList<String>();
		for (char c = 32; c < 127; c++) {
			StringBuilder out = new StringBuilder();
			out.append(in + Character.toString(c));
			outarray.add(out.toString());
		}
		return outarray;
	}

	private static String deleteFirst (String in) {
		return in.substring(1);
	}

	private static String deleteLast (String in) {
		return in.substring(0, in.length());
	}

	private static String reverse (String in) {
		return new StringBuilder(in).reverse().toString();
	}

	private static String duplicate (String in) {
		return in + in;
	}
	
	private static String reflectfb (String in) {
		String out = reverse(in);
		return in + out;
	}

	private static String reflectbf (String in) {
		String out = reverse(in);
		return out + in;
	}
	
	private static String uppercase (String in) {
		return in.toUpperCase();
	}
	
	private static String lowercase (String in) {
		return in.toLowerCase();
	}
		
	private static String capitalize (String in) {
		StringBuilder out = new StringBuilder();
		out.append(Character.toString(in.charAt(0)).toUpperCase() + in.substring(1));
		return out.toString();
	}

	private static String ncapitalize (String in) {
		StringBuilder out = new StringBuilder();
		out.append(Character.toString(in.charAt(0)) + in.substring(1).toUpperCase());
		return out.toString();
	}
	
	private static String toggleCase1 (String in) {
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < in.length(); i++) {
			if (i % 2 == 0) {
				out.append(in.charAt(i));
			}
			else {
				out.append(Character.toUpperCase(in.charAt(i)));
			}
		}
		return out.toString();
	}

	private static String toggleCase2 (String in) {
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < in.length(); i++) {
			if (i % 2 != 0) {
				out.append(in.charAt(i));
			}
			else {
				out.append(Character.toUpperCase(in.charAt(i)));
			}
		}
		return out.toString();
	}
}