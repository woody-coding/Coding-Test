package java_level2;

import java.util.*;

// DFS 예시코드
public class DFS {

    // DFS 탐색을 시작하는 메서드
    public static List<Integer> dfs(HashMap<Integer, List<Integer>> graph, int startNode) {
        // 방문한 노드를 저장할 리스트 초기화
        List<Integer> visited = new ArrayList<>();
        // DFS 재귀 함수를 호출하여 탐색 시작
        dfsRecursive(graph, startNode, visited);
        // 탐색이 완료된 후, 방문한 노드 리스트 반환
        return visited;
    }

    
    // 실제 DFS 탐색을 수행하는 재귀 메서드
    private static void dfsRecursive(HashMap<Integer, List<Integer>> graph, int node, List<Integer> visited) {
        // 현재 노드를 방문 처리 (방문 리스트에 추가)
        visited.add(node);

        // 현재 노드와 연결된 인접 노드들을 가져옴
        List<Integer> neighbors = graph.get(node);
        // 인접 노드가 존재할 경우에만 순회
        if (neighbors != null) {
            // 인접 노드들을 순회
            for (int neighbor : neighbors) {
                // 인접 노드가 아직 방문하지 않은 노드인 경우
                if (!visited.contains(neighbor)) {
                    // 해당 인접 노드를 시작점으로 재귀적으로 DFS 호출
                    dfsRecursive(graph, neighbor, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        // 그래프 예시 (인접 리스트 방식)
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(4, 5));
        graph.put(3, Arrays.asList(6));
        graph.put(4, Arrays.asList());
        graph.put(5, Arrays.asList());
        graph.put(6, Arrays.asList());

        // DFS 실행 (시작 노드는 1)
        List<Integer> visitedNodes = dfs(graph, 1);

        // 결과 출력
        System.out.println("DFS 순회 결과: " + visitedNodes);
    }
}