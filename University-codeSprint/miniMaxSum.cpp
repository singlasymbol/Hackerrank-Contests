// Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. Then print the respective minimum and maximum values as a single line of two space-separated long integers.

// Input Format

// A single line of five space-separated integers.

// Constraints

// Each integer is in the inclusive range .
// Output Format

// Print two space-separated long integers denoting the respective minimum and maximum values that can be calculated by summing exactly four of the five integers. (The output can be greater than a 32 bit integer.)

// Sample Input

// 1 2 3 4 5
// Sample Output

// 10 14
// Explanation

// Our initial numbers are , , , , and . We can calculate the following sums using four of the five integers:

// If we sum everything except , our sum is .
// If we sum everything except , our sum is .
// If we sum everything except , our sum is .
// If we sum everything except , our sum is .
// If we sum everything except , our sum is .
// Hints: Beware of integer overflow! Use 64-bit Integer.


#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    vector<long long int> arr;
    long long int i, j, k,x;
    long long int sum =0 ,min = 0;
    for( i =0; i < 5;i++)
    {
        cin >> x;
        arr.push_back(x);
    }
    sort(arr.begin(),arr.end());
    
        cout<< arr[0] + arr[1] +arr[2] +arr[3] << " ";
        cout<< arr[1] + arr[2] +arr[3] +arr[4];
    
    return 0;
}
