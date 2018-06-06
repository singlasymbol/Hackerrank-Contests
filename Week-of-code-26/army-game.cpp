
// Luke is daydreaming in Math class. He has a sheet of graph paper with  rows and  columns, and he imagines that there is an army base in each cell for a total of  bases. He wants to drop supplies at strategic points on the sheet, marking each drop point with a red dot. If a base contains at least one package inside or on top of its border fence, then it's considered to be supplied. For example:

// image

// Given  and , what's the minimum number of packages that Luke must drop to supply all of his bases?

// Input Format

// Two space-separated integers describing the respective values of  and .

// Constraints

// Output Format

// Print a single integer denoting the minimum number of supply packages Luke must drop.

// Sample Input 0

// 2 2
// Sample Output 0

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


int main(){
   float n;
    float m;
    cin >> n >> m;
    //bool flag = false;
    n= round(n/2);
    m = round(m /2);
    
   // cout <<"n "<<n <<" m "<<m<<endl;
        cout << n* m;
    
    return 0;
}