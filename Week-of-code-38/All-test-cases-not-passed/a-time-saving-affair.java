import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class Edge {
        int source;
        int destination;
        long weight;
        
        Edge(int source, int destination, long weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
        
        public String toString() {
            return "Source " + source + " destination " + destination + " weight " + weight;
        }
    }
    
    static class Graph {
        LinkedList<Edge> []adj;
        Boolean [] visited;
        int vertices;
        long minTime = Long.MAX_VALUE;
        
        Graph(int vertices) {
            this.vertices = vertices;
            this.adj = new LinkedList[vertices + 1];
            this.visited = new Boolean[vertices + 1];
            
            for(int i = 1; i <= vertices; i++) {
                this.adj[i] = new LinkedList<Edge>();
            }
            Arrays.fill(this.visited, false);
        }
        
        public void addEdge(int source, int destination, long weight) {
            Edge edge1 = new Edge(source, destination, weight);
            Edge edge2 = new Edge(destination, source, weight);
            
            // System.out.println("adding for " + source + " edge " + edge1);
            adj[source].add(edge1);
            
            adj[destination].add(edge2);
        }
        
        public void printGraph() {
            for(int i = 1; i <= vertices; i++) {
                LinkedList<Edge> temp = adj[i];
                System.out.println("i " + i );

                for(int j = 0 ; j < temp.size(); j++) {
                    Edge edge = temp.get(j);
                    System.out.println("source "+ i + " destination " + edge.destination + " weight " + edge.weight);
                }
            }
        }
        
        public long dfs(int source, int destination,int timeInterval) {
            dfs(source, destination, 0 ,timeInterval );
            return this.minTime;
        }
        
        private void dfs(int source, int endPoint,long currTime, int timeInterval) {
            
            visited[source] = true;
            
            if(source == endPoint) {
                if(currTime < minTime) {
                    minTime = currTime;
                }
            }
            // System.out.println("source " + source + " destination " + endPoint + " cur " + currTime + " time " + timeInterval);
            if(currTime != 0 && ((currTime / timeInterval) % 2 == 1)) { //red
                currTime = currTime + (timeInterval - (currTime % timeInterval));
            }
            
            
            for(Edge temp : adj[source]) {
                if(!visited[temp.destination]) {
                    // System.out.println("calling " + temp.destination);
                    dfs(temp.destination, endPoint, currTime + temp.weight, timeInterval);
                }
            }
            
            
        }
    }
    
    
    // Complete the leastTimeToInterview function below.
    static long leastTimeToInterview(int n, int k, int m) {
        // Return the least amount of time needed to reach the interview location in seconds.
        int endPoint = n;
        int startPoint = 1;
        Graph gh = new Graph(n);
        
        for(int i = 0 ;i < m; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            int weight = scanner.nextInt();
            // System.out.println("Adding source "+ source + " destination "+ destination + " weight "+ weight);

            gh.addEdge(source, destination, weight);
        }
        
        // gh.printGraph();
         return gh.dfs(startPoint, endPoint, k);
        // return 1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = leastTimeToInterview(n, k, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
