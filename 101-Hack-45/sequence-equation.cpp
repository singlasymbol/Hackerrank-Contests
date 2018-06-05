// u are given a sequence of  integers, . Each element in the sequence is distinct and satisfies . For each  where , find any integer  such that  and print the value of  on a new line.

// For example, assume you have the sequence . For each value of  between  and  we analyze as follows:

// , so 
// , so 
// , so 
// , so 
// , so 
// We find the values  for .

// Input Format

// The first line contains an integer , the number of elements in the sequence. 
// The second line contains  space-separated integers  where .

// Constraints

// , where .
// Each element in the sequence is distinct.
// Output Format

// For each  from  to , print an integer denoting any valid  satisfying the equation  on a new line.

// Sample Input 0

// 3
// 2 3 1
// Sample Output 0

// 2
// 3
// 1

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
int  find(int ind, int *arr, int n)
{
    for(int i =1 ;i <= n;i++)
    {
        if(arr[i] == ind)
            return i;
    }
    return 0;
}
int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
   int n , i, j;
    
    cin >>  n;
    int arr[n +1];
    for(i = 1; i <= n; i++)
        cin >> arr[i];
    
    for(i =1; i<= n;i++)
    {
        int index = find(i, arr ,n);
      //  cout << index;
        int ind = find(index, arr, n);
        
        cout << ind<<endl; 
    }
    return 0;
}