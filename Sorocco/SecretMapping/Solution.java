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

 static int compute_distinct_homonyms(List<String> secret_mapping, List<String> word_list) {
        
        int secretLength = secret_mapping.size();
        int wordListLength = word_list.size();
        Set<String> set = new HashSet();
        
        for(int i = 0; i < wordListLength; i++) {
            String word = word_list.get(i);
            String temp = "";
            for(int j = 0; j < word.length();j++) {
                temp = temp + secret_mapping.get(word.charAt(j) - 'a');
            }
            
            set.add(temp);
        }
        
        return set.size();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int secret_mappingCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> secret_mapping = new ArrayList<>();

        IntStream.range(0, secret_mappingCount).forEach(i -> {
            try {
                secret_mapping.add(bufferedReader.readLine());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int word_listCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> word_list = new ArrayList<>();

        IntStream.range(0, word_listCount).forEach(i -> {
            try {
                word_list.add(bufferedReader.readLine());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = compute_distinct_homonyms(secret_mapping, word_list);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
