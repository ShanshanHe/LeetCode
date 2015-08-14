/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code"
*/

/*
Dynamic Programming
*/

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] t = new boolean[s.length()+1];
        t[0] = true;
        
        for(int i = 0; i < s.length(); ++i) {
            if(t[i] == false) continue;
            for(String str : wordDict) {
                if(i+str.length() <= s.length() && str.equals(s.substring(i, i+str.length())))
                    t[i+str.length()] = true;
            }
        }
        return t[s.length()];
    }
}
