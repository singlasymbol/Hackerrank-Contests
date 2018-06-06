// Lilah has a string, , of lowercase English letters that she repeated infinitely many times.

// Given an integer, , find and print the number of letter a's in the first  letters of Lilah's infinite string.

// For example, if the string  and , the substring we consider is , the first characters of her infinite string. There are  occurrences of a in the substring.

// Input Format

// The first line contains a single string, . 
// The second line contains an integer, .

// Constraints

// For  of the test cases, .
// Output Format

// Print a single integer denoting the number of letter a's in the first  letters of the infinite string created by repeating  infinitely many times.


#include <map>
#include <set>
#include <list>
#include <cmath>
#include <ctime>
#include <deque>
#include <queue>
#include <stack>
#include <string>
#include <bitset>
#include <cstdio>
#include <limits>
#include <vector>
#include <climits>
#include <cstring>
#include <cstdlib>
#include <fstream>
#include <numeric>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <unordered_map>

using namespace std;


int main(){
   string s;
    cin >> s;
    long n;
    cin >> n;
    long long int l=s.length();
    long long int count=0;
    for(long long int i=0;s[i]!='\0';i++)
        {
        if(s[i]=='a')
            {
            count++;
        }
    }
    long long int count1=n/l;
    count=count*count1;
    count1=n%l;
    for(long long int i=0;i<count1;i++)
        {
        if(s[i]=='a')
            {
            count++;
        }
    }
    cout<<count;
    return 0; 
    
    
    
}