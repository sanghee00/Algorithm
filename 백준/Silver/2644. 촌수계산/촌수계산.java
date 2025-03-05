import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static List<Integer>[] adjList;
    static int cnt;
    static int result = -1;
    static int end;

    public static void solution(int n, int[][] graph, int start) {
        adjList = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] i : graph) {
            adjList[i[0]].add(i[1]);
            adjList[i[1]].add(i[0]);
        }

        dfs(start);
    }

    public static void dfs(int start) {
        visited[start] = true;
        if (start == end) {
            result = cnt;
            return;
        }

        for (int n : adjList[start]) {
            if (!visited[n]) {
                cnt++;
                dfs(n);
                cnt--;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 전체 사람 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int person1 = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine()); // 관계의 수

        int[][] graph = new int[m][2];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
        }

        solution(n, graph, person1);
        System.out.println(result);
    }
}
