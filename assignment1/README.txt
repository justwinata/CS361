UTEID: ee4826; jw34846; 
FIRSTNAME: Efosa; Justin; 
LASTNAME: Elaiho; Winata;
CSACCOUNT: elaiho; justwin;
EMAIL: elaiho@cs.utexas.edu; justwin@cs.utexas.edu; 

Program Description

The main function in the SecureSystem.java file first creates a SecureSystem object, and the creates 
security levels "low" and "high" to pass as security level parameters. The main fuction then creates 
subjects and objects through the Reference Monitor. Main function then reads a file passed into 
SecureSystem and collects each line of string input in the file. Each line of string ing input is 
parsed and become parameters for an Instruction Object  (type, subject, object value). The 
InstructionObject is then passed into the Reference Monitor in the method addInstruction(), in which 
reads the instruction types, objects, subjects, and values, thus updating values of objects and 
subjects. The addInstruction() method then runs printExecute() which prints the action that has 
occured due to the instruction. printExecute() then calls printState(), which prints the current 
states and values of all the subjects and objects. Main function then exits.

Status

Completion: 100%
Finished all requirements

Test Cases and Output
Four test cases are included: the one provided on the assignment details as well as three original 
ones. These cases are included as files "instructionList[n]" and their corresponding expected 
outputs are included as files "expected[n]".
