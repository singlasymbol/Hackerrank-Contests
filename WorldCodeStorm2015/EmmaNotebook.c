Emma is writing bits (s and s) in her notebook. Every second, she writes more bits.

In the  second, she writes two bits in her notebook. She starts with  and alternates between  and . They look like this:

0 1
In the  second, she writes three more bits in her notebook. This time, she starts with  and keeps alternating between  and . Now, they look like this:

0 1 
1 0 1
After  seconds, her notebook looks like this:

0 1
1 0 1
0 1 0 1
1 0 1 0 1
0 1 0 1 0 1
1 0 1 0 1 0 1
If you count carefully, you can see that Emma wrote  's in her notebook after  seconds. She wants to know how many 's she can write in  seconds.

Input Format

Input contains just one integer: .

Constraints


Output Format

Print the number of 's Emma can write in  seconds.

Sample Input 1

3
Sample Output 1

5
Explanation 1 Add one more row to the example of the  second above and then you will see five 's in total.

#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

int main(){
    int t; 
    scanf("%d",&t);
    long long int sum=0,i,k,l,n,j;
   
    if(t==1)
        {
        printf("1");
        
    }
    else
       {

    for(j=2;j<=t;j++)
        {
          if(j%2==1)
            {
            i=(j+1)/2;
        }
        else if(j%2==0)
            {
            i=(j+2)/2;
        }
        
        sum=sum+i;
        //printf("%lld",i);
    }
            printf("%lld",sum+1);

    }
    return 0;
}