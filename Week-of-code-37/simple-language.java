// You are given a program written on Simple Language. There's only one variable called  in this programming language. Initially, . The program consists of  lines. Each line is one of the following:

//  ( is an integer) — add  to .
//  ( is an integer) — set the value of  to .
// Here's an example program and also illustrates what happens to  after running each line:

//         x = 0
// add 5
//         x = 5
// add -3
//         x = 2
// set 1
//         x = 1
// add -2
//         x = -1
// add 5
//         x = 4
// Given a program, your task is to remove some lines (possibly none or all of them) in such a way that the value of  after running the resulting program will be the maximum. Find this maximum value.

// Complete the function maximumProgramValue which takes in an integer  denoting the number of lines of the program and returns the maximum value. You will need to take the program's lines from the standard input.

// Input Format

// The first line contains a single integer .

// The next  lines describe the program. Each of these lines contains a string  and an integer  separated by a space, where  or .

// Constraints

// Output Format

// Print a single integer denoting the answer.


import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the maximumProgramValue function below.
     */
    static long maximumProgramValue(int n) {

        long count = 0;
        for(int i = 0;i < n;i++){
            String s = scanner.next();
            String numS = scanner.next();
            
            Long num = Long.parseLong(numS);
            
            if(s.equals("add")){
                if(num < 0){
                    // continue;
                }else{
                    count = count + num;
                }
            }else{
                if(num > count){
                    count = num;
                }
            }
            
            
        }
        
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        long result = maximumProgramValue(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
