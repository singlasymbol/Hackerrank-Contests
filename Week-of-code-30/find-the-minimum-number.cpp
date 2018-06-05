// ssica is learning to code and was recently introduced to the  function. This function compares two integers and returns the smaller one. This is what calling the function looks like when comparing two integers  and :

// min(a, b)
// Jessica realizes that she can also find the smallest of three integers , , and  if she puts the  function inside of another  function:

// min(a, min(b, c))
// For four integers she can nest the functions once more:

// min(a, min(b, min(c, d)))
// Jessica is curious about the structure of these function calls and wants to see if she can write a program to construct a string that shows how  number of integers can be compared with nested  functions. Can you help Jessica write this program?

// Input Format

// The input contains a single integer  (the number of integers to be compared).

// Constraints

// Output Format

// Print the string on a single line. Each integer in the string should be written as 'int' and the string must accurately show how  functions can be called to find the smallest of  integers.

// Sample Input 0

// 2
// Sample Output 0

// min(int, int)
// Explanation 0

// With an input of  we only have two integers to compare. We don't need to nest the  functions for our output because the  function can take two integers as input.



#include <bits/stdc++.h>
#include<iostream>
#include<cstring>

using namespace std;

void make_exp(int n,string exp)
{
    while(n--)
    {
         exp = "min(int, "+exp +")";
    }
    
    cout << exp;
}

int main(){
    int n;
    cin >> n;
    string exp = "min(int, int)";
    
    make_exp(n -2,exp);
    return 0;
}
