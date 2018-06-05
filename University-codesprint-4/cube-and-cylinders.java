// You are in charge of storing some of the inventory in a company. There are different types of packages. The total number of packages and the number of packages of each type is known to you. Also, each package is cube-shaped, with edge length given.

// Packages can only be stored in cylindrical containers which have a circular opening of given radius. Each container can hold a particular number of packages. We may assume that each container is tall enough that it can accommodate the total height of all the packages.

// As part of company policy, you must ensure the following holds:

// Each package can only be kept on top of another package.
// The package must not touch the sides of the cylinder, even at a single point. The packages may touch boundaries with each other or with the base of the cylinder.
// You have to choose which packages go into which containers. Discard packages that can't be stored.

// image

// What is the maximum number of packages that can be put in the containers?

// Complete the function maximumPackages which takes in four arrays

// , denoting the edge-lengths of each package type,
// , denoting the number of copies of each package type,
// , denoting the radius of the opening of each container, and
// , denoting the number of packages each container can contain,
// and returns a single integer denoting the answer.

// Input Format

// The first line contains two space-separated positive integers , denoting number of types of packages, and , denoting number of cylindrical containers.

// The second line contains  space-separated positive integers , where  represents the edge-length of the  package type.

// The third line contains  space-separated non-negative integers , where  represents the number of copies of  package type.

// The fourth line contains  space-separated positive integers , where  represents the radius of the opening of the  cylinder.

// The fifth line contains  space-separated positive integers , where  represents the capacity of the cylinder.

// Constraints

// All the given  and  are unique.
// Output Format

// Print a single integer denoting the maximum number of packages that can be put inside the cylinders, provided they remain intact on one top of another and do not touch the circumference of the cylinder in which they are put.

// Sample Input 0

// 2 2
// 1 2
// 1 1
// 1 2
// 1 1
// Sample Output 0

// 2



import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.Arrays;
import java.util.Collections;

public class Solution {


    /*
     * Complete the function below.
     */
    static int maximumPackages(ArrayList<Double> diagonalLength, ArrayList<Integer> numberOfCopies, ArrayList<Integer> diameter, ArrayList<Integer> containerCapacity) {
        
        HashMap<Double, Integer> cubes = new HashMap<Double, Integer>();
        HashMap<Integer, Integer> cylinders = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < diagonalLength.size(); i++){
            cubes.put(diagonalLength.get(i), numberOfCopies.get(i));
        }

        for(int i = 0; i < diameter.size(); i++){
            cylinders.put(diameter.get(i), containerCapacity.get(i));
        }
        
        Collections.sort(diagonalLength, Collections.reverseOrder());
        Collections.sort(diameter, Collections.reverseOrder());
        
        int cylinderIndex = 0;
        int result = 0;
        
        for(int i = 0;i < diagonalLength.size(); i++){
            int numberOfCubes = cubes.get(diagonalLength.get(i));
            // boolean Continue = true;
            
            while(numberOfCubes > 0 && cylinderIndex < diameter.size()){
                if(diagonalLength.get(i) >= diameter.get(cylinderIndex)){
                    break;
                }
                
                if((diagonalLength.get(i) < diameter.get(cylinderIndex)) && (cylinders.get(diameter.get(cylinderIndex)) > 0)){
                    result++;
                    numberOfCubes--;
                    cylinders.put(diameter.get(cylinderIndex),cylinders.get(diameter.get(cylinderIndex)) - 1);
                }else if(cylinders.get(diameter.get(cylinderIndex)) == 0){
                    cylinderIndex++;
                }
                
            }    
        }
        
        return result;
    }



    public static void main(String[] args) throws IOException {
       Scanner scan = new Scanner(System.in);
        
        int packages = scan.nextInt();
        int cylinders = scan.nextInt();
        
        ArrayList<Double> diagonalLength = new ArrayList<Double>();
        ArrayList<Integer> numberOfCopies = new ArrayList<Integer>();
        ArrayList<Integer> diameter = new ArrayList<Integer>();
        ArrayList<Integer> containerCapacity = new ArrayList<Integer>();

        for(int i = 0; i < packages;i++){
            diagonalLength.add(scan.nextInt() * Math.sqrt(2));
        }
        
        for(int i = 0; i < packages;i++){
            numberOfCopies.add(scan.nextInt());
        }

        for(int i = 0; i < cylinders;i++){
            diameter.add(scan.nextInt() * 2);
        }
        
        for(int i = 0; i < cylinders;i++){
            containerCapacity.add(scan.nextInt());
        }
        
        // System.out.println(diagonalLength);
        
        System.out.println(maximumPackages(diagonalLength,numberOfCopies, diameter, containerCapacity));
    }
}
