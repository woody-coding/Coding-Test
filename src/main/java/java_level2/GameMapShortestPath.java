package java_level2;

import java.util.*;

// 8. 게임 맵 최단거리
public class GameMapShortestPath {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        queue.offer(new int[]{0, 0, 1}); // x, y, distance
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            
            if (x == n - 1 && y == m - 1) {
                return distance;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.offer(new int[]{nx, ny, distance + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return -1; // 도착점에 도달할 수 없는 경우
    }
	
	public static void main(String[] args) {

	}

}
