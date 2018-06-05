// The general manager of Byteland Company has decided to rate all of the employees for their performance during this year. The rating will be a score in the range of 90 - 100 (inclusive) points. The manager wants to compute the average rating of all employees whose rating is greater or equal to 90 since he wants to give them a bonus for their good performance.

// image

// Complete the function averageOfTopEmployees which takes in an integer array  denoting the ratings of the employees and prints the average rating of employees who will get a bonus, with exactly  digits after the decimal point, rounded half up. (For example,  should be rounded to , while should be rounded to .)

// Input Format

// The first line contains a single integer  denoting the number of employees in the Byteland Company. Then, lines follow. The  of them contains a single integer  denoting the rating of the  employee.

// Constraints

// It's guaranteed that there is at least one employee with a rating 
// Output Format

// Print a single line containing a real number denoting the average rating of employees who will get a bonus. This number has to have exactly  digits after the decimal point, rounded half up. (For example, should be rounded to , while  should be rounded to .)


import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    // Complete the averageOfTopEmployees function below.
    static void averageOfTopEmployees(int[] rating) {
        double count = 0;
        double sum = 0;
        
        for(int i = 0;i < rating.length;i++){
            if(rating[i] >= 90 && rating[i] <= 100){
                sum = sum + rating[i];
                count = count + 1;
            }
        }
        
        // double res = sum/count;
        // res = 123123.123123;
       // String.format("%.2f", res);
        // DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(String.format("%.2f", sum/count));

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] rating = new int[n];

        for (int ratingItr = 0; ratingItr < n; ratingItr++) {
            int ratingItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            rating[ratingItr] = ratingItem;
        }

        averageOfTopEmployees(rating);

        scanner.close();
    }
}
