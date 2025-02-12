package java_level2;

// 2. 당구 연습
public class BilliardsPractice {
	
    // 결과를 저장할 배열을 생성. 길이는 목표 공의 개수와 같다.
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {

        int[] answer = new int[balls.length];

        // 각 목표 공에 대해 계산을 수행한다.
        for(int i = 0; i < balls.length; i++){
            int tmpX; // 쿠션 후 x좌표를 저장할 변수
            int tmpY; // 쿠션 후 y좌표를 저장할 변수

            // 시작점과 목표점의 x좌표가 같은 경우 (수직선상에 있는 경우)
            if(balls[i][0] == startX){
                // 오른쪽 벽과 왼쪽 벽 중 더 가까운 쪽으로 쿠션
                tmpX = m - balls[i][0] < balls[i][0] ? m + (m - balls[i][0]) : -balls[i][0];
                // y축 방향으로는 위쪽 벽으로만 쿠션 (아래쪽은 직선 경로가 되므로 제외)
                tmpY = startY > balls[i][1] ? n + (n - balls[i][1]) : -balls[i][1];
            }
            // 시작점과 목표점의 y좌표가 같은 경우 (수평선상에 있는 경우)
            else if(balls[i][1] == startY){
                // 위쪽 벽과 아래쪽 벽 중 더 가까운 쪽으로 쿠션
                tmpY = n - balls[i][1] < balls[i][1] ? n + (n - balls[i][1]) : -balls[i][1];
                // x축 방향으로는 오른쪽 벽으로만 쿠션 (왼쪽은 직선 경로가 되므로 제외)
                tmpX = startX > balls[i][0] ? m + (m - balls[i][0]) : -balls[i][0];
            }
            // 그 외의 경우 (대각선 방향에 있는 경우)
            else{
                // x축 방향으로 더 가까운 벽으로 쿠션
                tmpX = (startX + balls[i][0]) < (m - startX) + (m - balls[i][0]) ? -balls[i][0] : m + (m - balls[i][0]);
                // y축 방향으로 더 가까운 벽으로 쿠션
                tmpY = (startY + balls[i][1]) < (n - startY) + (n - balls[i][1]) ? -balls[i][1] : n + (n - balls[i][1]);
            }

            // 수직 방향 쿠션 거리 계산 (피타고라스 정리 사용)
            int res1 = (startX - balls[i][0]) * (startX - balls[i][0]) + (startY - tmpY) * (startY - tmpY);
            // 수평 방향 쿠션 거리 계산 (피타고라스 정리 사용)
            int res2 = (startX - tmpX) * (startX - tmpX) + (startY - balls[i][1]) * (startY - balls[i][1]);
            
            // 두 거리 중 더 짧은 것을 선택하여 결과 배열에 저장
            answer[i] = res1 > res2 ? res2 : res1;
        }

        // 계산된 결과 배열 반환
        return answer;
    }
}