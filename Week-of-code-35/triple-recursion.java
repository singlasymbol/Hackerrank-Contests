// You are filling a matrix by following a set of rules. Given a square matrix of size , where  is its upper-left cell and  is its bottom-right cell, fill all the cells according to the following rules:

// Value of  is defined recursively as follows:

// if  and  then 
// else if  then 
// else if  then 
// else, if , then 
// In other words, given integers  and , the matrix is filled by putting  in the upper-left cell, and then every other cell  on the main diagonal of the matrix is filled with the value . Remaining cells of the matrix are filled according to the two other recursive rules defined above.

// For example, for , , , the matrix will be:-

// 3 2 1 0
// 2 4 3 2
// 1 3 5 4
// 0 2 4 6
// The task is to print the matrix after all its cells are filled with values.

// Input Format

// In the first and only line of the input, there are  space-separated integers , , and , where  is the size of the matrix and both  and  denote values used in the recursive definition in the statement.

// Constraints

// Output Format

// Output the matrix with exactly  lines. In the  line, print  space-separated integers denoting the  row of the matrix with all cells filled with appropriate values.

// Sample Input 0

// 5 10 7
// Sample Output 0

// 10 9 8 7 6
// 9 17 16 15 14
// 8 16 24 23 22
// 7 15 23 31 30
// 6 14 22 30 38
// Explanation 0

// See the color-coded illustration below for the right answer: image

// Sample Input 1

// 6 5 2
// Sample Output 1

// 5 4 3 2 1 0
// 4 7 6 5 4 3
// 3 6 9 8 7 6
// 2 5 8 11 10 9
// 1 4 7 10 13 12
// 0 3 6 9 12 15

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static void fillArray(int[][] arr,int size,int i,int j, int startingVal, int increment){
        
        if(i < 0 || i >= size || j < 0 || j >= size){
            return;
        }
        
        arr[i][j] = startingVal;
        fillAdjacentElements(arr,size,i,j,startingVal - 1,increment);
        fillArray(arr,size, i + 1, j + 1 ,startingVal + increment , increment);
    } 
    
    static void fillAdjacentElements(int [][]arr,int size, int x, int y,int currVal, int increment){
        
        if(x < 0 || x + 1 >= size || y < 0 || y +1 >= size){
            return;
        }
        
        arr[x][y + 1] = currVal;
        arr[y + 1][x] = currVal;
        
        fillAdjacentElements(arr,size,x,y + 1,currVal - 1,increment);
    }
    
    static void tripleRecursion(int size, int startingVal, int increment) {
        // Complete this function
        int [][] arr = new int[size][size];
        fillArray(arr,size, 0, 0 ,startingVal , increment);
        printArray(arr,size);
    }
    
    static void printArray(int [][]arr,int size){
        for(int i = 0; i< size; i++){
            for(int j =0 ;j < size;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        tripleRecursion(n, m, k);
        
        in.close();
    }
}
