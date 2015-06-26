UTEID: ee4826; jw34846; 
FIRSTNAME: Efosa; Justin; 
LASTNAME: Elaiho; Winata;
CSACCOUNT: elaiho; justwin;
EMAIL: elaiho@cs.utexas.edu; justwin@cs.utexas.edu; 

[Program 3]
[Description]
There are 2 java files:
In Encoder.java, we read a file of frequencies, build a string based on the frequencies read,
pass that string into Huffman.java, and calculate the optimal entropy.
From there, we generate a file filled with random characters based on the frequencies,
and then encode and decode it using both one-letter and two-letter encoding/decoding
and calculate and compare their entropies with the optimal one.
As for Huffman.java,
We used the Huffman algorithm implemented at:
	http://rosettacode.org/wiki/Huffman_coding#Java
We altered it slightly, extracting the main method and turning it into its own "execute" method.
This was so that we could pass the String we built in Encoder.java into the main method of Huffman.java.
We also altered the print method in the Huffman algorithm so that we could corresponding
 characters and their encodings would be stored in some HashMaps.
This was to accomodate the way we implemented the encoding and decoding functions.
The execute and print functions were also replicated and adjusted to accomodate for 1-symbol encoding 
vs. 2-symbol.
We also added a couple of counters to count the number of total bits that were being used in each encoding.
To compile our program, use command:
	javac *.java
To run our program, use command:
	java Encoder frequenciesFile k
where frequenciesFile is the name of a file containing integers representing the relative frequencies of characters in the alphabet and k is a positive integer that tells how many characters to generate, encode, and decode in the testText* files.


[Progress]
We finished the assignment.

[Test Cases]
[Input of test 1]
[command line]java Encoder frequenciesFile 4

please copy your input file(frequenciesFile) here
4
2
3
1

[Output of test 1]
please copy your output here.
   
   [Input of test 2]
   [command line]

   [Output of test 2]

   [Input of test 3]
   [command line]

   [Output of test 3]

   [Input of test 4]
   [command line]

   [Output of test 4]

