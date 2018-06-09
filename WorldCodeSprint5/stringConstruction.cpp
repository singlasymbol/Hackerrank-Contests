// Amanda has a string of lowercase letters that she wants to copy to a new string. She can perform the following operations with the given costs. She can perform them any number of times to construct a new string :

// Append a character to the end of string  at a cost of  dollar.
// Choose any substring of  and append it to the end of  at no charge.
// Given  strings , find and print the minimum cost of copying each  to  on a new line.

// Input Format

// The first line contains a single integer , the number of strings. 
// Each of the next  lines contains a single string, .

// Constraints

// Subtasks

//  for  of the maximum score.
// Output Format

// For each string  print the minimum cost of constructing a new string  on a new line.

// Sample Input

// 2
// abcd
// abab
// Sample Output

// 4
// 2


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
    int n,count = 0,i ;
    cin >> n;
  //  cout<<n;
    for(int a0 = 0; a0 < n; a0++){
        string s;
        cin >> s;
        count =0;
    
        int arr[26]={0};
  //  cout<<s;
   
    
    for(i = 0; i < s.length() ; i++)
    {
        arr[s[i]-97]++;
    }
    
    for(i = 0; i < 26 ; i++)
    {
        if(arr[i] >=1)
        {
            count++;
        }
    }
    cout<<count<<endl;
    
    }
    return 0;
}
