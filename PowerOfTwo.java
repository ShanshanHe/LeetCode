/*
Given an integer, write a function to determine if it is a power of two.
*/

/*
Thoughts: if an integer is power of 2, then in its binary representation, there will be only one 1.
For example: 16 (10000)
consider about (n & (n-1)), if n=16 (10000), then n-1 = 15 (01111), n&(n-1)==0
*/

public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ( (n & (n-1)) == 0);
    }
}
