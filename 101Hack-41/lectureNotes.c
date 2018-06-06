
// Alex has a habit of falling asleep during lectures! In order to complete the day's homework, he must determine if he has any friends that stayed awake so he can borrow their notes.

// There are  other students in Alex's class, and each student has a distinct ID number from  to . You are given a string, , of  binary characters where the  character denotes whether the  student slept during the lecture or not. If the  character is a , then the  student stayed awake and took notes; otherwise, the  character is a  which indicates the student fell asleep and did not take notes.

// Alex has  friends in his class and you are given a list of integers corresponding to their respective ID numbers. If Alex can borrow the lecture notes from one of his friends, print YES; otherwise, print NO.

// Input Format

// The first line contains two space-separated integers denoting the respective values of  (the number of students in Alex's class) and  (Alex's number of friends in the class). 
// The second line contains a single binary string (i.e., 's and 's) of length . If the  character is a , then Alex can't get notes from them; otherwise, it's a , indicating the  student took lecture notes. 
// The next line contains  distinct space-separated integers where each integer denotes the ID number of one of Alex's friends.

// Constraints

// Output Format

// Print YES on a new line if Alex can get the lecture notes from one of his friends; otherwise, print NO.

// Sample Input

// 3 2
// 101
// 1 3
// Sample Output

// NO
// Explanation

// There are  other students in the class, and  of them are Alex's friends. Students  and  fell asleep, but student  stayed awake. Alex is only friends with students  and  and, as they both fell asleep during the lecture, Alex cannot get notes from them. Thus, we print NO as our answer.

#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

int main(){
    int n; 
    int k; 
    scanf("%d %d",&n,&k);
    char* s = (char *)malloc(512000 * sizeof(char));
    scanf("%s",s);
    int *friends = malloc(sizeof(int) * k);
    for(int friends_i = 0; friends_i < k; friends_i++){
       scanf("%d",&friends[friends_i]);
    }
    int i, j, max =0 ,count = 0,flag =0;
    int str[10000] ;
    
    for(i = 0;  i < k ;i++)
    {
        str[friends[i]] = 1;
        if(max <friends[i])
        {
            max = friends[i];    
        }
    }
    


    for(i =1; i <=max; i++ )
    {   
        if(str[i] != 1)
        {
            str[i] = 0;   
        }
    }
    for(i =1; i <=max; i++ )
    {   
        if(str[i] == 1)
        {
            str[i] = 0;   
        }
        else
            str[i] = 1;
    }
    
      /*  for(i =1; i <=max; i++ )
        {
            printf("%d ",str[i] );
        }
    printf("\n");
    */
   // printf("max %d",max);
    for( i=1 ;i <=max;i++)
    {
        /*printf("%d %c",str[i],s[i -1]);
        printf("\n");
        */
        if(str[i] == s[i -1] - 48 && str[i] == 0)
        {
            printf("YES");    
            flag =1;
            break;
        }
    }
    if(flag == 0)
        printf("NO");
    
    return 0;
}
