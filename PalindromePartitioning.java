public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(s.length() == 0) return res;
        helper(s, 0, new ArrayList<String>(), res);
        return res;
    }
    
    void helper(String s, int pos, List<String> curr, List<List<String>> res) {
        if(pos >= s.length()) {
            res.add(new ArrayList<String>(curr));
            return;
        }
        for(int i = pos; i < s.length(); i++) {
            if(isPalindrome(s,pos,i)) {
                String sub = s.substring(pos,i+1);
                curr.add(sub);
                helper(s,i+1,curr,res);
                curr.remove(curr.size()-1);
            }
        }
    }
    
    boolean isPalindrome(String s, int start, int end) {
        char[] ch = s.toCharArray();
        while(start <= end) {
            if(ch[start++] != ch[end--]) return false;
        }
        return true;
    }
}
