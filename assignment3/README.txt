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
[command line]java Encoder frequenciesFile 2

please copy your input file(frequenciesFile) here

3
4
5
2
1
2
3
4


[Output of test 1]
omputed Optimal Entropy: 2.8716535224393334
SYMBOL  FREQ    HUFFMAN CODE
C       5       00
F       2       010
E       1       0110
D       2       0111
A       3       100
G       3       101
H       4       110
B       4       111
Average bits per symbol (1-symbol encoding): 3.125
Percentage difference from optimal entropy: 8.822320505624948%
SYMBOL  FREQ    HUFFMAN CODE
CC      25      0000
DA      6       000100
AF      6       000101
CA      15      00011
CG      15      00100
GC      15      00101
AC      15      00110
BH      16      00111
HD      8       010000
HF      8       010001
HH      16      01001
BE      4       0101000
HE      4       0101001
DH      8       010101
ED      2       01011000
EF      2       01011001
EB      4       0101101
FB      8       010111
EH      4       0110000
FD      4       0110001
BF      8       011001
HB      16      01101
DB      8       011100
FF      4       0111010
DD      4       0111011
BD      8       011110
FH      8       011111
BB      16      10000
AA      9       100010
DF      4       1000110
CE      5       1000111
GG      9       100100
GA      9       100101
AG      9       100110
DC      10      100111
CD      10      101000
CF      10      101001
BC      20      10101
EC      5       1011000
FE      2       10110010
EA      3       10110011
FC      10      101101
CH      20      10111
CB      20      11000
HC      20      11001
GB      12      110100
GD      6       1101010
GF      6       1101011
DG      6       1101100
FG      6       1101101
GH      12      110111
HA      12      111000
GE      3       11100100
EE      1       111001010
DE      2       111001011
EG      3       11100110
AE      3       11100111
BA      12      111010
HG      12      111011
BG      12      111100
AD      6       1111010
FA      6       1111011
AB      12      111110
AH      12      111111
Calculated optimal entropy: 3.860073065154531
Average bits per symbol (2-symbol encoding): 3.171875
Percentage difference from optimal entropy: -17.828627944040754%

   
[Input of test 2]
[command line] java Encoder frequenciesFile2 2

please copy your input file(frequenciesFile) here

5
4
3
2
1
7

[Output of test 2]

Computed Optimal Entropy: 2.36779468995532
SYMBOL  FREQ    HUFFMAN CODE
B       4       00
A       5       01
C       3       100
E       1       1010
D       2       1011
F       7       11
Average bits per symbol (1-symbol encoding): 2.8333333333333335
Percentage difference from optimal entropy: 19.66127575811052%
SYMBOL  FREQ    HUFFMAN CODE
AD      10      00000
BC      12      00001
CB      12      00010
EE      1       00011000
DE      2       00011001
EC      3       0001101
CD      6       000111
FF      49      001
AA      25      0100
DC      6       010100
FE      7       010101
FD      14      01011
FB      28      0110
BF      28      0111
DF      14      10000
CA      15      10001
AC      15      10010
EF      7       100110
BE      4       1001110
DD      4       1001111
BB      16      10100
BD      8       101010
DB      8       101011
FA      35      1011
AF      35      1100
CC      9       110100
EB      4       1101010
AE      5       1101011
BA      20      11011
AB      20      11100
DA      10      111010
ED      2       11101100
CE      3       11101101
EA      5       1110111
FC      21      11110
CF      21      11111
Calculated optimal entropy: 0.22933297533978614
Average bits per symbol (2-symbol encoding): 2.8472222222222223
Percentage difference from optimal entropy: 1141.523255870072%


[Input of test 3]
[command line] java Encoder frequenciesFile3 2

please copy your input file(frequenciesFile) here

3
4
2
4
3
2

[Output of test 3]

Computed Optimal Entropy: 2.5304930567574826
SYMBOL  FREQ    HUFFMAN CODE
D       4       00
B       4       01
C       2       100
F       2       101
E       3       110
A       3       111
Average bits per symbol (1-symbol encoding): 2.6666666666666665
Percentage difference from optimal entropy: 5.381307391677792%
SYMBOL  FREQ    HUFFMAN CODE
DD      16      0000
BB      16      0001
BD      16      0010
CD      8       00110
FB      8       00111
DB      16      0100
BF      8       01010
CB      8       01011
FC      4       011000
FF      4       011001
CC      4       011010
CF      4       011011
AE      9       01110
EE      9       01111
AA      9       10000
EA      9       10001
DA      12      10010
AB      12      10011
DE      12      10100
EC      6       101010
AF      6       101011
EF      6       101100
FA      6       101101
AD      12      10111
ED      12      11000
BA      12      11001
EB      12      11010
AC      6       110110
CA      6       110111
BE      12      11100
CE      6       111010
FE      6       111011
DC      8       111100
DF      8       111101
FD      8       111110
BC      8       111111
Calculated optimal entropy: 2.836591668108979
Average bits per symbol (2-symbol encoding): 2.6666666666666665
Percentage difference from optimal entropy: -5.99046395548336%


[Input of test 4]
[command line] java Encoder frequenciesFile4 2

please copy your input file(frequenciesFile) here

2
3
2
4
3
2
2

[Output of test 4]

Computed Optimal Entropy: 2.7527152789797045
SYMBOL  FREQ    HUFFMAN CODE
D       4       00
F       2       010
C       2       011
A       2       100
G       2       101
E       3       110
B       3       111
Average bits per symbol (1-symbol encoding): 2.857142857142857
Percentage difference from optimal entropy: 3.793620755498517%
SYMBOL  FREQ    HUFFMAN CODE
DA      8       00000
CF      4       000010
CG      4       000011
DF      8       00010
DG      8       00011
FF      4       001000
FG      4       001001
FD      8       00101
DD      16      0011
GA      4       010000
GC      4       010001
GD      8       01001
DC      8       01010
GF      4       010110
GG      4       010111
AG      4       011000
CA      4       011001
AD      8       01101
EE      9       01110
BE      9       01111
BB      9       10000
EB      9       10001
DB      12      10010
DE      12      10011
BC      6       101000
AE      6       101001
EF      6       101010
EG      6       101011
BA      6       101100
CB      6       101101
AB      6       101110
FE      6       101111
GB      6       110000
GE      6       110001
EA      6       110010
EC      6       110011
ED      12      11010
CE      6       110110
FB      6       110111
BF      6       111000
BG      6       111001
BD      12      11101
FA      4       1111000
FC      4       1111001
AC      4       1111010
AF      4       1111011
AA      4       1111100
CC      4       1111101
CD      8       111111
Calculated optimal entropy: 3.5054305579594103
Average bits per symbol (2-symbol encoding): 2.8877551020408165
Percentage difference from optimal entropy: -17.62053036583775%
