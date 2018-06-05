// Sharon wants to buy a laptop for programming. She plans on buying a laptop whose price is made of digits 4 and 7 only. The number of 4s and 7s in the price should be equal. You are given laptop brand names and their prices. Find and print the name of the laptop brand that satisfies the above criteria. If there are multiple brands that meet the criteria, print the name of the one with the minimum price. If none of the laptops meet the criteria print -1.

// For example, if Sharon has a choice between laptops 'BestBook' priced at 444777 and 'LapBook' priced at 7744, the solution should indicate ideal choice to be 'LapBook'. Although both 'BestBook' and 'LapBook' have equal number of 4s and 7s in the price, 'LapBook' is priced lower which makes it the right choice for Sharon.

// Input Format

// The first line contains an integer , denoting the number of laptops. 
// The next  lines contains one string (name of company laptop) and an integer describing the value of each laptop.

// Constraints

// name of laptop consists of English letters only.
// Both name and price for laptops are unique.

// Output Format

// If answer doesn't exist, print -1. 
// Otherwise, print the name of the brand whose laptop costs the least (minimum lucky number) and meets the required criteria.

// Sample Input 0

// 4
// HackerBook 777444
// RankBook 3
// TheBook 777
// BestBook 47
// Sample Output 0

// BestBook

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String res = new String("-1");
        long MIN_VAL = Long.MAX_VALUE;
        
        for(int a0 = 0; a0 < n; a0++){
            String name = in.next();
            long value = in.nextLong();
            long temp = value;
            long remainder;
            boolean flag = false;
            int count_four = 0;
            int count_seven = 0;
            
            while(temp != 0){
                remainder = temp % 10;
                if(remainder == 4){
                    count_four++;
                }else if(remainder == 7){
                    count_seven++;
                }else{
                    flag = true;
                    break;
                }
                
                
                temp = temp/10;
            }
         //   System.out.println(count_four + "  " +  count_seven + " " + flag + " " + value ); 
            if((count_four == count_seven) && (!flag) &&(value < MIN_VAL) ){
                MIN_VAL = value;
                res = name;
            }
    
        }
        
        System.out.println(res);
        in.close();
    }
}
