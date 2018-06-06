// Alex is preparing for a programming contest and decides the gears turning in his head are at war with his own laziness. He imagines chains of  circularly linked gears trying to turn in his head, and wonders under which circumstances they might be able to turn together in a single chain and when they might be locked (i.e., unable to rotate together).

// Alex decides to set a problem for himself by creating  queries where each query takes the form of an integer, , denoting some number of circularly linked gears. For each query, print Yes on a new line if the gears can turn together; otherwise, print No.

// Input Format

// The first line contains single integer, , denoting the number of queries. 
// Each line  of the  subsequent lines contains a single integer, , denoting the number of gears for that query.

// Constraints

// Output Format

// For each query, print Yes on a new line if it is possible to rotate all  gears simultaneously; otherwise, print No.

// Sample Input

// 2
// 3
// 4
// Sample Output

// No
// Yes

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */  
    long long int i , j,t,n;
    
    cin >> t;
    
    while(t--)
    {
        cin >> n;
        if(n == 1 || n == 2 || n%2 == 0)
            cout<<"Yes"<<endl;
        
        if(n%2 == 1)
        {
            cout<<"No"<<endl;    
        }
    }
    return 0;
}
