// t's that time of the year again! Hogwarts School of Witchcraft and Wizardry is looking to send invitation letters to its new batch of students. This year all the owls are on vacation. The school has chosen to use the email addresses of the students instead.

// But unfortunately, due to some mischief of Peeves, some of the email addresses have been corrupted. Now the headmistress, Professor McGonagall has called upon you to help her retrieve the valid email addresses.

// A valid email address must be in the form: abcde@hogwarts.com

// abcde can be replaced by exactly  lowercase english letters.
// The domain (@hogwarts.com) must remain same for every valid email address.
// The following figure shows some valid and invalid email address:

// image

// Given an email address, your task is to determine and print if it's valid or not.

// Input Format

// The first line contains a string  denoting the email address.

// Constraints

// .
// The string only contains ASCII characters without any spaces.
// Output Format

// In a single line, you have to print Yes if the string is a valid email address. You have to print No otherwise.

// Sample Input 0

// dumbledore@hogwarts.com
// Sample Output 0

// No

#include <bits/stdc++.h>
#include <string>

using namespace std;

string isValid(string email) {
    // Complete this function
    bool firstFlag = false,secondFlag = false;
    int length = email.length();
    for(int i = 0; i < length; i++){
        if(email[i] == '@' && i == 5){
            firstFlag = true;
        }
        if(email[i] == '@' && i!=5){
            return "No";
        }
        if(i < 5 && !(email[i] >=97 && email[i] <=122)){
            return "No";
        }
    }

   /* cout<< length <<endl;
    cout << length - 6<<endl;
    cout << email.substr(5,length)<<endl;
    */
    if(length - 6 == 12 && email.substr(5,length) == "@hogwarts.com"){
        secondFlag = true;
    }
     
    if(firstFlag == true && secondFlag == true){
        return "Yes";
    }
    return "No";
}

int main() {
    string s;
    cin >> s;

    string result = isValid(s);
    cout << result << endl;
    return 0;
}