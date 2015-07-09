UTEID: ee4826; jw34846; 
FIRSTNAME: Efosa; Justin; 
LASTNAME: Elaiho; Winata;
CSACCOUNT: elaiho; justwin;
EMAIL: elaiho@cs.utexas.edu; justwin@cs.utexas.edu; 

[Program 5]
[Description]
There are 2 java files: 
The file jcrypt.java was given to us. This file gave us access to a function that allowed us to encrypt the given salt and a guessed password in order to compare the encrypted password with our encrypted guess.
The file PasswordCrack.java has a function for each type of mangle. For each line it parses from the input file of passwords, it parses out the salt, encrypted password, first name, and last name. It then checks whether the first name or last name of the user is the password, and then it checks mangles of those names, and if still not found, it checks against twice-mangled versions of the names. If the password is still not found, then it goes through the dictionary in the same way: checking against one line, checking against the mangles of that line, checking against twice-mangled versions of the line, and then proceeding to repeat for the next line if still not found. The conditions are set up so that immediately when the password is found in the whole search process, the program will print the found password and move on to the next line. If the password is not found, it will print that it failed for a user and give that user's first name.

To compile our program, you need to use:
	javac *.java"

To run our program, you need to use:
	java PasswordCrack inputFile1 inputFile2 
where inputFile1 is the dictionary and inputFile2 is a list of passwords to crack

[Finish]
We completed the requirements. We also mostly completed finding passwords that have been mangled twice, however not if their second round of mangling involved appending or prepending a character.

[Test Cases]

[Command line for test 1]
java PasswordCrack shortdict passwd1

[Input of test 1]
https://www.cs.utexas.edu/~byoung/cs361/passwd1

[Output of test 1]
michael
liagiba
amazing
eeffoc
squadro
icious
abort6
rdoctor
doorrood
keyskeys
Impact
sATCHEL
THIRTY
teserP
Failed for: nathan
enoggone
Failed for: rachel
Failed for: dustin
Salizar
Failed for: paige

______________________________


I can crack 16 cases. 
List of cracked: 
michael
liagiba
amazing
eeffoc
squadro
icious
abort6
rdoctor
doorrood
keyskeys
Impact
sATCHEL
THIRTY
teserP
enoggone
Salizar

I cannot crack 4 cases.
List of uncracked:
sHREWDq
obliqu3
litpeR
hI6d$pC2

[Command line for test 1]
java PasswordCrack shortdict passwd1

[Input of test 2]
https://www.cs.utexas.edu/~byoung/cs361/passwd2

[Output of test 2]
tremors
Saxon
cOnNeLlY
eltneg
Lacque
enchant$
soozzoos
dIAMETER
ElmerJ
INDIGNITY
^bribed
ellows
Failed for: victor
zoossooz
Failed for: nathan
nosral
Failed for: rachel
Swine3
Failed for: maia
Failed for: paige

______________________________


I can crack 15 cases.
List of cracked:
tremors
Saxon
cOnNeLlY
eltneg
Lacque
enchant$
soozzoos
dIAMETER
ElmerJ
INDIGNITY
^bribed
ellows
zoossooz
nosral
Swine3

I cannot crack 5 cases.
List of uncracked:
victor:w@FxBZv.d0y/U:512:512:Victor Esperanza:/home/victor:
nathan:nxr9OOqvZjbGs:514:514:Nathan Moore:/home/nathan:/bin/ksh
rachel:KenK1CTDGr/7k:516:516:Rachel Saxon:/home/rachel:/bin/bash
maria:!cSaQELm/EBV.:518:518:Maia Salizar:/home/maria:/bin/zsh
paige:T8U5jQaDVv/o2:519:519:Paige Reiser:/home/paige:/bin/bash
