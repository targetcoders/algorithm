package algorithm.programmers;

import java.util.*;

// Programmers 138476 - 귤 고르기
public class 정렬__굴_고르기 {

    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1,3,2,5,4,5,2,3};
        System.out.println(solution(k, tangerine));
    }

    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int size : tangerine) {
            if (map.containsKey(size)) {
                map.put(size, map.get(size) + 1);
            } else {
                map.put(size, 1);
            }
        }

        List<Pair> list = new ArrayList<>();
        for (Integer key : map.keySet()) {
            list.add(new Pair(key, map.get(key)));
        }

        Collections.sort(list);

        int i=0;
        while (k > 0) {
            int number = list.get(i).value;
            answer += 1;
            if (number <= k) {
                k -= number;
            } else {
                break;
            }
            i++;
        }

        return answer;
    }

    private static class Pair implements Comparable<Pair> {
        public Integer key;
        public Integer value;

        public Pair(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            return o.value.compareTo(value);
        }

        @Override
        public String toString() {
            return "key="+key+", value="+value;
        }
    }

    //조합으로 풀면 시간 초과 발생
    public static void combination(int k, List<Integer> list, boolean[] visited, int[] tangerine) {
        if (list.size() == k) {
            // 서로 다른 종류의 수 최솟값 구하기
            Set<Integer> set = new HashSet<>(list);
            if (answer > set.size()) {
                answer = set.size();
            }
           return;
        }

        for (int i=0; i<tangerine.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(tangerine[i]);
                combination(k, list, visited, tangerine);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }
}
