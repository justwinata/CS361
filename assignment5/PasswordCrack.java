import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class PasswordCrack {

	private static File dictionary;
	private static File toCrack;
	private static Scanner sc;
	private static Scanner dictsc;
	private static ArrayList<String> attempts = new ArrayList<String>();

	public static void main (String[] args) {
		try {
			dictionary = new File(args[0]);
			toCrack = new File(args[1]);
			sc = new Scanner (toCrack);
			while (sc.hasNextLine()) {
				boolean match = false;
				String in = sc.nextLine();
				String crypt = in.substring(in.indexOf(":") + 1, in.indexOf(":") + 14);
				String salt = crypt.substring(0,2);
				String[] temp = in.split(" ");

				String fn = temp[0].substring(temp[0].lastIndexOf(":") + 1).toLowerCase();
				String ln = temp[1].substring(0,temp[1].indexOf(":")).toLowerCase();

				//check first name
				match = check(fn, salt, crypt);
				if (match) {
					System.out.println(fn);
				}
				if (!match) {
					//check last name
					match = check(ln, salt, crypt);
					if (match) {
						System.out.println(ln);
					}
				}
				if (!match) {

					//check last name mangles
					mangle(ln);
					match = checkmangles(salt, crypt,match);
				}

				//last name 2 round mangles
				if (!match) {
					mangle2();
					match = checkmangles(salt, crypt, match);
				}
				if (!match) {
					mangle(ln);
					mangle3();
					match = checkmangles(salt, crypt, match);
				}
				if (!match) {
					mangle(ln);
					mangle4();
					match = checkmangles(salt, crypt, match);
				}
				if (!match) {
					mangle(ln);
					mangle5();
					match = checkmangles(salt, crypt, match);
				}
				if (!match) {
					mangle(ln);
					mangle6();
					match = checkmangles(salt, crypt, match);
				}
				if (!match) {
					mangle(ln);
					mangle7();
					match = checkmangles(salt, crypt, match);
				}
				if (!match) {
					mangle(ln);
					mangle8();
					match = checkmangles(salt, crypt, match);
				}
				if (!match) {
					mangle(ln);
					mangle9();
					match = checkmangles(salt, crypt, match);
				}
				if (!match) {
					mangle(ln);
					mangle10();
					match = checkmangles(salt, crypt, match);
				}
				if (!match) {
					mangle(ln);
					mangle11();
					match = checkmangles(salt, crypt, match);
				}
				if (!match) {
					mangle(ln);
					mangle12();
					match = checkmangles(salt, crypt, match);
				}
				if (!match) {
					mangle(ln);
					mangle13();
					match = checkmangles(salt, crypt, match);
				}


				//check first name mangles
				if (!match) {
					mangle(fn);
					match = checkmangles(salt, crypt, match);	
				}
				if (!match) {
					mangle2();
					match = checkmangles(salt, crypt, match);
				}
				if (!match) {
					mangle(fn);
					mangle3();
					match = checkmangles(salt, crypt, match);
				}
				if (!match) {
					mangle(fn);
					mangle4();
					match = checkmangles(salt, crypt, match);
				}
				if (!match) {
					mangle(fn);
					mangle5();
					match = checkmangles(salt, crypt, match);
				}
				if (!match) {
					mangle(fn);
					mangle6();
					match = checkmangles(salt, crypt, match);
				}
				if (!match) {
					mangle(fn);
					mangle7();
					match = checkmangles(salt, crypt, match);
				}
				if (!match) {
					mangle(fn);
					mangle8();
					match = checkmangles(salt, crypt, match);
				}
				if (!match) {
					mangle(fn);
					mangle9();
					match = checkmangles(salt, crypt, match);
				}
				if (!match) {
					mangle(fn);
					mangle10();
					match = checkmangles(salt, crypt, match);
				}
				if (!match) {
					mangle(fn);
					mangle11();
					match = checkmangles(salt, crypt, match);
				}
				if (!match) {
					mangle(fn);
					mangle12();
					match = checkmangles(salt, crypt, match);
				}
				if (!match) {
					mangle(fn);
					mangle13();
					match = checkmangles(salt, crypt, match);
				}

					
				if (!match) {
					//dictionary mangles
                	dictsc = new Scanner(dictionary);
					while (dictsc.hasNextLine() && !match) {
						String dl = dictsc.nextLine();
						mangle(dl);
						match = checkmangles(salt, crypt, match);
						if (!match) {
							mangle2();
							match = checkmangles(salt, crypt, match);
						}
						if (!match) {
							mangle(dl);
							mangle3();
							match = checkmangles(salt, crypt, match);
						}
						if (!match) {
							mangle(dl);
							mangle4();
							match = checkmangles(salt, crypt, match);
						}
						if (!match) {
							mangle(dl);
							mangle5();
							match = checkmangles(salt, crypt, match);
						}
						if (!match) {
							mangle(dl);
							mangle6();
							match = checkmangles(salt, crypt, match);
						}
						if (!match) {
							mangle(dl);
							mangle7();
							match = checkmangles(salt, crypt, match);
						}
						if (!match) {
							mangle(dl);
							mangle8();
							match = checkmangles(salt, crypt, match);
						}
						if (!match) {
							mangle(dl);
							mangle9();
							match = checkmangles(salt, crypt, match);
						}
						if (!match) {
							mangle(dl);
							mangle10();
							match = checkmangles(salt, crypt, match);
						}
						if (!match) {
							mangle(dl);
							mangle11();
							match = checkmangles(salt, crypt, match);
						}
						if (!match) {
							mangle(dl);
							mangle12();
							match = checkmangles(salt, crypt, match);
						}
						if (!match) {
							mangle(dl);
							mangle13();
							match = checkmangles(salt, crypt, match);
						}

					}
				}
				/*if (!match) {
					attempts.clear();
					mangle(fn);
					mangle14();
					match = checkmangles(salt, crypt, match);
				}				
				if (!match) {
					attempts.clear();
					mangle(fn);
					mangle15();
					match = checkmangles(salt, crypt, match);
				}
				if (!match) {
					attempts.clear();
					mangle(ln);
					mangle14();
					match = checkmangles(salt, crypt, match);
				}
				if (!match) {
					attempts.clear();
					mangle(ln);
					mangle15();
					match = checkmangles(salt, crypt, match);
				}
				if (!match) {
					//dictionary mangles
                	dictsc = new Scanner(dictionary);
					while (dictsc.hasNextLine() && !match) {
						String dl = dictsc.nextLine();
						if (!match) {
							attempts.clear();
							mangle(dl);
							mangle14();
							match = checkmangles(salt, crypt, match);
						}
						if (!match) {
							attempts.clear();
							mangle(dl);
							mangle15();
							match = checkmangles(salt, crypt, match);
						}
					}
				}*/
				if (!match) {
					System.out.println("Failed for: " + fn);
					attempts.clear();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void mangle (String in) {	
		attempts.clear();
		attempts.add(in);
		String test = in.toLowerCase();
		attempts.add(test);
		attempts.add(uppercase(test));
		attempts.addAll(prepend(test));
		attempts.addAll(append(test));
		attempts.add(deleteFirst(test));
		attempts.add(deleteLast(test));
		attempts.add(reverse(test));
		attempts.add(duplicate(test));
		attempts.add(reflectfb(test));
		attempts.add(reflectbf(test));
		attempts.add(capitalize(test));
		attempts.add(ncapitalize(test));
		attempts.add(toggleCase1(test));	
		attempts.add(toggleCase2(test));	
		//return attempts;
	}

	private static void mangle2 () {
		for (int i = 0; i < attempts.size(); i++){
			attempts.set(i,deleteFirst(attempts.get(i)));
		}
	}

	private static void mangle3 () {
		for (int i = 0; i < attempts.size(); i++){
			attempts.set(i,deleteLast(attempts.get(i)));
		}
	}

	private static void mangle4 () {
		for (int i = 0; i < attempts.size(); i++){
			attempts.set(i,reverse(attempts.get(i)));
		}
	}

	private static void mangle5 () {
		for (int i = 0; i < attempts.size(); i++){
			attempts.set(i,duplicate(attempts.get(i)));
		}
	}

	private static void mangle6 () {
		for (int i = 0; i < attempts.size(); i++){
			attempts.set(i,reflectfb(attempts.get(i)));
		}
	}

	private static void mangle7 () {
		for (int i = 0; i < attempts.size(); i++){
			attempts.set(i,reflectbf(attempts.get(i)));
		}
	}

	private static void mangle8 () {
		for (int i = 0; i < attempts.size(); i++){
			attempts.set(i,capitalize(attempts.get(i)));
		}
	}

	private static void mangle9 () {
		for (int i = 0; i < attempts.size(); i++){
			attempts.set(i,ncapitalize(attempts.get(i)));
		}
	}

	private static void mangle10 () {
		for (int i = 0; i < attempts.size(); i++){
			attempts.set(i,toggleCase1(attempts.get(i)));
		}
	}


	private static void mangle11 () {
		for (int i = 0; i < attempts.size(); i++){
			attempts.set(i,toggleCase2(attempts.get(i)));
		}
	}

	private static void mangle12 () {
		for (int i = 0; i < attempts.size(); i++){
			attempts.set(i,uppercase(attempts.get(i)));
		}
	}

	private static void mangle13 () {
		for (int i = 0; i < attempts.size(); i++){
			attempts.set(i,lowercase(attempts.get(i)));
		}
	}

	private static void mangle14() {
		for (int i = 0; i < attempts.size(); i++) {
			attempts.addAll(append(attempts.get(i)));
		}
	}

	private static void mangle15() {
		for (int i = 0; i < attempts.size(); i++) {
			attempts.addAll(prepend(attempts.get(i)));
		}
	}

	private static boolean check (String in, String salt, String crypt) {
		String check = jcrypt.crypt(salt, in);
		if (check.equals(crypt)) {
			return true;
		}
		return false;
	}

	private static boolean checkmangles (String salt, String crypt, boolean match) {
		for (int i = 0; i < attempts.size() && !match; i++) {
			match = check(attempts.get(i), salt, crypt);	
			if (match) {
				System.out.println(attempts.get(i));
				attempts.clear();
			}
		}
		return match;
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
		return in.substring(0, in.length() - 1);
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
