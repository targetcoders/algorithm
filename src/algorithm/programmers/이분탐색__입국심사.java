package algorithm.programmers;

import java.util.Arrays;

// Programmers 43238 - 입국심사
public class 이분탐색__입국심사 {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 1;
        Arrays.sort(times);
        long right = (long)times[times.length-1] * n;

        while (left <= right) {
            long mid = (left + right) / 2; //입국 심사에 필요한 최대 시간

            //mid에 할당된 시간 안에 몇 명의 사람을 입국심사 할 수 있는지 계산
            long passedPerson = 0;
            for (int time : times) {
                passedPerson += mid / time;
            }

            if (passedPerson < n) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }

        return answer;
    }
}
