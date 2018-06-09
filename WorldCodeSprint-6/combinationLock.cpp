// Consider a -slot combination lock where each slot contains a dial numbered with the ten sequential decimal integers in the inclusive range from  to . In one operation, you can choose a slot and rotate the dial by one click, either in the positive direction (to increase the displayed number by ) or the negative direction (to decrease the displayed number by ). Note that, due to the cyclical nature of the dial, the next number after is  and the number before  is ). For example, if the number  is currently displayed on the dial, you can rotate the dial to either  (positive direction) or  (negative direction) in a single operation.

// combination lock

// Given the initial configuration of numbers in each slot and some desired configuration of numbers, determine the minimum number of operations you must perform to change the lock's slots to the desired configuration.

// Input Format

// The first line contains  space-separated integers denoting the current slot configuration. 
// The second line contains  space-separated integers denoting the desired slot configuration.

// Constraints

// Each number in a slot is .
// Output Format

// Print a single integer denoting the minimum number of moves to change this configuration to the correct one.

// Sample Input

// 1 2 9 5 7
// 1 3 2 0 7  
// Sample Output

// 9


#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    
    int i;
    int a, b , diff,sum = 0 , n= 5;
    int arr[5];
    int ar[5];
    
    for(i =0;i < n; i++)
    {
        cin >> arr[i];
        
    }

    for(i =0;i < n; i++)
    {
        cin >> ar[i];
        
    }    
    
    for( i= 0; i < n ; i++)
    {
        a = arr[i];
        b = ar[i];
        
        if(a!=b)
        {
            diff = abs(a - b);
            
            if(diff > 5)
            {
                sum = sum + (10 - diff);    
            }
            else
                sum = sum + diff;
        }
        
    }
    
    cout<<sum<<endl;
    return 0;
}