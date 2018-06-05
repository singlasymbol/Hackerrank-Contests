
// You are given a sequence of  integers, . Find and print any integer  such that  is divisor of every  except for exactly one element.

// Input Format

// The first line contains an integer, , denoting the length of the sequence. 
// The second line contains  positive space-separated integers describing .

// Constraints

// It is guaranteed that a solution exists.
// Output Format

// Print any positive integer denoting  such that  is a divisor of exactly  of the sequence's elements. must be between  and 

// Sample Input 0

// 4
// 3 6 18 12
// Sample Output 0

// 6
// Explanation 0

// We are given the array . There are two possible answers:

//  is a divisor of , , and  but not a divisor of .
//  is a divisor of , , and  but not a divisor of .
// Thus, we can print either  or  as our answer.


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
     int n;
    cin >> n;
    vector<long long int> a(n);
    for(int a_i = 0; a_i < n; a_i++){
       cin >> a[a_i];
    }
    // your code goes here
    long long int count = 0;
   long long int i =2;
    while(1)
        {
        count  = 0;
        for(int j = 0;j<n;j++)
            {
        if((a[j] % i )== 0)
            {
            count++;
        }
        }
        if(count == (n-1))
            {
            cout<<i;
            break;
        }
        i++;
    }
    

    return 0;}
