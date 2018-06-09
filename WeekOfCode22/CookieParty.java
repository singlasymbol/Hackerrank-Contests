// You're having a cookie party tonight! You're expecting  guests and you've already made  cookies. You want to distribute all the cookies evenly between your guests in such a way that each guest receives the same number of whole cookies. If there are not enough cookies to give everyone the same amount, you must make some number of additional cookies.

// Given  and , find and print the minimum number of additional cookies you must make so that everybody receives the same number of cookies.

// Input Format

// A single line of two space-separated integers describing the respective values of  and .

// Constraints

// Output Format

// Print a single integer denoting the number of additional cookies you need to make so that everyone at the cookie party has the same number of whole cookies.

// Sample Input

// 3 2
// Sample Output

// 1
// Explanation

// There are  people coming to your party and you've made  cookies. For each person to have the same number of whole cookies, you must make  additional cookie. Thus, we print  as our answer.


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        
        m = m % n;
        System.out.println((m == 0) ? 0 : (n - m));
    }
}