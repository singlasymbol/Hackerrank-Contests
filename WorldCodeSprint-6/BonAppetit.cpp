// Anna and Brian are sharing a meal at a restuarant and they agree to split the bill equally. Brian wants to order something that Anna is allergic to though, and they agree that Anna won't pay for that item. Brian gets the check and calculates Anna's portion. You must determine if his calculation is correct.

// For example, assume the bill has the following prices: . Anna declines to eat item which costs . If Brian calculates the bill correctly, Anna will pay . If he includes the cost of , he will calculate . In the second case, he should refund  to Anna.

// You are given an array of prices, , the cost of each of the  items, , the item Anna doesn't eat, and , the total amount of money that Brian charged Anna for her portion of the bill. If the bill is fairly split, print Bon Appetit. Otherwise, print the integer amount of money that Brian must refund to Anna.

// Input Format

// The first line contains two space-separated integers  and , the number of items ordered and the -based index of the item that Anna did not eat. 
// The second line contains  space-separated integers  where . 
// The third line contains an integer, , the amount of money that Brian charged Anna for her share of the bill.

// Constraints

// Output Format

// If Brian did not overcharge Anna, print Bon Appetit on a new line; otherwise, print the difference (i.e., ) that Brian must refund to Anna. This will always be an integer.


#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    long long int n , k;
    cin >> n >> k;
    long long int i , j ,sum=0 ,sum1 =0,arr[100000], actual;
    
    for(i=0; i < n; i++)
    {
        cin >> arr[i];    
        if(i != k)
            sum1 =  sum1 +arr[i];
    
        sum = sum + arr[i];
    }
    
    int charged;
    cin >> charged;

    actual = sum1 / 2;
    
    if(charged == actual)
    {
        cout<<"Bon Appetit"<<endl;    
    }
    
    else
    {
        cout<< charged - actual<<endl;
    }
    return 0;
}
