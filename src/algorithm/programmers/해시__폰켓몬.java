package algorithm.programmers;

import java.util.HashMap;
import java.util.Map;

// Programmers 1845 - 폰켓몬
public class 해시__폰켓몬 {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        return Math.min(nums.length / 2, map.size());
    }
}
