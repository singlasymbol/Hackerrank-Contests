// risten loves playing with and comparing numbers. She thinks that if she takes two different positive numbers, the one whose digits sum to a larger number is better than the other. If the sum of digits is equal for both numbers, then she thinks the smaller number is better. For example, Kristen thinks that  is better than  and that  is better than .

// Given an integer, , can you find the divisor of  that Kristin will consider to be the best?

// Input Format

// A single integer denoting .

// Constraints

// Output Format

// Print an integer denoting the best divisor of .

// Sample Input 0

// 12
// Sample Output 0

// 6
// Explanation 0

// The set of divisors of  can be expressed as . The divisor whose digits sum to the largest number is  (which, having only one digit, sums to itself). Thus, we print  as our answer.


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

int sum_of_digits(int num)
{
    int sum = 0;
    
    while(num != 0)
    {
        sum = sum + num % 10;
        num = num / 10;
    }
    return sum;
}

int main(){
    int i, j ,max = - 1,divisor,n,y;
    cin >> n;
   
    for(i = 1; i <= n; i++)
    {
        if(n % i == 0)
        {
            y = sum_of_digits(i);    
            if(y > max)
            {
                max = y;   
                divisor = i;
            }
        }
    }
    cout << divisor;
    return 0;
}
