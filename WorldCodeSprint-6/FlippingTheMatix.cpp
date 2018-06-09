Sean invented a game involving a  matrix where each cell of the matrix contains an integer. He can reverse any of its rows or columns any number of times. The goal of the game is to maximize the sum of the elements in the  submatrix located in the upper-left quadrant of the matrix.

Given the initial configurations for  matrices, help Sean reverse the rows and columns of each matrix in the best possible way so that the sum of the elements in the matrix's upper-left quadrant is maximal.

For example, given the matrix:

1 2
3 4
It is  so we want to maximize the top left  matrix. Reverse row :

1 2
4 3
And now reverse column :

4 2
1 3
The maximal sum is .

Input Format

The first line contains an integer , the number of queries.

The next  sets of lines are in the following format:

The first line of each query contains an integer, .
Each of the next  lines contains  space-separated integers  in row  of the matrix.
Constraints

, where .
Output Format

You must print  lines of output. For each query, print the maximum possible sum of the elements in the matrix's upper-left quadrant.

Sample Input

1
2
112 42 83 119
56 125 56 49
15 78 101 43
62 98 114 108
Sample Output

414


#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int greater_four(int var1,int var2,int var3,int var4)
{
 
    return (var1 > var2 ? var1 : var2)>(var3 > var4 ? var3 : var4) ?  (var1 > var2 ? var1 : var2):(var3 > var4 ? var3 : var4);
} 

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    
    int i, j,k, l,n,t;
    
    cin >> t;
    
    while(t--)
    {
        cin >>  n;
        int m = 2*n ;
        int a,b,c,d,sum = 0;
        int arr[m][m];
        
        for(i =0 ;i <m ; i++)
        {
            for( j =0 ;j < m ;j++)
            {
                cin >> arr[i][j];    
            }
        }
        
        for(i =0 ;i <n; i++)
        {
            for( j =0 ;j < n;j++)
            {
                a = arr[i][j];
                b = arr[m - i -1][j];
                c = arr[i][m - j -1];
                d = arr[m - i - 1][m - j- 1];
                
                sum = sum + greater_four(a,b,c,d);
            }
        }
        cout << sum<<endl;   
    }
    return 0;
}
