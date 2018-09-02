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
 static int islandCount = 0;
    
    static Boolean isNotVisited(int i ,int j, int [][]matrix) {
        return matrix[i][j] == 0;
    }

    static Boolean isEligible(int nextRow, int nextCol,List<String> board, int [][]matrix ,int matrixBreadth, int matrixLength) {
        System.out.println(" In is Eligible nextRow" + nextRow + " matrixLength " + matrixLength  );
        
        if(nextRow >= 0 && nextRow <  matrixLength && nextCol >= 0 && nextCol < matrixBreadth) {
            if( board.get(nextRow).charAt(nextCol) == 'X'  && isNotVisited(nextRow, nextCol, matrix)) {
                return true;
            }
        }
        return false;
    }

    static void dfs(int row , int col, List<String> board, int [][]matrix ,int matrixBreadth, int matrixLength) {
        int []horArray = {0, -1, 0, 1};
        int []verArray = {-1, 0, 1, 0};
        matrix[row][col] = islandCount;
        
        for(int i = 0;i < 4;i++) {
            int nextRow = row + horArray[i];
            int nextCol = col + verArray[i];
            
            System.out.println("next Row " + nextRow + " nextCol " + nextCol);
            if(isEligible(nextRow, nextCol, board, matrix, matrixBreadth,matrixLength )) {
                System.out.println(" i am eligible");
                dfs(nextRow, nextCol,board, matrix, matrixBreadth, matrixLength );
            }
        }
    }    

    //Classic case of number of disconnected islands. Will be using dfs. Only difference is what to consider an island.
    static int numberOfWalls(List<String> board) {
        int matrixBreadth = board.get(0).length();
        int matrixLength = board.size();

        int [][]matrix = new int[matrixLength][matrixBreadth];
        
        for(int i = 0 ;i < matrixLength; i++) {
            Arrays.fill(matrix[i], 0);
        }
        
        for(int i = 0; i < matrixLength ;i++) {
            for(int j = 0; j < matrixBreadth ; j++) {
                if(board.get(i).charAt(j) == 'X' && isNotVisited(i, j, matrix)) {
                    islandCount++;
                    
                    System.out.println("calling dfs for this row " + i + "  col "+ j);
                    dfs(i,j, board,matrix, matrixBreadth, matrixLength );
                }
            }
        }
        
        return islandCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int boardCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> board = new ArrayList<>();

        IntStream.range(0, boardCount).forEach(i -> {
            try {
                board.add(bufferedReader.readLine());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = numberOfWalls(board);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
