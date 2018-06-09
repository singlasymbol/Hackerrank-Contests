// We define the distance between two array values as the number of indices between the two values. Given , find the minimum distance between any pair of equal elements in the array. If no such value exists, print .

// For example, if , there are two matching pairs of values: . The indices of the 's are  and , so their distance is . The indices of the 's are  and , so their distance is .

// Input Format

// The first line contains an integer , the size of array . 
// The second line contains  space-separated integers .

// Constraints

// Output Format

// Print a single integer denoting the minimum  in . If no such value exists, print .

// Sample Input

// 6
// 7 1 3 4 1 7
// Sample Output

// 3
// Explanation 
// Here, we have two options:

//  and  are both , so .
//  and  are both , so .
// The answer is .


// #include <map>
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
    vector<int> A(n);
    for(int i = 0;i < n;i++){
       cin >> A[i];
    }
    int i,j,k,l,min=n;
    bool flag=0;
    for(i=0;i<n;i++)
    {
        for(j=i+1;j<n;j++)
        {
            if(A[i]==A[j])
           {
                k=abs(i-j);
               // cout<<"k "<<k<<" min "<<min<<endl;
                if(k<min)
                    {
                    min=k;
             //       cout<<"in min"<<min<<endl;
                    flag=1;
                }
            }
        }
    }
    if(flag==0)
        {
        cout<<"-1"<<endl;
    }
    else
    cout<<min<<endl;
    return 0;
}
