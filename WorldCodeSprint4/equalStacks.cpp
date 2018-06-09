// You have three stacks of cylinders where each cylinder has the same diameter, but they may vary in height. You can change the height of a stack by removing and discarding its topmost cylinder any number of times.

// Find the maximum possible height of the stacks such that all of the stacks are exactly the same height. This means you must remove zero or more cylinders from the top of zero or more of the three stacks until they're all the same height, then print the height. The removals must be performed in such a way as to maximize the height.

// Note: An empty stack is still a stack.

// Input Format

// The first line contains three space-separated integers, , , and , describing the respective number of cylinders in stacks , , and . The subsequent lines describe the respective heights of each cylinder in a stack from top to bottom:

// The second line contains  space-separated integers describing the cylinder heights in stack .
// The third line contains  space-separated integers describing the cylinder heights in stack .
// The fourth line contains  space-separated integers describing the cylinder heights in stack .
// Constraints

// Output Format

// Print a single integer denoting the maximum height at which all stacks will be of equal height.

// Sample Input

// 5 3 4
// 3 2 1 1 1
// 4 3 2
// 1 1 4 1
// Sample Output

// 5

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
    int n1;
    int n2;
    int n3;
    cin >> n1 >> n2 >> n3;
    vector<int> h1(n1);
    for(int h1_i = 0;h1_i < n1;h1_i++){
       cin >> h1[h1_i];
    }
    vector<int> h2(n2);
    for(int h2_i = 0;h2_i < n2;h2_i++){
       cin >> h2[h2_i];
    }
    vector<int> h3(n3);
    for(int h3_i = 0;h3_i < n3;h3_i++){
       cin >> h3[h3_i];
    }
   long long int i,j,k,l;
    vector<int>st(10000000,0);
   long long int sum=0,max=0;
    
    for(i=n1-1;i>=0;i--)
    {
        sum=sum+h1[i];
    
        st[sum]++;    
        if(sum>max)
        {
            max=sum;
        }
    }
  sum=0;  
    for(i=n2-1;i>=0;i--)
    {
        sum=sum+h2[i];
        st[sum]++;     
          
        if(sum>max)
        {
            max=sum;
        }
    }
    sum=0;
    
    for(i=n3-1;i>=0;i--)
    {
        sum=sum+h3[i];
        st[sum]++;    
          
        if(sum>max)
        {
            max=sum;
        }
    }
     bool flag=0;
    for(i=max;i>=0;i--)
    {
        if(st[i]==3)
         {
            cout<<i<<endl;
            flag=1;
            break;
        }
    }
    if(flag==0)
    {
        cout<<"0"<<endl;    
    }
   
    return 0;
}
