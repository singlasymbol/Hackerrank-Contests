
Alice owns a company that transports tour groups between two islands. She has  trips booked, and each trip  has  passengers. Alice has  boats for transporting people, and each boat's maximum capacity is passengers.

Given the number of passengers going on each trip, determine whether or not Alice can perform all  trips using no more than  boats per individual trip. If this is possible, print Yes; otherwise, print No.

Input Format

The first line contains three space-separated integers describing the respective values of  (number of trips), (boat capacity), and  (total number of boats). 
The second line contains  space-separated integers describing the values of .

Constraints

Output Format

Print Yes if Alice can perform all  booked trips using no more than  boats per trip; otherwise, print No.

Sample Input 0

5 2 2
1 2 1 4 3
Sample Output 0

Yes
Explanation 0

Alice has  boats and a maximum capacity of  passengers per boat. This means she can transport at most  passengers at a time.

There are  tour groups, and the largest tour group contains  passengers. Because Alice will be able to transport each group using  boats per group, we print Yes.

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
    int c;
    int m;
   int max = 0; 
    cin >> n >> c >> m;
    vector<int> p(n);
    for(int p_i = 0; p_i < n; p_i++){
       cin >> p[p_i];
        
        if(max < p[p_i])
            max = p[p_i];
    }
    
    int mul = c*m;
  //  cout << mul << max;
   if(mul >= max)
       cout << "Yes";
    else
        cout<<"No";
    return 0;
}
