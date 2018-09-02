import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {


    static Boolean isDecreasingOrder(String num) {
        
        for(int i = num.length() - 2; i >= 0;i--) {
            if(num.charAt(i) > num.charAt(i + 1)){
                return false;
            }
        }
        return true;
    }
    
    static int CountNaturalNumber(int n) {
        
        int count = 0;
        for(int i = 1;i <= n; i++) {
            if(isDecreasingOrder(String.valueOf(i))) {
                count++;
            }
        }
        
        return count;
    }
   public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int res = CountNaturalNumber(n);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

