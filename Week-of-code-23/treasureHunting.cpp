// Sam is a young treasure hunter located at point  and wants to get to the amazing treasure at point .

// He has a weird machine that can transport him from some point  to point , where  is a direction vector and  is a real number called a tangent coefficient. Let  be the vector orthogonal to  which has the same length and lies counter-clockwise from ; Sam can then also move from point  to point , where  is a real number called a normal coefficient.

// Given , , , and , find the values of  and  for Sam's journey from point  to point  using the weird machine. Then print the value of  on a new line and the value of  on the subsequent line.

// Input Format

// The first line contains two space-separated integers denoting the respective values of  and . 
// The second line contains two space-separated integers denoting the respective values of  and .

// Constraints

// Output Format

// Find two real numbers,  and , such that . Then print  as your first line of output and  as your second line of output. Your answer is considered to be correct if its absolute error is .

// Sample Input

// 5 3
// 1 1
// Sample Output

// 4.000000000000 
// -1.000000000000


#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    long long int x,y,a,b,c,d;
     double k,n;
    
    cin >> x >> y;
    cin >> a >> b;
    k = ( a * x + b * y) / ( pow(a, 2) + pow(b, 2) );
   
    /*a = a * k;
    b = b * k;
    */
    
    c = -b;
    d = a;
   
    double i,j;
    
    n = (y - k * b)/d;
    
std::cout.unsetf ( std::ios::floatfield ); 
    cout.precision(12);
    cout <<k << endl;
    cout<<n <<endl;
    
    return 0;
}
