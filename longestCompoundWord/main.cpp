//
//  main.cpp
//  longestCompoundWord
//
//  Created by Shanshan He on 7/30/15.
//  Copyright (c) 2015 Shanshan He. All rights reserved.
//

/*
 Result for wordsforproblem.txt:
 Read File and Build Trie Done! Time: 1.63934 seconds
 Search For Compound Words Done! Time: 0.868731 seconds
 The 1 Longest Compound Word:ethylenediaminetetraacetates
 The 2 Longest Compound Word:electroencephalographically
 Number of Total Compound Words: 97107
 */

#include <iostream>
#include <fstream>
#include <set>
#include <time.h>
#include "trie.h"

// cuntomized comparison funtion for ordered set
struct cmpStruct {
    bool operator() (string const & lhs, string const & rhs) const
    {
        if(lhs.size() == rhs.size()) return lhs < rhs;
        else return lhs.size() > rhs.size();
    }
};

static void show_usage()
{
    std::cerr << "Usage: filepath \n"
    << "example: wordsforproblem.txt"
    << std::endl;
}


int main(int argc, const char * argv[]) {
    
    if(argc<2){
        show_usage();
        cerr << "not enought parameters!" << endl;
        exit(1);
    }
    
    clock_t curr_time;
    curr_time = clock();
    
    // read from file
    Trie* trie = new Trie();
    cout << "Read from File" << endl;
    string path = argv[1];
    ifstream iFile(path);
    if(!iFile) {
        cerr << "unable to open file" << endl;
        exit(1);
    }
    string line;
    while (getline(iFile, line)) {
        if (!line.empty() && line[line.size() - 1] == '\r')
            line.erase(line.size() - 1);
        trie->addWord(line);
    }
    
    curr_time = clock() - curr_time;
    cout << "Read File and Build Trie Done! Time: " << ((float)curr_time)/CLOCKS_PER_SEC << " seconds" << endl;
    
    // sortedSet stores all the compound words in decresing order in terms of string length
    set<string, cmpStruct> sortedSet;
    while(!trie->suffix_queue.empty()) {
        StringPair sp = trie->suffix_queue.front();
        trie->suffix_queue.pop();
        if(trie->searchWord(sp.first, sp.second)) {
            sortedSet.insert(sp.first);
        }
    }
    curr_time = clock() - curr_time;
    cout << "Search For Compound Words Done! Time: " << ((float)curr_time)/CLOCKS_PER_SEC << " seconds" << endl;
    
    std::set<string>::iterator it;
    int i = 0;
    for (it = sortedSet.begin(); i < 2 && it != sortedSet.end(); ++it, ++i)
        cout << "The " << i+1 << " Longest Compound Word:" << *it << endl;
    cout << "Number of Total Compound Words: " << sortedSet.size() << endl;
    
    //write all compound words to file
    std::ofstream out("compoundWords.txt");
    for (it = sortedSet.begin(); it != sortedSet.end(); ++it) {
        out << *it << endl;
    }
    out.close();
    
    delete trie;
    return 0;
}
