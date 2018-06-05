// In a weather forecast, given the actual and forecasted temperatures for each day of a week, find the sum of the weather forecast inaccuracies across all  days. The weather forecast inaccuracy on any day is the absolute difference of the actual temperature and the forecasted temperature.

// Complete the function totalForecastInaccuracy which takes in two integer arrays , denoting actual temperatures, and , denoting forecasted temperatures, across  days and returns the sum of the weather forecast inaccuracies across  days.

// Input Format

// The first line contains  space-separated integers , , ..., .

// The second line contains  space-separated integers , , ..., .

// Constraints

// Output Format

// Print a single integer denoting the answer.

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    // Complete the totalForecastInaccuracy function below.
    static int totalForecastInaccuracy(int[] t, int[] f) {
        // Return the sum of the weather forecast inaccuracies across all 7 days.
        
        int sum = 0;
    
        for(int i = 0; i< 7; i++) {
            sum = sum + Math.abs(f[i] - t[i]);        
        }
        
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[] t = new int[7];

        String[] tItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < 7; tItr++) {
            int tItem = Integer.parseInt(tItems[tItr]);
            t[tItr] = tItem;
        }

        int[] f = new int[7];

        String[] fItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int fItr = 0; fItr < 7; fItr++) {
            int fItem = Integer.parseInt(fItems[fItr]);
            f[fItr] = fItem;
        }

        int result = totalForecastInaccuracy(t, f);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
