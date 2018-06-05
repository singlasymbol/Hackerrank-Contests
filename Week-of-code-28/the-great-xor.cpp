// Given a long integer , count the number of values of  satisfying the following conditions:

// where  and  are long integers and  is the bitwise XOR operator.

// You are given  queries, and each query is in the form of a long integer denoting . For each query, print the total number of values of  satisfying the conditions above on a new line.

// For example, you are given the value . Condition  requires that . The following tests are run:

 
 
 

// We find that there are  values meeting the first condition:  and .

// Input Format

// The first line contains an integer , the number of queries. 
// Each of the next  lines contains a long integer describing the value of  for a query.

// Constraints

// Subtasks

// For  of the maximum score:

// Output Format

// For each query, print the number of values of  satisfying the given conditions on a new line.

// Sample Input 0

// 2
// 2
// 10
// Sample Output 0

// 1
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
    int q;
    cin >> q;
    for(int a0 = 0; a0 < q; a0++){
        long x;
        cin >> x;
        
        long y = x, count = 0;
        int bit = 0;
        int lcb = 0;
        int mcb = 0;
        int i = 0;
      
        while(y != 0)
        {
            bit = y & 1;
            
            if(bit == 0)
            {
                count = count + pow(2, i);    
            }
            i++;
            y = y >> 1;
        }
        
        cout << count <<endl;
    }
    return 0;
}
