# Amazon_Technical_Test-2013

Amazon Technical Test
We would like you to write a commandline application that takes two arguments.
* The first argument is an input file.
* The second argument is a depth.

Input File Structure:

The input file is a CSV with a header at line 0 representing a serialized acyclic tree. The nodes are in no particular order but the root node can be identified as having a PARENT_NAME of NULL. A sample test.csv has been provided.
Your program will consume this file and return a sorted list of the NAME's at the depth in the tree specific on the command line.

Example

./myprogram test.csv 0

Farringdon


./myprogram test.csv 2

Aldgate

Baker Street

Chiswick Park

Victoria



Note: You may use any programming language you like and any feature of that core language. Optional libraries should not be used.
