package java_level2;

import java.util.*;

// 6. 할인 행사
public class DiscountEvent {

	    public int solution(String[] want, int[] number, String[] discount) {
	        int answer = 0;
	        Map<String, Integer> wantMap = new HashMap<>();
	        
	        // want 항목과 필요한 개수를 HashMap에 저장
	        for (int i = 0; i < want.length; i++) {
	            wantMap.put(want[i], number[i]);
	        }
	        
	        // 슬라이딩 윈도우 적용
	        for (int i = 0; i <= discount.length - 10; i++) {
	            Map<String, Integer> windowMap = new HashMap<>();
	            
	            // 현재 윈도우의 상품 개수 계산
	            for (int j = i; j < i + 10; j++) {
	                windowMap.put(discount[j], windowMap.getOrDefault(discount[j], 0) + 1);
	            }
	            
	            // 원하는 상품 조건을 만족하는지 확인
	            if (checkCondition(wantMap, windowMap)) {
	                answer++;
	            }
	        }
	        
	        return answer;
	    }
	    
	    // 원하는 상품 조건을 만족하는지 확인하는 메서드
	    private boolean checkCondition(Map<String, Integer> want, Map<String, Integer> window) {
	        for (String key : want.keySet()) {
	            if (!window.containsKey(key) || window.get(key) < want.get(key)) {
	                return false;
	            }
	        }
	        return true;
	    }
	


	public static void main(String[] args) {
		String []want = {"banana", "apple", "rice", "pork", "pot"};
		int []number = {3, 2, 2, 2, 1};
		String []discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
		
		DiscountEvent de = new DiscountEvent();
		
		System.out.println(de.solution(want, number, discount));
	}

}
