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


    // Complete the countConnections function below.
    static Set<String> hm = new HashSet<String>();

    static Boolean isValid(int row, int col, List<List<Integer>> matrix) {
        int verticalSize = matrix.size();
        int horizontalSize = matrix.get(0).size();
        
        if(row < 0 || row >= verticalSize) {
            return false;
        }
        
        if(col < 0 || col >= horizontalSize) {
            return false;
        }
        
        return true;
    }
    
    static int size = 0;
    static void checkAndPut(Integer row, Integer col, List<List<Integer>> matrix, String currRowColString) {
        
        if(isValid(row,col, matrix)){
            System.out.println("i " + row + " j " + col + " is valid");
            int adjNum = matrix.get(row).get(col);
            if(adjNum == 1) {

                String adjRowColString = new Integer(row).toString() + "_" +  new Integer(col).toString();            
                
                String connectionStringfirst = currRowColString + "_" + adjRowColString;
                String connectionStringsecond = adjRowColString + "_" + currRowColString;
                if(!hm.contains(connectionStringfirst) && !hm.contains(connectionStringsecond)) {
                    hm.add(connectionStringfirst);
                    hm.add(connectionStringsecond);
                    size++;
                }

            }
        }
    }

    static int countConnections(List<List<Integer>> matrix) {
        
        for(int i =0 ;i < matrix.size(); i++){
            List<Integer> rowVals = matrix.get(i);
            
            for(int j =0 ; j < rowVals.size(); j++) {
                int num = rowVals.get(j);
                
                if(num != 0) {
                    Integer row = i;
                    Integer col = j;
                    String currRowColString = new Integer(row).toString() + "_" + new Integer(col).toString();

                    System.out.println("CHECKING FOR "+ num);
                    checkAndPut(i + 1, j, matrix,currRowColString);
                    checkAndPut(i + 1, j - 1, matrix ,currRowColString);
                    checkAndPut(i + 1, j + 1, matrix, currRowColString);
                    checkAndPut(i - 1, j - 1, matrix, currRowColString);
                    checkAndPut(i - 1, j, matrix, currRowColString);
                    checkAndPut(i - 1, j + 1, matrix, currRowColString);
                    checkAndPut(i, j - 1, matrix, currRowColString);
                    checkAndPut(i , j + 1, matrix, currRowColString);
                    System.out.println("size "+ size);
                    System.out.println("+======+");
                }
            }
        }
        
         return size;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int matrixRows = Integer.parseInt(bufferedReader.readLine().trim());
        int matrixColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, matrixRows).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = countConnections(matrix);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
