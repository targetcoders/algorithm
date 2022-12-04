package algorithm.programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

// Programmers 42627 - 디스크 컨트롤러
public class 힙__디스크_컨트롤러 {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Arrays.sort(jobs, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
/*
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
*/

        int jobIndex = 0;
        int time = jobs[0][0];
        while (!pq.isEmpty() || jobIndex < jobs.length) {

            for (int i = jobIndex; i < jobs.length; i++) {
                if (time >= jobs[i][0]) {
                    pq.add(new Pair(jobs[i][0], jobs[i][1]));
                    jobIndex += 1;
                }
            }

            if (pq.isEmpty()) {
                time = jobs[jobIndex][0];
            } else {
                Pair p = pq.poll();
                time += p.endTime;
                answer += time - p.startTime;
            }
        }

        return answer/jobs.length;
    }

    static class Pair implements Comparable<Pair> {
        public int startTime;
        public int endTime;
        Pair(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Pair p) {
            return Integer.compare(endTime, p.endTime);
        }
    }
}
