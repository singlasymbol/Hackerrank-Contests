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

    //takes two indexes and returns back the bigger of the integers at both the indexes;
    static int findMaxUsingIndex(int index1, int index2, List<Integer> jars, int jarLength,int [] resArray ) {
        if(index1 >= jarLength) {
            return 0;
        } 
        
        if(index2 >= jarLength) {
            return jars.get(index1);
        }
        
        return Math.max(resArray[index1], resArray[index2]);
    }
    
    static int maximum_cookies(List<Integer> jars) {
        
        //handling corner cases
        if(jars.size() == 0) {
            return 0;    
        }
        
        if(jars.size() == 1){
            return jars.get(0);
        }
        
        int jarLength = jars.size();
        
        //creating a final Array for each index to keep count of maxCookies one can obtain from its right side.
        int [] resArray = new int[jars.size()];
        Arrays.fill(resArray, 0);
        
        
        for(int i = jarLength - 1; i >= 0; i--) {
            resArray[i] = jars.get(i) + findMaxUsingIndex(i + 2, i + 3, jars, jarLength, resArray);  
        }
        
        return Math.max(resArray[0], resArray[1]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int jarsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> jarsTemp = new ArrayList<>();

        IntStream.range(0, jarsCount).forEach(i -> {
            try {
                jarsTemp.add(bufferedReader.readLine().replaceAll("\\s+$", ""));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> jars = jarsTemp.stream()
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int res = maximum_cookies(jars);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
