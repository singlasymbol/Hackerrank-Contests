// Among all students planning to enroll to summer school at a university, each student wants to take exactly one out of all the available classes. To help the university in planning, your task is to find out how many students are taking each class.

// Complete the function howManyStudents which takes in an integer denoting the number of available classes, and an integer array denoting index of each class as input. The function must return an integer array where each element in the array represents the number of students that want to take each class.

// Input Format

// The first line contains two space-separated integers , denoting the total number of students and , denoting the number of available classes.

// The second line contains  space-separated integers , where  represents the index of the class that student  wants to take.

// Note: We index the students  to  and we index the classes  to .

// Constraints

// Output Format

// Print a single line containing  space-separated integers ,where  represents the number of students that want to take class .

// Sample Input 0

// 4 3
// 2 2 0 2
// Sample Output 0

// 1 0 3


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] howManyStudents(int m, int[] c) {
        // Return an array denoting the number of students taking each class.
        int [] res = new int[m];
        // System.out.println(c.length);
        
        for(int i = 0;i < res.length; i++){
            res[i] = 0;
        }
        
        for(int i = 0;i < c.length; i++){
            res[c[i]]++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] c = new int[n];
        for(int c_i = 0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int[] result = howManyStudents(m, c);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
