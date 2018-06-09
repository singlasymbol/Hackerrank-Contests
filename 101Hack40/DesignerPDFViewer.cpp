// When you select a contiguous block of text in a PDF viewer, the selection is highlighted with a blue rectangle. In this PDF viewer, each word is highlighted independently. For example:

// PDF-highighting.png

// In this challenge, you will be given a list of letter heights in the alphabet and a string. Using the letter heights given, determine the area of the rectangle highlight in  assuming all letters are  wide.

// Input Format

// The first line contains  space-separated integers describing the respective heights of each consecutive lowercase English letter, ascii[a-z]. 
// The second line contains a single word, consisting of lowercase English alphabetic letters.

// Constraints

// , where  is an English lowercase letter.
// Word contains no more than  letters.
// Output Format

// Print a single integer denoting the area in  of highlighted rectangle when the given word is selected. Do not print units of measure.

// Sample Input 0

// 1 3 1 3 1 4 1 3 2 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5
// abc
// Sample Output 0

9

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
    int n = 26;
    vector<int> h(n);
    for(int h_i = 0;h_i < n;h_i++){
       cin >> h[h_i];
    }
    string word;
    cin >> word;
    
    int i , j, k,max= 0;
    
    // cout<<"word length"<<word.length();
    for(i = 0; i< word.length(); i++)
    {
       // cout<<int(word[i])<< " ";
       if(h[int(word[i]) - 97] > max)
       {
     //      cout<< "here";
            max = h[int(word[i]) - 97];    
       }
    }
   // cout<< max << endl;
    
    cout <<  max * word.length();
    return 0;
}
