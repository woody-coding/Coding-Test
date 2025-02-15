package java_level2;

import java.util.Arrays;

// 4. 최솟값 만들기
public class MinimumValueMaker {

    public int solution(int []A, int []B)
    {
        int answer = 0;
        int size = A.length-1;
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i=0; i <= size; i++) {
        	answer += A[i] * B[size-i];
        }

        return answer;
    }
	
	public static void main(String[] args) {
		MinimumValueMaker mvm = new MinimumValueMaker();

	}

}
