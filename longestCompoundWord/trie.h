//
//  trie.h
//  longestCompoundWord
//
//  Created by Shanshan He on 7/30/15.
//  Copyright (c) 2015 Shanshan He. All rights reserved.
//
#ifndef longestCompoundWord_trie_h
#define longestCompoundWord_trie_h

#include<vector>
#include<queue>
using namespace std;

// band the original string and it's suffix together
typedef pair<string, string> StringPair;

class Node {
public:
    Node();
    Node(char ch) : _letter(ch), _isWord(false){
        for(int i = 0; i < 26; ++i)
            _children.push_back(nullptr);
    }
    ~Node(){}
    void setLetter(char c) {_letter = c;}
    void setIsWord() {_isWord = true;}
    char getLetter() {return _letter;}
    bool getIsWord() {return _isWord;}
    vector<Node*>& getChildren() {return _children;}
private:
    char _letter;
    bool _isWord;
    vector<Node*> _children;
};

Node::Node(){
    _letter = ' ';
    _isWord = false;
    for(int i = 0; i < 26; ++i)
        _children.push_back(nullptr);
}

class Trie {
public:
    queue<StringPair> suffix_queue;
    Trie();
    ~Trie();
    void addWord(string w);
    bool searchWord(string origin, string suffix);
    bool isWord(string w);
private:
    Node* root;
    void destroy(Node* node);
};

Trie::Trie(){
    root = new Node();
}

Trie::~Trie(){
    destroy(root);
}

void Trie::destroy(Node* node){
    vector<Node*>::iterator it = (node->getChildren()).begin();
    for(; it != (node->getChildren()).end(); ++it) {
        if(*it != nullptr) destroy((Node*)(*it));
    }
    delete node;
}

/*
 * Add given word to the trie
 * During adding, if the word contains any prefix
 * Then a pair of the origin word and it's corresponding suffix are pushed into a queue
 */
void Trie::addWord(string str) {
    Node* r = root;
    for(std::string::size_type i = 0; i < str.size(); ++i) {
        char c = str[i];
        int index = c - 'a';
        vector<Node*>& vec = r->getChildren();
        if(vec.at(index) != nullptr) {
            if(vec.at(index)->getIsWord() && i < str.size()-1){
                string suffix = str.substr(i+1);
                suffix_queue.push(make_pair(str, suffix));
            }
            r = vec.at(index);
        }
        else {
            Node* tmp = new Node(c);
            vec.at(index) = tmp;
            r = tmp;
        }
    }
    r->setIsWord();
}

/*
 * Search the trie to see if given string str is a word
 * Return true if it is, false if not
 * at the same time, if the given string str contains any prefix
 * Then a pair of the origin word and str's suffix are pushed into a queue
 */
bool Trie::searchWord(string origin, string str) {
    Node* r = root;
    vector<string> tmp;
    for(std::string::size_type i = 0; i < str.size(); ++i) {
        char c = str[i];
        int index = c - 'a';
        vector<Node*>& vec = r->getChildren();
        if(vec.at(index) == nullptr)
            return false;
        else{
            if(vec.at(index)->getIsWord() && i < str.size()-1){
                string sub_suffix = str.substr(i+1);
                suffix_queue.push(make_pair(origin, sub_suffix));            }
            r = vec.at(index);
        }
    }
    if(r->getIsWord())
        return true;
    else return false;
}

/*
 * Recursively search the trie to see if given string suffix is a word
 * Return true if it is, false if not
 */
bool Trie::isWord(string suffix){
    Node* r = root;
    for(std::string::size_type i = 0; i < suffix.size(); ++i) {
        char c = suffix[i];
        int index = c - 'a';
        vector<Node*>& vec = r->getChildren();
        if(vec.at(index) == nullptr)
            return false;
        else{
            if(vec.at(index)->getIsWord() && i < suffix.size()-1 && isWord(suffix.substr(i+1))) return true;
            r = vec.at(index);
        }
    }
    if(r->getIsWord())
        return true;
    else return false;
}

#endif
