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

  static class Counts {
        int min;
        int max;
        
        Counts(int min, int max) {
            this.min = min;
            this.max = max;
        }
        
        public String toString() {
            return "min "+ this.min + " max " + this.max;
        }
    }

    static HashMap<String, Counts> hm = new HashMap<String, Counts>();

    static Boolean findMinsAndMaxInRow(List<List<Integer>> matrix) {
        
        for(int i =0 ; i < matrix.size(); i++) {
            List<Integer> row = matrix.get(i);
            
            int min_row = Integer.MAX_VALUE;
            int max_row = Integer.MIN_VALUE;
            int minCount = 0;
            int maxCount = 0;
            
            System.out.println("for i " + i + " " + row + " size "+ row.size());
            
            for(int j =0 ;j < row.size(); j++) {
                int num = row.get(j);    
                System.out.println("num " + num);
                if(num < min_row) {
                    min_row = num;
                }
                
                if(num > max_row) {
                    max_row = num;
                }
            }
            
            
            for(int j =0 ; j < row.size() ;j++) {
                if(min_row == row.get(j)) {
                    minCount++;
                }
                
                if(max_row == row.get(j)) {
                    maxCount++;
                }
            }
            
            if(minCount > 1 || maxCount > 1) {
                return true;
            }
            
            Integer rowNumber = i;
            Counts countElement = new Counts(min_row, max_row);
            String res = new String("row_" +rowNumber.toString());
            System.out.println("res "+ res + " counts " + countElement); 
            hm.put(res, countElement);
            System.out.println();
        }
        
        return false;
    }

    static Boolean findMinsAndMaxInColumn(List<List<Integer>> matrix) {
        int horizontalSize =0;
        int matrixSize = matrix.size();
        
        if(matrix.get(0) != null){
            horizontalSize = matrix.get(0).size();
        }
        
        for(int j =0 ;j < horizontalSize ;j++) {
            
            int min_col = Integer.MAX_VALUE;
            int max_col = Integer.MIN_VALUE;
            int minCount = 0;
            int maxCount = 0;
            
            for(int i = 0; i < matrixSize; i++) {
                System.out.print(matrix.get(i).get(j) + " ");
                int num = matrix.get(i).get(j);
                if(num < min_col) {
                    min_col = num;
                }
                
                if(num > max_col) {
                    max_col = num;
                }
            }
            
            
            for(int i = 0; i < matrixSize; i++) {
                int num = matrix.get(i).get(j);
                if(num == min_col) {
                    minCount++;
                }
                
                if(num == max_col) {
                    maxCount++;
                }
            }
            
            if(minCount > 1 || maxCount > 1) {
                return true;
            }
            
            Integer columnNumber = j;
            Counts countElement = new Counts(min_col, max_col);
            String res = new String("col_" +columnNumber.toString());
            System.out.println("res "+ res + " counts " + countElement); 
            hm.put(res, countElement);
            System.out.println();
        }        
        return false;
    }

    static int TraverseAndFindCount(List<List<Integer>> matrix) {
        int sum = 0;
        
        Boolean isDuplicateInRow = findMinsAndMaxInRow(matrix);
        Boolean isDuplicateInCol = findMinsAndMaxInColumn(matrix);
        
        if(isDuplicateInRow || isDuplicateInCol) {
            return -1;
        }
        
        for(int i =0 ;i < matrix.size(); i++){
            List<Integer> row = matrix.get(i);
            
            for(int j =0 ; j < row.size(); j++) {
                int num = row.get(j);
                Integer rowNumber = i;
                Integer columnNumber = j;
                
                Counts getRowElement = hm.get("row_"+rowNumber.toString());
                Counts getColElement = hm.get("col_"+columnNumber.toString());
                
                System.out.println("num " + num + " " + getRowElement + " " + getColElement);
                // if(getRowElement.min == getColElement.min || getRowElement.max == getColElement.max) {
                //     sum++;        
                // }
                
                if(num == getRowElement.min || num == getRowElement.max || num == getColElement.min || num == getColElement.max) {
                    sum++;
                }
            }
            
        }
        
        return sum;
    }

    static int countSpecialElements(List<List<Integer>> matrix) {
        return TraverseAndFindCount(matrix);
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

        int res = countSpecialElements(matrix);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}