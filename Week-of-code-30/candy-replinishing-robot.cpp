// Alice is hosting a party! The party lasts for  minutes, and she puts out a bowl of  candies at the beginning of the party. During each minute , a person comes to the bowl and removes  candies.

// Alice programs the following algorithm into her robot, Bob, to replenish the candy throughout the party:

// If the party is ending (i.e., it's time ), do not refill the bowl.
// If the bowl contains  candies at the end of minute  and , add  candies to the bowl.
// For example, if , , and , then the candy bowl looks like this throughout the party:

// image

// Note that Bob doesn't replenish the bowl at the party's end, so a total of  candies were added during the party.

// Given , , and the number of candies removed from the bowl during each minute, print the total number of new candies Bob adds to the bowl during the party.

// Input Format

// The first line contains two space-separated integers describing the respective values of  and . 
// The second line contains  space-separated integers describing the respective values of .

// Constraints

// , where  is the number of candies in the bowl at the start of minute .
// Output Format

// Print the total number of new candies Bob adds to the bowl during the party.

// Sample Input 0

// 8 4
// 3 1 7 5
// Sample Output 0

// 11

#include <bits/stdc++.h>

using namespace std;

int main(){
    int n;
    int t;
    cin >> n >> t;
    vector<int> c(t);
    for(int c_i = 0; c_i < t; c_i++){
       cin >> c[c_i];
    }
    
    int count = 0;
    int candies = n;
    for(int i =0 ; i< t;i++)
    {
        n = n - c[i];
     //   cout << "n "<<n<<" i "<<i << " c[i] "<< c[i]<<endl;
        if(n < 5 && i != t - 1)
        {
            count = count + candies - n;
            n = n + (candies - n);    
        }
        
  //      cout << "n "<<n<<" i "<<i << " c[i] "<< c[i]<<endl;
        
    }
    
    cout << count;
    // your code goes here
    return 0;
}