/*
Implement int sqrt(int x).

Compute and return the square root of x.
*/

/*
Thought 1: binary search
Thought 2: Newton's method
Thought 3: for double, the end condition will be the abs(difference) < epsilon
*/

public class Solution {
    /*
    public int mySqrt(int x) {
        if(x < 0) return -1; 
        if(x == 0) return 0;
        int l = 1;
        int h = x/2+1;
        while(l<=h){
            int mid = (l+h)/2;
            if(mid*mid <= x && (mid+1)*(mid+1) > x) return mid;
            else if(mid*mid < x) l = mid+1;
            else h = mid-1;
        }
        return 0;
    }
    */
    
    public int mySqrt(int x) {
        /*
        ** Newton's Method:
        ** finding successively better approximation
        ** x_n+1 = x_n - f(x_n)/f'(x_n)
        ** for this problem, we want to compute y = sqrt(x)
        ** can be converted to minimize f(y) = y^2 - x; 
        ** f'(y) = 2y;
        ** so, y_n+1 = y_n - f(y_n)/f'(y_n) = y_n - (y_n^2 - x)/(2y_n) = (y_n + x/y_n)/2;
        */
        if(x == 0) return 0;
        double y = 1;
        double yLast = 0;
        while(y != yLast){
            yLast = y;
            y = (yLast + x/yLast)/2;
        }
        return (int)y;
    }
}
