package algorithm.programmers;

// Programmers 84512 - 모음사전
public class 완탐__모음사전 {

    private final char[] arr = {'A', 'E', 'I', 'O', 'U'};
    private int cnt = 0;
    private int answer = 0;

    public int solution(String word) {
        dfs(word, "");
        return answer;
    }

    public void dfs(String word, String w) {
        if (w.equals(word)) {
            answer = cnt;
            return;
        }

        for (char ch : arr) {
            if (w.length() <= 4) {
                cnt += 1;
                dfs(word, w + ch);
            }
        }
    }

}
