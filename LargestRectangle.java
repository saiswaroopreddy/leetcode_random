import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class Solution {
    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
        HashMap<String, Integer> map = new HashMap<>();
        int[] res = new int[queries.length];
        int i = 0;
        for(String s : strings){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        for(String q : queries){
            if(map.containsKey(q)){
                res[i] = map.get(q);
            }else{
                res[i] = 0;
            }
            i++;
        }
        return res;
    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String[] strings = new String[stringsCount];
        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }
        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String[] queries = new String[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }
        int[] res = matchingStrings(strings, queries);
        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));
            if (i != res.length - 1) {
                bufferedWriter.write("\n");
            }
        }
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
Truck Tour
6:50
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
public class Solution {
    /*
     * Complete the truckTour function below.
     */
    static int truckTour(int[][] petrolpumps) {
        /*
         * Write your code here.
         */
        int start = 0;
        int end = 1;
        int current_petrol = petrolpumps[start][0] - petrolpumps[start][1];
        while(end!=start || current_petrol < 0){
            while(end!=start && current_petrol < 0){
                current_petrol -= petrolpumps[start][0] - petrolpumps[start][1];
                start = (start+1)%petrolpumps.length;
                if(start == 0){return -1;}
            }
            current_petrol += petrolpumps[end][0] - petrolpumps[end][1];
            end = (end+1)%petrolpumps.length;
        }
        return start;
    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = Integer.parseInt(scanner.nextLine().trim());
        int[][] petrolpumps = new int[n][2];
        for (int petrolpumpsRowItr = 0; petrolpumpsRowItr < n; petrolpumpsRowItr++) {
            String[] petrolpumpsRowItems = scanner.nextLine().split(" ");
            for (int petrolpumpsColumnItr = 0; petrolpumpsColumnItr < 2; petrolpumpsColumnItr++) {
                int petrolpumpsItem = Integer.parseInt(petrolpumpsRowItems[petrolpumpsColumnItr].trim());
                petrolpumps[petrolpumpsRowItr][petrolpumpsColumnItr] = petrolpumpsItem;
            }
        }
        int result = truckTour(petrolpumps);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
    }
}

Yash  10:19 AM
@channel
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        // boolean [][] visited = new boolean [m][n];
        Queue <int []> q = new LinkedList <>();
        int [][] dirs = {{0,1},{1,0}, {0, -1}, {-1, 0}};
        q.offer(start);
        maze[start[0]][start[1]] = 2;
        while(!q.isEmpty()){
            int [] top = q.poll();
            int r = top[0];
            int c = top[1];
            if(r == destination[0] && c == destination[1]) return true;
            for(int k = 0; k < dirs.length; k++){
                int i = r;
                int j = c;
                // Keep the ball rolling
                while(i >= 0 && j >= 0 && i < m && j < n && (maze[i][j] == 0 || maze[i][j] == 2)){
                    i += dirs[k][0];
                    j += dirs[k][1];
                }
                // bring back to stop point
                i -= dirs[k][0];
                j -= dirs[k][1];
                if(maze[i][j] != 2){
                    q.offer(new int [] {i,j});
                    maze[i][j] = 2; 
                }            }
        }
        return false;
    }
}
