package java_level2;

import java.util.*;

// 1. 도넛과 막대 그래프
class DonutAndStickGraph {
    public int[] solution(int[][] edges) {
        Map<Integer, Integer> out = new HashMap<>();
        Map<Integer, Integer> in = new HashMap<>();
        int[] answer = new int[4];

	// 1번
        for (int[] edge : edges) {
            out.put(edge[0], out.getOrDefault(edge[0], 0) + 1);
            in.put(edge[1], in.getOrDefault(edge[1], 0) + 1);
        }

	// 2번
        for (int node : out.keySet()) {
            if (out.get(node) > 1) {
                if (!in.containsKey(node)) {
                    answer[0] = node;
                } else {
                    answer[3] += 1;
                }
            }
        }

	// 3번
        for (int node : in.keySet()) {
            if (!out.containsKey(node)) {
                answer[2] += 1;
            }
        }
        
        // 4번
        answer[1] = out.get(answer[0]) - answer[2] - answer[3];
        return answer;
    }
}
