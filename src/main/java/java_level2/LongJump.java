package java_level2;

// 5. 멀리뛰기
// 피보나치 수열 생각하는 것이 포인트
public class LongJump {
    public long solution(int n) {
        if (n <= 2) return n;
        
        long[] dp = new long[n+1];
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        
        return dp[n];
    }

}
