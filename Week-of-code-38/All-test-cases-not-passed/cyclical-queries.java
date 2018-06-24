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
    }

    static class Graph {
        
        int vertices;
        int expectedVertices;
        int currAddCount;
        long maxDistance = -1;
        LinkedList<Edge> [] adjacencyList;

        Graph(int expectedVertices, int vertices) {
            this.expectedVertices = expectedVertices;
            this.vertices = vertices;
            this.currAddCount = 0;
            adjacencyList = new LinkedList[expectedVertices + 1];

            for(int i = 1 ;i <= expectedVertices; i++) {
                adjacencyList[i] = new LinkedList<Edge>();
            }
        }

        public void addEdge(int source, int destination, long weight) {
            Edge edge = new Edge(source, destination, weight);
            adjacencyList[source].add(edge);
            this.currAddCount++;
            if(this.currAddCount > this.vertices) {
                this.vertices = currAddCount;
            }
        }

        public void printGraph() {
            for(int i = 1; i <= vertices; i++) {
                LinkedList<Edge> temp = adjacencyList[i];
                System.out.println("i " + i );
                if(i ==  6) {
                    System.out.println(temp);
                }
                for(int j = 0 ; j < temp.size(); j++) {
                    Edge edge = temp.get(j);
                    System.out.println("source "+ i + " destination " + edge.destination + " weight " + edge.weight);
                }
            }
        }
        
        public int findFarthestEdge(int source) {
            System.out.println();
            System.out.println("Calling bfs for " + source);
            int farthestEdge = bfs(source);
            System.out.println("farthest edge is " + farthestEdge);
            return farthestEdge;
        }
        
        public void printArray(int []arr) {
            for(int i = 0; i < arr.length; i++) {
                System.out.println("i " + arr[i]);
            }
        }
        
        public int bfs(int source) {
            this.maxDistance = -1;
            int[] EdgeTo = new int[this.vertices + 1];
            Boolean [] visited= new Boolean[this.vertices + 1];
            Arrays.fill(visited, false);
            long[] weights  = new long[this.vertices + 1]; 
            Arrays.fill(weights, 0);

            Queue<Integer> q = new LinkedList<Integer>();
            
            q.add(source);
            
            while(!q.isEmpty()) {
                Integer w = q.remove();
                
                for(Edge v : adjacencyList[w]) {
                    // System.out.println("Edge " + v.source + " destination "+ v.destination);
                    if(!(visited[v.destination])){
                        q.add(v.destination);
                        visited[v.source] = true;
                        EdgeTo[v.destination] = w;
                        weights[v.destination] = v.weight;
                    }
                    
                }
            }
            
            // printArray(EdgeTo);
            long distance = -1;
            int nodeNumber = -1;
            
            for(int i = 1; i <= this.vertices; i++) {
                if(i != source) {
                    distance = findDistanceFromSource(source, i, EdgeTo, weights);
                    System.out.println("Distance of " +  i + " to " + source +" is " + distance);
                    if(distance >= this.maxDistance) {
                        this.maxDistance = distance;
                        nodeNumber = i;
                    }
                }
            }
            
            return nodeNumber;
                
        }
        
        
        public long findDistanceFromSource(int toFind,int tempNode, int []EdgeTo , long[] weights) {
            System.out.println("trying to ifind distance from source toFind " + toFind + " tempNode "+ tempNode );
            int temp = 0;
            long totalDistance = 0;
            Boolean sourceFound = false;
            
            temp = tempNode;
            
            while(!sourceFound) {
                System.out.println("calling");
                int x = EdgeTo[temp];
                totalDistance = totalDistance + weights[temp];
                temp = x;
                
                if(temp == toFind) {
                    sourceFound = true;
                }
            }
            
            return totalDistance;
        }
        
        public void deleteNode(int parentNode, int nodeToDelete) {
            System.out.println("ParentNode " + parentNode + " nodeToDel " + nodeToDelete);
            LinkedList<Edge> temp = adjacencyList[parentNode];
            for(int i = 0; i < temp.size(); i++) {
                    System.out.println("Searching through source " + temp.get(i).source  + " destination " + temp.get(i).destination);
                if(temp.get(i).destination == nodeToDelete) {
                    System.out.println("Deleting an edge with source " + temp.get(i).source  + " destination " + temp.get(i).destination);
                    temp.remove(temp.get(i));
                    this.vertices--;   
                }
            }
            
        }
        

    }
    
    
    
    // Complete the cyclicalQueries function below.
    static long[] cyclicalQueries(long[] w, int m) {
        // Return the list of answers to all queries of type 4. Take the query information from standard input.
        int vertices = w.length;
        ArrayList<Long> arrayList = new ArrayList<Long>();
        Graph gh = new Graph(vertices + m, vertices); // since increasing the size of adjacecny list at run time is costly. Taking a risk of assiging preHand.
        
        for(int i = 1; i < vertices;i++) {
            gh.addEdge(i , i + 1, w[i]);
        }
        gh.addEdge(vertices, 1, w[vertices - 1]);
        
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
        int source = -1;
        int farthestNode = -1;
        long weight = 0;
        
        for(int i = 0; i < m; i++) {
            int next = scanner.nextInt();
            
            switch(next) {
                case 1:
                    System.out.println("got 1");
                    source = scanner.nextInt();
                    farthestNode = gh.findFarthestEdge(source);
                    weight = scanner.nextLong();
                    vertices = vertices + 1;
                    hm.put(vertices, farthestNode);
                    gh.addEdge(farthestNode, vertices,weight);
                    break;
                case 2:
                    System.out.println("got 2");
                    source = scanner.nextInt();
                    weight = scanner.nextLong();
                    vertices = vertices + 1;
                    hm.put(vertices, source);
                    gh.addEdge(source, ++vertices, weight);
                    break;
                case 3:
                    System.out.println("got 3");
                    source = scanner.nextInt();
                    farthestNode = gh.findFarthestEdge(source);
                    System.out.println("Trying to delete node " + farthestNode);
                    int parentNode = hm.get(farthestNode);
                    gh.deleteNode(parentNode, farthestNode);
                    break;
                case 4:
                    System.out.println("got 4");
                    farthestNode = gh.findFarthestEdge(scanner.nextInt());
                    arrayList.add(gh.maxDistance);
                    break;
                default :
                    System.out.println("Should not come here");
                    break;
            }
        }
        
        long [] res = new long[arrayList.size()];
        for(int i = 0; i < arrayList.size(); i++) {
            res[i] = arrayList.get(i);
        }
        
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] w = new long[n];

        String[] wItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long wItem = Long.parseLong(wItems[i]);
            w[i] = wItem;
        }

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] result = cyclicalQueries(w, m);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
