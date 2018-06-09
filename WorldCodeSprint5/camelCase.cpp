// Alice wrote a sequence of words in CamelCase as a string of letters, , having the following properties:

// It is a concatenation of one or more words consisting of English letters.
// All letters in the first word are lowercase.
// For each of the subsequent words, the first letter is uppercase and rest of the letters are lowercase.
// Given , print the number of words in  on a new line.

// Input Format

// A single line containing string .

// Constraints

// Output Format

// Print the number of words in string .

// Sample Input

// saveChangesInTheEditor
// Sample Output

// 5
// Explanation

// String  contains five words:

// save
// Changes
// In
// The
// Editor
// Thus, we print  on a new line.

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
        
    int i, j, k, count = 1;
    
    for( i = 0 ; i < s.length() ; i++)
    {
        if( s[i]>= 65 && s[i] <=90 )
        {
               count++;
        }
    }
    
    cout<<count;
}