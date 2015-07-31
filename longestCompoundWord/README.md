This is a solution for the programming problem - find longest word made of other words

Problem Descritption: given a file containing a sorted list of words (one word per line, no spaces, all lower case), output the longest word in the file that can be constructed by other words in the file; output the total number of compound words.

Here I use trie as the data structure.
Build the trie: while scanning the input file, for each word, insert it into the trie, check if it has any prefixes, if it does, then it might be a compound word and a pair of the origin word and it's prefix's corresponding suffix is pushed into a queue.
Search the trie: after building the trie and queue, we start processing the compound word candidates in the queue. For every pair of <origin word, suffix>, we check if suffix is a word, if yes, then it's a compound word, if not, check if it has any prefix, if yes, then push the pair of origin word and suffix's suffix into the queue, if not discard the pair and move on to next pair in the queue.

The program takes one parameter (path of the input file) and outputs the two longest words at console, it will also write all the compound words found to file "compoundWord.txt" in decreasing order in terms of word length. If the compound words have the same length, it will write it in alphabetical order. To run it, use command below:

g++ -ggdb -Wall -I. -o longestCompoundWord main.cpp
./longestCompoundWord inputfilepath
