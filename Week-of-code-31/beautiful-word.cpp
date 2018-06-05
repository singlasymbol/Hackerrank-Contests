
We consider a word, , to be beautiful if the following two conditions are satisfied:

No two consecutive characters are the same.
No two consecutive characters are in the following vowel set: a, e, i, o, u, y. Note that we consider y to be a vowel in this challenge.
For example:

image

The string batman is beautiful because it satisfies the given criteria; however, apple has two consecutive occurrences of the same letter (pp) and beauty has three consecutive vowels (eau), so those words are not beautiful.

Given , print Yes if it is beautiful or No if it is not.

Input Format

A single string denoting .

Constraints

 consists of lowercase English alphabetic letters only (i.e., a through z).
Output Format

Print Yes if  is beautiful, or No if it is not.

Sample Input 0

abacaba
Sample Output 0

Yes


#include <bits/stdc++.h>

using namespace std;

int main(){
    string w;
    cin >> w;
    // Print 'Yes' if the word is beautiful or 'No' if it is not.
    int arr[26];
    
    for(int i =0 ;i < 26;i++)
    {
        arr[i] = false;    
    }
    
    arr[0] = true;
    arr['o' - 'a'] = true;
    arr['e' - 'a'] = true;
    arr['i' - 'a'] = true;
    arr['u' - 'a'] = true;
    arr['y' - 'a'] = true;
    
    bool flag = false;
    for(int i =0 ;i < w.length() - 1;i++)
    {
        if(arr[w[i] - 'a'] && arr[w[i + 1] - 'a'])
        {
            flag = true;
            break;
        }
        
        if(w[i] == w[i  +1 ])
        {
            flag = true;
            break;
        }
    }
    
    if(flag == true)
        cout <<"No";
    else 
        cout <<"Yes";
    return 0;
}