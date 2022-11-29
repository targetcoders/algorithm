package algorithm.boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// BOJ 1260 - DFS와 BFS
public class BFS와_DFS {

    private static final Queue<Integer> q = new LinkedList<>();
    private static int N, M, V;
    private static int[][] arr;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        arr = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i=1; i<=M ;i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            arr[r][c] = arr[c][r] = 1;
        }

        dfs(V);
        System.out.println();

        for (int i=1; i<=N; i++) {
            visited[i] = false;
        }

        q.add(V);
        visited[V] = true;
//        bfs();
        bfs2();
    }

    // 재귀 함수로 구현한 DFS
    private static void dfs(int v) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        System.out.print(v + " ");

        for (int i=1; i<=N; i++) {
            if (arr[v][i] == 1) {
                dfs(i);
            }
        }
    }

    // 재귀 함수로 구현한 BFS
    private static void bfs() {
        if (q.isEmpty()) {
            return;
        }

        int v = q.poll();
        System.out.print(v + " ");

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && 1 == arr[v][i]) {
                visited[i] = true;
                q.add(i);
            }
        }
        bfs();
    }

    // while 문으로 구현한 BFS
    private static void bfs2() {
        while (!q.isEmpty()) {
            int v = q.poll();
            System.out.print(v + " ");

            for (int i=1; i<=N; i++) {
                if (!visited[i] && arr[v][i] == 1) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
