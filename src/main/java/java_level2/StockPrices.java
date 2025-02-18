package java_level2;

import java.util.*;

// 7. 주식가격
public class StockPrices {

    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = n - index - 1;
        }

        return answer;
    }
    

    public int[] solution2(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        int i, j;
        for (i = 0; i < len; i++) {
            for (j = i + 1; j < len; j++) {
                answer[i]++;
                if (prices[i] > prices[j])
                    break;
            }
        }
        return answer;
    }

	public static void main(String[] args) {
		
		int []array = {1, 2, 3, 2, 3};
		StockPrices sp = new StockPrices();
		
		for(int answer : sp.solution(array)) {
			System.out.println(answer);
		}
		
		System.out.println("====================================");
		
		for(int answer : sp.solution2(array)) {
			System.out.println(answer);
		}
	}
}
