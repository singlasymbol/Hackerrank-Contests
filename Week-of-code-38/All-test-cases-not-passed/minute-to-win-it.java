import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    
    static int getCountFromIndex(int []a, int k ) {
        int [] diff = new int[a.length - 1];
        int index = 0;
        int finalIndex = 0;
        
        for(int i = 1; i < a.length; i++) {
            diff[index++] = a[i] - a[i - 1];
        }
        
        int contSum = 0;
        int max = 0;
        boolean setVal = false;
        
        // for(int i = 0; i < diff.length; i++) {
        //     System.out.print( diff[i] + " ");
        // }
        System.out.println();
        
        for(int i = 0; i < diff.length; i++) {
            if(diff[i] == k){
                contSum++;
                if(contSum > max) {
                    finalIndex = i;
                    max = contSum;
                    setVal = true;
                }
            } else {
                contSum = 0;
            }
        }
        return (setVal ? finalIndex : a.length/ 2);
    }
    
    static int getChangesFromIndex(int []a, int k , int index) {
        int sum = 0;
        for(int i = 0 ; i < a.length; i++) {
            int val = a[i];
            int anchorVal = a[index];
            int expVal = anchorVal + (k * (i - index));
            
            if(val != expVal) {
                sum++;
            }
        }
        
        return sum;
    }

    static int minuteToWinIt(int[] a, int k) {
        int index = getCountFromIndex(a, k);
        // System.out.println("index "+ index);
        // return a.length - count - 1;
        if(k == 0 ){
            return a.length - 1;
        }
        int changes = getChangesFromIndex(a, k, index);
        return changes;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = minuteToWinIt(a, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
