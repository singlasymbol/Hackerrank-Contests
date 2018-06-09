// The Mayor of Byteland wants to shorten some buildings that are obstructing Byteland's skyline.

// There are  vertical buildings having heights . Each building can be assumed to be of infinitesimally small width. The base of building  is located at position  on the -axis. This means the first building is at position , the second is at position , and so on.

// The Mayor decides to use lasers to reduce the height of the buildings using a laser with an infinite beam which can be placed at a position on -axis. However, this laser can be fired only at a  angle with the negative -axis. When the laser passes through an existing building, the part of the building above the laser is destroyed. Note that the laser doesn't affect the building at the position from which the laser was fired.

// For example, the image below shows two lasers fired from positions  and  in blue. Portions of buildings destroyed by these lasers are shown in red (i.e., above the laser line) and portions of buildings left intact are shown in purple (i.e., below the laser line).

// rsz_1figure_1.png

// The Mayor orders that  lasers be fired from positions , one by one. Help the Mayor by finding and printing the remaining heights of each building after all  lasers are fired.

// Input Format

// The first line contains a single integer, , denoting the number of buildings. 
// The second line contains  space-separated integers denoting the respective initial heights of the buildings (i.e., . 
// The third line contains a single integer, , denoting the number of lasers that will fire. 
// The fourth line contains  space-separated integers describing the respective positions from which the lasers will be fired (i.e., ).

// Constraints

// Subtasks

// For  of the maximum score, 
// Output Format

// Print a single integer denoting the sum of the remaining building heights after all the lasers are fired.

// Sample Input

// 5
// 3 1 4 5 1
// 2
// 3 5
// Sample Output

// 7

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
int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
     long long int n;
    cin>>n;
    long long int arr[n],i,j;
    for(i=0;i<n;i++)
        {
        cin>>arr[i];
    }
    long long int n1;
    cin>>n1;
    long long int arr1[n1];
    for(i=0;i<n1;i++)
        {
        cin>>arr1[i];
    }
    for(i=0;i<n1;i++)
        {
        long long int k=1;
        for(int j=arr1[i]-2;j>=0;j--)
            {
            
            if(arr[j]>=k)
                {
                arr[j]=k;
            }
            else
                break;
            k++;
        }
    }
 //   cout<<"x";
    long long int sum=0;
    for( i=0;i<n;i++)
        {
      //  cout<<arr[i];
        sum=sum+arr[i];
    }
    cout<<sum;
}