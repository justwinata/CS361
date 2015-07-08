UTEID: ee4826; jw34846; 
FIRSTNAME: Efosa; Justin; 
LASTNAME: Elaiho; Winata;
CSACCOUNT: elaiho; justwin;
EMAIL: elaiho@cs.utexas.edu; justwin@cs.utexas.edu; 

[Program 4]
[Description]
There is 1 java file: 
In AES.java, we implemented addRoundKey, mixColumns (implementation provided by Dr. Young), shiftRows, subBytes, rotWord, keyExpansion, invMixColumns, invShiftRows, and invSubBytes. We also implemented an encryption function and a decryption function that takes the previously mentioned functions and orders/iterates through them as specified by the AES-256 encryption algorithm. We also had some print functions that were mostly for debugging and checking logic, but in the end, we slightly modified our function called printst that originally printed out the state as a matrix and had it print out in a single string in the same format as the input to a file.
To compile our program, you need to use:
	javac *.java
To run our program, you need to use:
	java AES option keyFile inputFile 
where keyFile is a key file, inputFile (no extension) names a file containing lines of plaintext, and option is "e" or "d" for encryption and decryption, respectively. keyFile contains a single line of 64 hex characters, which represents a 256-bit key. The inputFile should have 32 hex characters per line.
Our encrypt and decrypt times are essentially the same. We have a throughput of about .0032 MB/sec.

[Finish]
We finished the assignment.

[Test Cases]
[Command Lines for Test 1]
java AES e keyFile0 plaintext0
java AES d keyFile0 plaintext0.enc

[Input Files of Test 1]
keyFile0 plaintext0
keyFile0 plaintext0.enc

[Output of test 1]
plaintext0.enc
plaintext0.enc.dec

[Runtimes]
10 ms
10 ms


[Command Lines for Test 2]
java AES e keyFile plaintext1
java AES d keyFile plaintext1.enc

[Input Files of Test 2]
keyFile plaintext1
keyFile plaintext1.enc

[Output of test 2]
plaintext1.enc
plaintext1.enc.dec

[Runtimes]
8 ms
10 ms


[Command Lines for Test 3]
java AES e keyFileShort plaintext2
java AES d keyFileShort plaintext2.enc

[Input Files of Test 3]
keyFileShort plaintext2
keyFileShort plaintext2.enc

[Output of test 3]
plaintext2.enc
plaintext2.enc.dec

[Runtimes]
11 ms
9 ms


[Command Lines for Test 4]
java AES e keyFile1 plaintext3
java AES d keyFile1 plaintext3.enc

[Input Files of Test 4]
keyFile1 plaintext3
keyFile1 plaintext3.enc

[Output of test 4]
plaintext3.enc
plaintext3.enc.dec

[Runtimes]
26 ms
29 ms