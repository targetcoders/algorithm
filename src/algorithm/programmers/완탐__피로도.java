package algorithm.programmers;

// Programmers 87946 - 피로도
public class 완탐__피로도 {

    private int answer = -1;
    private boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return answer;
    }

    private void dfs(int k, int[][] dungeons, int cnt) {
        if (k <= 0) {
            return;
        }

        for (int i=0; i<dungeons.length; i++) {
            int minimum = dungeons[i][0];
            int need = dungeons[i][1];
            if (!visited[i] && k >= minimum) {
                visited[i] = true;
                dfs(k-need, dungeons, cnt+1);
                visited[i] = false;
            }
        }
        if (answer < cnt) {
            answer = cnt;
        }
    }
}
