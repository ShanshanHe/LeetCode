/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.
*/

/*
build a hashmap contains the characters in s associated with the number of times it appear in s.
if t is a valid anagram, then t should have the same characters with the same number of times.
*/

public class Solution {
    public boolean isAnagram(String s, String t) {
        if( s.length() != t.length() ) return false;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) map.put(ch,map.get(ch)+1);
            else map.put(ch,1);
        }
        
        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if(!map.containsKey(ch)) return false;
            map.put(ch, map.get(ch)-1);
        }
        
        for(Integer value : map.values()) {
            if( value != 0 ) return false;
        }
        return true;
    }
}
