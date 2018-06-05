// Consider an unsorted array, , of distinct integers from  to . We can swap two adjacent elements in  any number of times as long as the absolute difference between these elements is .

// For example, the diagram below depicts an array where we can swap adjacent elements  and  or  and , but we cannot swap adjacent elements  and  or  and :

// image

// Answer  queries, where each query consists of some array . For each query, print Yes on a new line if it's possible to sort the array in ascending order by performing the swap operation defined above; otherwise, print No instead.

// Input Format

// The first line contains a single integer denoting . The subsequent lines describe each of the  queries in the following format:

// The first line contains an integer denoting .
// The second line contains  space-separated integers describing the respective values of .
// Constraints

// The sum of  over all queries doesn't exceed .
// Output Format

// For each query, print Yes on a new line if it's possible to sort the array; otherwise, print No instead.

// Sample Input 0

// 2
// 4
// 1 0 3 2
// 3
// 2 1 0
// Sample Output 0

// Yes
// No

#include <bits/stdc++.h>

using namespace std;


int main() {
    int q;
    cin >> q;
    for(int a0 = 0; a0 < q; a0++){
        int n;
        cin >> n;
        vector<int> arr(n);
        for(int a_i = 0; a_i < n; a_i++){
           cin >> arr[a_i];
        }
        
        bool flag = true;
        
        for(int i = 0;i < n - 2;i++)
        {
            if((arr[i] > arr[i + 1])  && (arr[i] > arr[i + 2]))    
            {
                flag = false;
                break;
            }
            
            if((arr[i] >= arr[i + 1])  && (arr[i] > arr[i + 2]))    
            {
                flag = false;
                break;
            }
            if((arr[i] > arr[i + 1 ]) && (abs(arr[i] - arr[i + 1]) != 1))
            {
                flag = false;
                break;
            }
        }
        
        if(flag == false)
            cout <<"No"<<endl;
        else
            cout <<"Yes"<<endl;
    }
    return 0;
}
