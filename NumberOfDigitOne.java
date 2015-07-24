/*
Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

For example:
Given n = 13,
Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.

Hint:

Beware of overflow.
*/

/*
num of 1s          numbers that contain 1s                                                          range of numbers

1                   1                                                                                     [1, 9]

11                 10  11  12  13  14  15  16  17  18  19                                                [10, 19]

1                   21                                                                                   [20, 29]

1                   31                                                                                   [30, 39]

1                   41                                                                                   [40, 49]

1                   51                                                                                   [50, 59]

1                   61                                                                                   [60, 69]

1                   71                                                                                   [70, 79]

1                   81                                                                                   [80, 89]

1                   91                                                                                   [90, 99]

11                 100  101  102  103  104  105  106  107  108  109         				 [100, 109]

21                 110  111  112  113  114  115  116  117  118  119           				 [110, 119]

11                 120  121  122  123  124  125  126  127  128  129          				 [120, 129]
*/

/*
for a given n, ex. n=3141592, 
for each position, split the number into two parts
let's say for position at the hundreds-digit, n is split into a = 31415, b = 92;
for the hundred-digit, here is '5', it's prefixes '3141', i.e., 3142 times. Each of those times is a streak of 100 long. so (a/10+1)*100 times.
the current number at hundred can be divided into three different cases, being 0, 1, and >=2. For example, n=3141092, n=3141192, n=3141592. for case one, i.e., 3141*100+0 times, case2: 3142*100+b times case3: 3142*100 times. This can be done in expression: (a+8)/10 to get the full streaks, and a%10 == 1? b+1 : 0 to get the partial streak.
*/

public class Solution {
    public int countDigitOne(int n) {
        long res = 0;
        for(long m = 1; m <= n; m *= 10) {
            long a = n/m;
            long b = n%m;
            res += (a+8)/10*m + (a%10 == 1? b+1 : 0);
        }
        return (int)res;
    }
}
