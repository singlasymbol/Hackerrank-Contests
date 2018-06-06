
// Sam's house has an apple tree and an orange tree that yield an abundance of fruit. In the diagram below, the red region denotes his house, where  is the start point, and  is the endpoint. The apple tree is to the left of his house, and the orange tree is to its right. You can assume the trees are located on a single point, where the apple tree is at point , and the orange tree is at point .

// Apple and orange(2).png

// When a fruit falls from its tree, it lands  units of distance from its tree of origin along the -axis. A negative value of  means the fruit fell  units to the tree's left, and a positive value of  means it falls  units to the tree's right.

// Complete the function countApplesAndOranges,

// where,

//  Starting point of Sam's house location. 
//  Ending location of Sam's house location. 
//  Location of the Apple tree. 
//  Location of the Orange tree. 
//  Number of apples that fell from the tree. 
//  Distance at which each apple falls from the tree. 
//  Number of oranges that fell from the tree. 
//  Distance at which each orange falls from the tree.

// Given the value of  for  apples and  oranges, can you determine how many apples and oranges will fall on Sam's house (i.e., in the inclusive range )? Print the number of apples that fall on Sam's house as your first line of output, then print the number of oranges that fall on Sam's house as your second line of output.

// Input Format

// The first line contains two space-separated integers denoting the respective values of  and . 
// The second line contains two space-separated integers denoting the respective values of  and . 
// The third line contains two space-separated integers denoting the respective values of  and . 
// The fourth line contains  space-separated integers denoting the respective distances that each apple falls from point . 
// The fifth line contains  space-separated integers denoting the respective distances that each orange falls from point .

// Constraints

// Output Format

// Print two integers on two different lines:

// The first integer: the number of apples that fall on Sam's house.
// The second integer: the number of oranges that fall on Sam's house.



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
    int s;
    int t;
    cin >> s >> t;
    int a;
    int b;
    cin >> a >> b;
    int m;
    int n;
    cin >> m >> n;
    vector<int> apple(m);
    for(int apple_i = 0;apple_i < m;apple_i++){
       cin >> apple[apple_i];
    }
    vector<int> orange(n);
    for(int orange_i = 0;orange_i < n;orange_i++){
       cin >> orange[orange_i];
    }
    
    long long int apples = 0,oranges = 0;
    int i , j, k;
    
    for(i = 0;i < m; i++)
    {
        k = apple[i] + a;
        if(k >= s && k <= t )
        {
            apples++;    
        }
    }    
    
    for( i = 0 ;i < n; i++)
    {
        k = orange[i] + b;
        
         if(k >= s && k <= t )
        {
           oranges++;    
        }
       
    }
    
    cout<<apples<<endl<<oranges;
    return 0;
}
